package restSteps.privateBank;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import restSteps.ParentApi;

public class ApiWeather extends ParentApi {

    /**
     * GET request to CityWeather
     * http://restapi.demoqa.com/utilities/weather/city/Hyderabad
     * @param cityName
     * @return
     */
    public WeatherValues[] getRequestToWeatherApi(String cityName)




    {


            return RestAssured.given()
                .contentType(ContentType.JSON)    // Header

               // .queryParam("json")
                //.queryParam("exchange")         //adding param to URL

               // .queryParam(cityName) //adding param to URL
                .when()
                .get(apiEndPoints.restapi_demoqa_com_utilities_weather_city() + cityName) // Base URL from apiEndPoints.properties

                .then()
                .statusCode(200)
                .extract()
                .response().getBody().as(WeatherValues[].class);

    }




}
