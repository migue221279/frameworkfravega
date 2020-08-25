package api;

import api.Molde.BreweriesModel;
import io.restassured.response.Response;
import static util.JsonHelper.guardarJson;

import java.io.IOException;
import java.util.List;

public class FravegaApi extends BaseApi {

    public void searchEmpoint(){
        Response response = doGetRequest("https://api.openbrewerydb.org/breweries/autocomplete?query=lagunitas");
        List<String> jsonResponseName = response.jsonPath().getList("name");
        for (String s : jsonResponseName) {
            System.out.println(s);
        }

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
                    System.out.println("Name received from Response " + Name);
                    System.out.println("Street received from Response " + Street);
                    System.out.println("Phone received from Response " + Phone);
                    guardarJson(breweriesModel);

                }
            }
        }

    }
}
