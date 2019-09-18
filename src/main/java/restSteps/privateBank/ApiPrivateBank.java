package restSteps.privateBank;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jdk.nashorn.internal.parser.JSONParser;
import restSteps.ParentApi;

public class ApiPrivateBank extends ParentApi {
    /**
     * GET request to Private Bank
     * https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5
     * @param coursid
     * @return
     */
    public CurrencyValues[] getRequestToPrivateBankApi(Integer coursid) {
        return RestAssured.given()
                .contentType(ContentType.JSON)    // Header
                .queryParam("json")
                .queryParam("exchange")         //adding param to URL
                .queryParam("coursid", coursid) //adding param to URL
                .when()
                .get(apiEndPoints.privatbank_p24api_pubinfo()) // Base URL from apiEndPoints.properties
                .then()
                .statusCode(200)
                .extract()
                .response().getBody().as(CurrencyValues[].class);
    }


    public AdressValues[] getRequestToPrivateBankApiAdress(String adress) {

        //https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5

        //https://api.privatbank.ua/p24api/pboffice?json&city=Днепропетровск&address=Титова

        return RestAssured.given()
                .contentType(ContentType.JSON)    // Header

                .queryParam("json")


                .queryParam("city=Днепропетровск")

              //  .queryParam("json")
              //  .queryParam("exchange")         //adding param to URL
                .queryParam("address", adress) //adding param to URL
                .when()
                .get(apiEndPoints.privatbank_p24api_office_Titova()) // Base URL from apiEndPoints.properties
                .then()
                .statusCode(200)
                .extract()
                .response().getBody().as(AdressValues[].class);
    }




    public BrowserValues[] getRequestToBrowserApi() {
        return RestAssured.given()

              //  .contentType(ContentType.JSON)    // Header
               // .queryParam("json")
              //  .queryParam("exchange")         //adding param to URL
              //  .queryParam("coursid", coursid) //adding param to URL



                .when()
                .get(apiEndPoints.jsonplaceholder_typicode_com_todos_1()) // Base URL from apiEndPoints.properties
                .then()
                .statusCode(200)
                .extract()
                .response().getBody().as(BrowserValues[].class);
    }







}

