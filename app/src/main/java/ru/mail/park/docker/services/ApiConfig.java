package ru.mail.park.docker.services;

public class ApiConfig {

    private String mBaseUrl;

    public ApiConfig(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return mBaseUrl;
    }

    @SuppressWarnings("unused")
    public void setBaseUrl(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }
}
