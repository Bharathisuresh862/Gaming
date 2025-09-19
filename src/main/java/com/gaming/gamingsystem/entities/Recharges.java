package com.gaming.gamingsystem.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Date;

@Document(collection = "recharges")
public class Recharges {
    @Id private String id;
    @Field("memberId") private String memberId;
    private double amount;
    @Field("dateTime") private Date dateTime;

    public Recharges() {}
    public Recharges(String id, String memberId, double amount, Date dateTime){ this.id=id; this.memberId=memberId; this.amount=amount; this.dateTime=dateTime; }
    // getters/setters
    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getMemberId(){return memberId;} public void setMemberId(String memberId){this.memberId=memberId;}
    public double getAmount(){return amount;} public void setAmount(double amount){this.amount=amount;}
    public Date getDateTime(){return dateTime;} public void setDateTime(Date dateTime){this.dateTime=dateTime;}
}
