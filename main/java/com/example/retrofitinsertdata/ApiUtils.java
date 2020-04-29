package com.example.retrofitinsertdata;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://ishakharide.000webhostapp.com/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}