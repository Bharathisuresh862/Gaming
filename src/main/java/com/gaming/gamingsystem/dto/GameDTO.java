package com.gaming.gamingsystem.dto;
public class GameDTO {
    private String id; private String name; private String description; private double price;
    private int minCount; private int maxCount; private int duration; private int playerCount;
    public GameDTO() {}
    public GameDTO(String id,String name,String description,double price,int minCount,int maxCount,int duration,int playerCount){
        this.id=id; this.name=name; this.description=description; this.price=price; this.minCount=minCount; this.maxCount=maxCount; this.duration=duration; this.playerCount=playerCount;
    }
    // getters/setters (omitted for brevity, add them)
    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getDescription(){return description;} public void setDescription(String description){this.description=description;}
    public double getPrice(){return price;} public void setPrice(double price){this.price=price;}
    public int getMinCount(){return minCount;} public void setMinCount(int minCount){this.minCount=minCount;}
    public int getMaxCount(){return maxCount;} public void setMaxCount(int maxCount){this.maxCount=maxCount;}
    public int getDuration(){return duration;} public void setDuration(int duration){this.duration=duration;}
    public int getPlayerCount(){return playerCount;} public void setPlayerCount(int playerCount){this.playerCount=playerCount;}
}
