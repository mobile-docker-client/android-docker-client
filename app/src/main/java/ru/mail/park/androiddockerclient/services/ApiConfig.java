package ru.mail.park.androiddockerclient.services;

public class ApiConfig {
    private String mBaseUrl;

    public ApiConfig(String baseUrl) {
        mBaseUrl = baseUrl;
    }


    public String getBaseUrl() {
        return mBaseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }
}
