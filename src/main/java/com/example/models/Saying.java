package com.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Saying {

    private String content;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(String content) {
        this.content = content;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }


}
