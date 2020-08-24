package steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import api.FravegaApi;
import org.testng.Assert;
import util.JsonHelper;


import java.io.IOException;

public class ApiStep {
    private final FravegaApi fravegaApi;

    public ApiStep(FravegaApi fravegaApi){
        this.fravegaApi = fravegaApi;
    }

    @Given("^Obtener una lista de cervecerías que contengan el texto \"([^\"]*)\" en su nombre$")
    public void listaDeCervecerias(String texto) {
        fravegaApi.searchEmpoint(texto);
    }

    @When("^De la lista de resultados del punto 1, tomar aquellos que contengan en la key 'name', el valor \"([^\"]*)\"$")
    public void resultadosContenganEnLakeyName(String valor) throws IOException {
        fravegaApi.listaDeCerveceriasContengan(valor);
    }

    @When("^A través del siguiente servicio, obtener el detalle de cada cervecería de la lista del punto 2 y tomar solo el que contenga 'state' = \"([^\"]*)\"$")
    public void resultadosContenganEnLakeyState(String valor) throws IOException {
         fravegaApi.contengaState(valor);
    }

    @Then("^Sobre la cervecería resultante, assertar lo siguiente \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void resultanteAssertar(String id,String name,String street,String phone) throws IOException {
        fravegaApi.cerveceriaResultanteAssertar();
        JsonHelper.leerJson();
        Assert.assertEquals((JsonHelper.breweriesModel.getId()).toString(),id);
        Assert.assertEquals(JsonHelper.breweriesModel.getName(),name);
        Assert.assertEquals(JsonHelper.breweriesModel.getStreet(),street);
        Assert.assertEquals(JsonHelper.breweriesModel.getPhone(),phone);
    }

}
