package api;


import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;


public class OpenWeatherAPI {
    public Object getRawData() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=0767c0009ec4786d0e44c681f8159492")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            return responseBody;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        OpenWeatherAPI openWeatherAPI = new OpenWeatherAPI();
        System.out.println(openWeatherAPI.getRawData());

    }
}
