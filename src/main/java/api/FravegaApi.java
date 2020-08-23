package api;

import api.Molde.BreweriesModel;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;
import static util.JsonHelper.guardarJson;
import static util.JsonHelper.leerJson;

import util.JsonHelper.*;
import java.io.IOException;
import java.util.List;

public class FravegaApi extends BaseApi {

    public void searchEmpoint(){
        Response response = doGetRequest("https://api.openbrewerydb.org/breweries/autocomplete?query=lagunitas");
        List<String> jsonResponseName = response.jsonPath().getList("name");
        for (String s : jsonResponseName) {
            System.out.println(s);
        }
        System.out.println("");

    }

    public void listaDeCerveceriasContengan() throws IOException {
        Response response = doGetRequest("https://api.openbrewerydb.org/breweries/autocomplete?query=lagunitas");
        List<String> jsonResponseName = response.jsonPath().getList("name");
        List<String> jsonResponseID = response.jsonPath().getList("id");
          for(int i=0;i<jsonResponseName.size();i++){
            if(jsonResponseName.get(i).equals("Lagunitas Brewing Co")){
                System.out.println(jsonResponseName.get(i));
                System.out.println("https://api.openbrewerydb.org/breweries/"+jsonResponseID.get(i));
                }
        }
        System.out.println(" ");
    }
    public void contengaState(String id) throws IOException {
        Response response = doGetRequest("https://api.openbrewerydb.org/breweries/autocomplete?query=lagunitas");
        List<String> jsonResponseName = response.jsonPath().getList("name");
        List<String> jsonResponseID = response.jsonPath().getList("id");
        for(int i=0;i<jsonResponseName.size();i++){

            if(jsonResponseName.get(i).equals("Lagunitas Brewing Co")){
                Response response1 = PathParamExample(jsonResponseID.get(i));
                BreweriesModel breweriesModel = response1.as(BreweriesModel.class);
                String State = breweriesModel.getState();
                if(State.contains("California")) {
                    System.out.println("Id received from Response " + State);
                    //  assertEquals(state, "Id received from Response California", "Correct state received in the Response");
                    System.out.println(" ");
                }
            }
        }

    }

    public void cerveceriaResultanteAssertar() throws IOException {
        Response response = doGetRequest("https://api.openbrewerydb.org/breweries/autocomplete?query=lagunitas");
        List<String> jsonResponseName = response.jsonPath().getList("name");
        List<String> jsonResponseID = response.jsonPath().getList("id");
        for(int i=0;i<jsonResponseName.size();i++){

            if(jsonResponseName.get(i).equals("Lagunitas Brewing Co")){
                Response response1 = PathParamExample(jsonResponseID.get(i));
                BreweriesModel breweriesModel = response1.as(BreweriesModel.class);
                String Id = (breweriesModel.getId()).toString();
                String Name = breweriesModel.getName();
                String Street = breweriesModel.getStreet();
                String Phone = breweriesModel.getPhone();
                String State = breweriesModel.getState();

                if(State.contains("California")) {
                    System.out.println("Id received from Response " + Id);
                       assertEquals(Id, "761", "Correct id received in the Response");
                    System.out.println("Name received from Response " + Name);
                      assertEquals(Name, "Lagunitas Brewing Co", "Correct name received in the Response");
                    System.out.println("Street received from Response " + Street);
                       assertEquals(Street, "1280 N McDowell Blvd", "Correct street received in the Response");
                    System.out.println("Phone received from Response " + Phone);
                      assertEquals(Phone, "7077694495", "Correct phone received in the Response");
                    guardarJson(breweriesModel);

                }
            }
        }

    }
}
