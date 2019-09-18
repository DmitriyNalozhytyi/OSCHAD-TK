package restTests;

import org.junit.Test;
import restSteps.privateBank.ApiPrivateBank;
import restSteps.privateBank.BrowserValues;
import restSteps.privateBank.CurrencyValues;



//https://ru.stackoverflow.com/questions/726745/json-parse-error-cannot-deserialize-instance-of-java-util-arraylist-out-of-sta

//https://ru.stackoverflow.com/questions/745094/%D0%9A%D0%B0%D0%BA-%D0%B8-%D1%87%D0%B5%D0%BC-%D0%BF%D0%B0%D1%80%D1%81%D0%B8%D1%82%D1%8C-json-%D0%BD%D0%B0-java

//http://qaru.site/questions/25133/converting-json-to-java

//https://www.youtube.com/watch?v=_kHKp_CuVQI



public class RestTestFromBrowser {

    //https://jsonplaceholder.typicode.com/todos/1

    @Test
    public void getBrowserJsonDetails(){
        ApiPrivateBank apiPrivateBank = new ApiPrivateBank();

        BrowserValues[] responseStructure = apiPrivateBank.getRequestToBrowserApi();

        for (BrowserValues currencyElement : responseStructure ) {
            System.out.println(currencyElement.userId + " has for buy " + currencyElement.id + " and for sale " + currencyElement.title + currencyElement.completed);
        }
    }


}

