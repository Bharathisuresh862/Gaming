package com.gaming.gamingsystem.dto;
import com.gaming.gamingsystem.entities.Members;
import com.gaming.gamingsystem.entities.Recharges;
import java.util.List;

public class MemberProfileDTO {
    private Members member;
    private List<Recharges> rechargeHistory;
    private List<GameDTO> games;
    private List<PlayedHistoryDTO> playedHistory;

    public MemberProfileDTO() {}
    public MemberProfileDTO(Members member, List<Recharges> rechargeHistory, List<GameDTO> games, List<PlayedHistoryDTO> playedHistory){
        this.member = member; this.rechargeHistory = rechargeHistory; this.games = games; this.playedHistory = playedHistory;
    }
    // getters/setters
    public Members getMember(){return member;} public void setMember(Members member){this.member=member;}
    public List<Recharges> getRechargeHistory(){return rechargeHistory;} public void setRechargeHistory(List<Recharges> r){this.rechargeHistory=r;}
    public List<GameDTO> getGames(){return games;} public void setGames(List<GameDTO> g){this.games=g;}
    public List<PlayedHistoryDTO> getPlayedHistory(){return playedHistory;} public void setPlayedHistory(List<PlayedHistoryDTO> p){this.playedHistory=p;}
}
