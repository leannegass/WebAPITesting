package com.sparta.leanne;

import com.fasterxml.jackson.annotation.JsonProperty;
public class ActivityPojo{
    @JsonProperty("activity")
    private String activity;
    @JsonProperty("accessibility")
    private Double accessibility;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("link")
    private String link;
    @JsonProperty("type")
    private String type;
    @JsonProperty("key")
    private String key;
    @JsonProperty("participants")
    private Integer participants;
    public String getActivity(){
        return activity;
    }
    public Double getAccessibility(){
        return accessibility;
    }
    public Double getPrice(){
        return price;
    }
    public String getLink(){
        return link;
    }
    public String getType(){
        return type;
    }
    public String getKey(){
        return key;
    }
    public Integer getParticipants(){
        return participants;
    }
}
