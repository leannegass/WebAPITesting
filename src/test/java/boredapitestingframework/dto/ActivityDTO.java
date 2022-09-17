package boredapitestingframework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityDTO {
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

    public boolean keyHasSevenDigits(){
        return key.length() == 7;
    }
    public boolean hasActivity(){
        return activity != null;
    }





}
