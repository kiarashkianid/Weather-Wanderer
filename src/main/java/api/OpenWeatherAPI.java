package api;


import okhttp3.*;
import org.json.JSONObject;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;


public class OpenWeatherAPI {
    public Object getRawData(String cityName, String countryName) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=0767c0009ec4786d0e44c681f8159492")
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            EditData(responseBody, cityName, countryName);
            return responseBody; // Gives us raw data from API, needs to be manipulated

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void EditData(JSONObject data, String cityName, String countryName) { // Helper method that Cuts the data
        // down into the relevant parts we want
        // Want: Temp (In kelvin, convert to celcius) -- Humidity (In % im assuming), pressure (In mBar), wind speed probably in knots
        // Want to turn this raw data dictionary into our own dictionary


        HashMap editedData = new HashMap<>();
        editedData.put("Name", cityName + ", " + countryName);

        JSONObject mainData = new JSONObject(data.get("main").toString()); // pulls nested dictionary out for easier use

        Double tempKelvin = Double.valueOf(mainData.get("temp").toString());

        editedData.put("Temperature", (tempKelvin - 273.15));

        editedData.put("WindSpeed", data.get("wind"));

        editedData.put("Humidity", mainData.get("humidity"));
        System.out.println(editedData);
    }


    public static void main(String[] args) {
        OpenWeatherAPI openWeatherAPI = new OpenWeatherAPI();
        System.out.println(openWeatherAPI.getRawData("london", "uk"));

    }
}
