package com.gaming.gamingsystem.dto;
import java.util.Date;
public class PlayedHistoryDTO {
    private String gameName;
    private double amount;
    private Date dateTime;
    public PlayedHistoryDTO() {}
    public PlayedHistoryDTO(String gameName, double amount, Date dateTime) { this.gameName=gameName; this.amount=amount; this.dateTime=dateTime; }
    // getters/setters
    public String getGameName(){return gameName;} public void setGameName(String gameName){this.gameName=gameName;}
    public double getAmount(){return amount;} public void setAmount(double amount){this.amount=amount;}
    public Date getDateTime(){return dateTime;} public void setDateTime(Date dateTime){this.dateTime=dateTime;}
}
