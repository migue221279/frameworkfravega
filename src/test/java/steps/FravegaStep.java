package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageobjects.FravegaPage;

public class FravegaStep {

    private FravegaPage fravegaPage;

    public FravegaStep(FravegaPage fravegaPage){
        this.fravegaPage = fravegaPage;
    }

    @Given("^Se ingresa la home de Frávega$")
    public void iGoToFravega() throws Throwable {
        fravegaPage.navigateUrl();
    }

    @When("^Se ingresa en el campo busqueda la palabra \"([^\"]*)\"$")
    public void iQueryFor(String query) throws Throwable {
        fravegaPage.enterSearchQuery(query);
    }

    @And("^Hace clic en el botón búsqueda$")
    public void clickSearch() throws Throwable {
        fravegaPage.clickFravegaSearchBtn();
     }

    @And("^Se filtra por \"([^\"]*)\" en la subcategoria$")
    public void FilterSubCategoria(String subCategoria) throws Throwable {
        fravegaPage.clickLinkHeladeras(subCategoria);

    }
    @And("^Se filtra por \"([^\"]*)\" en marca$")
    public void FilterCheckMarca(String checkMarca) throws Throwable {
        fravegaPage.clickLinkVerTodas();
        fravegaPage.focoEnModalBusqueda();
        fravegaPage.clickcheckboxSamsung(checkMarca);
        fravegaPage.clickBotonAplicar();
    }

    @Then("^Verifica que cada uno de los elementos contenga \"([^\"]*)\" en su title$")
    public void verificaContengaEnSuTitle(String marca) {
        Assert.assertTrue(fravegaPage.verifyExistingWordInTitle(marca), " - Cantidad de elementos no concide ConResultados");
    }

    @Then("^Verifica la cantidad de elementos de la lista coincida con los resultados mostrando por el frontend$")
    public void verificaCantidadElementosConcidaConResultados() {
        Assert.assertTrue(fravegaPage.verifyQuantityResult(), " - Cantidad de elementos no concide ConResultados");

    }
    @Then("^Verifica en el breadcrumb de la página se visualize \"([^\"]*)\"$")
    public void VerificaBreadcrumbPaginaVisualize(String breadcrumb) {
        Assert.assertTrue(fravegaPage.verifyBreadcrumbExist(breadcrumb), " - No contiene en el BREADCRUMB esperaba: "+breadcrumb);
    }

}


/*
  @Test
  Scenario: 1 - Cada uno de los elementos contenga "samsung" en su title
    Given Se ingresa la home de Frávega
    When Se ingresa en el campo busqueda la palabra "Heladera"
    And Hace clic en el botón búsqueda
    And Se filtra por "Heladeras" en la subcategoria
    And Se filtra por "Samsung" en marca
    Then Verifica que cada uno de los elementos contenga "Samsung" en su title

  @Test
  Scenario: 2 - La cantidad de elementos de la lista coincida con los resultados mostrando por el frontend.
    Given Se ingresa la home de Frávega
    When Se ingresa en el campo busqueda la palabra "Heladera"
    And Hace clic en el botón búsqueda
    And Se filtra por "Heladeras" en la subcategoria
    And Se filtra por "Samsung" en marca
    Then Verifica la cantidad de elementos de la lista coincida con los resultados mostrando por el frontend

  @Test
     # breadcrumb Reemplazar --->  Frávega Por  Heladeras con Frezzer
  Scenario: 3 - En el breadcrumb de la página (atributo name="breadcrumb") se visualize "Heladeras con Frezzer"
    Given Se ingresa la home de Frávega
    When Se ingresa en el campo busqueda la palabra "Heladera"
    And Hace clic en el botón búsqueda
    And Se filtra por "Heladeras" en la subcategoria
    And Se filtra por "Samsung" en marca
    Then Verifica en el breadcrumb de la página se visualize "Frávega"*/