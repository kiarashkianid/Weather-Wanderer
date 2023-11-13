package api;

import java.util.ArrayList;
import java.util.HashMap;

public interface WeatherAPI {

    HashMap getData(ArrayList<String> cityList);
}
