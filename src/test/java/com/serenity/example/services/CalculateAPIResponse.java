package com.serenity.example.services;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CalculateAPIResponse{
    @SerializedName("postage_result")
    @Expose
    private Title title;

    public Title getTitle(){
        return title;
    }

    public class Title {
        @SerializedName("service")
        @Expose
        private String service;

        @SerializedName("total_cost")
        @Expose
        private String total_cost;


        public String getService(){
            return service;
        }

        public String getTotalCost(){
            return total_cost;
        }
    }
}
