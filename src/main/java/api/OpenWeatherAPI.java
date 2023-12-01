package api;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;

/***
 * TODO:
 * NEEDS TESTING
 */

public class OpenWeatherAPI implements WeatherAPI {

    String API_TOKEN = "0767c0009ec4786d0e44c681f8159492";

    public HashMap getData(ArrayList<String> cityList){
        // for each "city,country" string in the arraylist, call getRawData, accounting for any errors/exceptions
        // Then, add each of those to the hashmap *output* with each key being the city name & the value being the data
        /*
          Example call for getData:
          OpenWeatherAPI openWeatherAPI = new OpenWeatherAPI();
                  ArrayList cityList = new ArrayList<>();
                  cityList.add("london,uk");
                  cityList.add("paris,france");
                  System.out.println(openWeatherAPI.getData(cityList));
          -> {london={Temperature=7.210000000000036, Humidity=87.0, WindSpeed=3.09, Name=london,uk},
              paris={Temperature=6.760000000000048, Humidity=89.0, WindSpeed=5.14, Name=paris,france}}
          Temperature in Celsius | Humidity in % | WindSpeed in meter/second
         */
        HashMap output = new HashMap<String, HashMap>();
        try{
            for (String city : cityList){
                int commaIndex = city.indexOf(",");
                HashMap data = getRawData(city.substring(0, commaIndex), city.substring(commaIndex));
                output.put(city, data);
            }
        } catch (InputMismatchException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    private HashMap getRawData(String cityName, String countryName) {
        String urlString = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s,%s&APPID=%s", cityName, countryName, API_TOKEN);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(urlString)
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            return EditData(responseBody, cityName, countryName); // Gives us raw data from API, needs to be manipulated

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (JSONException e) {
            System.out.println("Invalid city/country name");
            throw new JSONException(e);
        }
    }

    private HashMap EditData(JSONObject data, String cityName, String countryName) {
        // Helper method that Cuts the data down into the relevant parts we want.
        // Want: Temp (In kelvin, convert to celcius) -- Humidity (In % already),  wind speed probably in m/s
        // Want to turn this raw data dictionary into our own dictionary that we can manipulate.


        HashMap editedData = new HashMap<>();
        editedData.put("Name", cityName + countryName);

        JSONObject mainData = new JSONObject(data.get("main").toString()); // pulls nested dictionary out for easier use

        JSONObject windData = new JSONObject((data.get("wind").toString())); // pulls nested wind data for later use


        editedData.put("Temperature", (Double.valueOf(mainData.get("temp").toString()) - 273.15));

        editedData.put("WindSpeed", Double.valueOf(windData.get("speed").toString()));

        editedData.put("Humidity", Double.valueOf(mainData.get("humidity").toString()));

        return editedData;
    }


    public static void main(String[] args) {
        OpenWeatherAPI openWeatherAPI = new OpenWeatherAPI();
        ArrayList cityList = new ArrayList<>();
        cityList.add("toronto,canada");
        cityList.add("paris,france");
        System.out.println(openWeatherAPI.getData(cityList));
        // System.out.println(openWeatherAPI.getRawData("london", "uk"));
        // System.out.println(openWeatherAPI.getRawData("paris", "france"));

    }
}
