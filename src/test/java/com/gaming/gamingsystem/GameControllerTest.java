package com.gaming.gamingsystem;

import com.gaming.gamingsystem.controllers.GameController;
import com.gaming.gamingsystem.entities.Game;
import com.gaming.gamingsystem.repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameRepository gameRepository;

    @Test
    void testGetAllGames() throws Exception {
        when(gameRepository.findAll()).thenReturn(
                List.of(
                        new Game("1", "Chess", "Classic board game", 0.0, 1, 2, 60, 2),
                        new Game("2", "Ludo", "Fun family game", 0.0, 2, 4, 45, 4)
                )
        );

        mockMvc.perform(get("/games").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].name").value("Chess"))
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].name").value("Ludo"));
    }

    @Test
    void testGetGameById() throws Exception {
        when(gameRepository.findById("1")).thenReturn(
                Optional.of(new Game("1", "Chess", "Classic board game", 0.0, 1, 2, 60, 2))
        );

        mockMvc.perform(get("/games/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Chess"));
    }
}
