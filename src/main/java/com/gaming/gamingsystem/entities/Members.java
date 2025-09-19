package com.gaming.gamingsystem.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Date;

@Document(collection = "members")
public class Members {
    @Id private String id;
    @Field("member_id") private String memberId;
    private String name;
    private String phone;
    private double balance;
    @Field("joining_date") private Date joiningDate;

    public Members(){}
    public Members(String id, String memberId, String name, String phone, double balance, Date joiningDate){
        this.id=id; this.memberId=memberId; this.name=name; this.phone=phone; this.balance=balance; this.joiningDate=joiningDate;
    }
    // getters/setters
    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getMemberId(){return memberId;} public void setMemberId(String memberId){this.memberId=memberId;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getPhone(){return phone;} public void setPhone(String phone){this.phone=phone;}
    public double getBalance(){return balance;} public void setBalance(double balance){this.balance=balance;}
    public Date getJoiningDate(){return joiningDate;} public void setJoiningDate(Date joiningDate){this.joiningDate=joiningDate;}
}
