package com.gaming.gamingsystem.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Date;

@Document(collection = "transactions")
public class Transactions {
    @Id private String id;
    @Field("memberId") private String memberId;
    @Field("gameId") private String gameId;
    private double amount;
    @Field("dateTime") private Date dateTime;

    public Transactions() {}
    public Transactions(String id, String memberId, String gameId, double amount, Date dateTime){
        this.id=id; this.memberId=memberId; this.gameId=gameId; this.amount=amount; this.dateTime=dateTime;
    }
    // getters/setters
    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getMemberId(){return memberId;} public void setMemberId(String memberId){this.memberId=memberId;}
    public String getGameId(){return gameId;} public void setGameId(String gameId){this.gameId=gameId;}
    public double getAmount(){return amount;} public void setAmount(double amount){this.amount=amount;}
    public Date getDateTime(){return dateTime;} public void setDateTime(Date dateTime){this.dateTime=dateTime;}
}
