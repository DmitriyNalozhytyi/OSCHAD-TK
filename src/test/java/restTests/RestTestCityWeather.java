package restTests;

import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.Test;
import restSteps.privateBank.ApiPrivateBank;
import restSteps.privateBank.ApiWeather;
import restSteps.privateBank.CurrencyValues;
import restSteps.privateBank.WeatherValues;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class RestTestCityWeather {
    @Test
    public void getCityWeatherDetails() {
        ApiWeather apiWeather = new ApiWeather();

        WeatherValues[] responseStructure = apiWeather.getRequestToWeatherApi("Hyderabad");



        for (WeatherValues weatherElement : responseStructure) {
            System.out.println("City111: " + weatherElement.City + " Temperature: " + weatherElement.Temperature + "Humidity:  " + weatherElement.Humidity + "WeatherDescription: " + weatherElement.WeatherDescription + "WindSpeed: " + weatherElement.WindSpeed + "WindDirectionDegree: " + weatherElement.WindDirectionDegree);
        }


    }

}
