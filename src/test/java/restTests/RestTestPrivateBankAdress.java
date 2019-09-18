package restTests;

import org.junit.Test;
import restSteps.privateBank.AdressValues;
import restSteps.privateBank.ApiPrivateBank;
import restSteps.privateBank.CurrencyValues;

public class RestTestPrivateBankAdress {

    @Test

    //https://api.privatbank.ua/p24api/pboffice?json&city=Днепропетровск&address=Титова
    public void get(){
        ApiPrivateBank apiPrivateBank = new ApiPrivateBank();

        AdressValues[] responseStructure = apiPrivateBank.getRequestToPrivateBankApiAdress("Титова");

        for (AdressValues currencyElement : responseStructure ) {
            System.out.println("Cur1 " + currencyElement.name + " to " + currencyElement.state + " has for buy " + currencyElement.id + " and for sale " + currencyElement.country + currencyElement.city+ currencyElement.index+ currencyElement.phone+ currencyElement.email+ currencyElement.address );
        }
    }





}
