package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.lang.*;
import java.util.List;

public class FravegaPage extends BasePage {

    private String url;

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='__next']/div[1]/header/div/header/div[2]/div/div[2]/form/input")
    private WebElement INPUT_CAMPO_BUSQUEDA;
    @FindBy(xpath = "//*[@id='__next']/div[1]/header/div/header/div[2]/div/div[2]/form/button")
    private WebElement BUTTON_BUSQUEDA;
    @FindBy(xpath = "//*[@id='__next']/div[3]/div[2]/div/div/div[1]/ul/li[2]/ul/li[2]/ul/a")
    private WebElement LINK_VER_TODAS;
    @FindBy(xpath = "//*[@id='apply']")
    private WebElement BUTTON_APLICAR;

    By LISTA_MARCAS = By.xpath("//*[@id='__next']/div[3]/div[2]/div/div/div[2]/section/ul[1]/li/div/a/article/div/h4");
    By BREADCRUMB = By.xpath("//*[@id='__next']/div[3]/div[2]/div/div/div[1]/div/div/ul/li");
    By SUB_CATEGORIA = By.xpath("//*[@id='__next']/div[3]/div[2]/div/div/div[1]/ul/li[2]/ul/li/ul/li[2]/a/h4");
    By CHECK_MARCA = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[2]/div/label");

    public FravegaPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.url = "https://www.fravega.com/";
    }

    @Override
    public boolean isAt() {
        return false;
    }

    public void navigateUrl() {
        this.driver.get(this.url);
        waitForLoadPage(driver);
    }

    public void enterSearchQuery(String text) {
        waitForElementToBeClickeable(INPUT_CAMPO_BUSQUEDA);
        INPUT_CAMPO_BUSQUEDA.sendKeys(text);
    }

    public void clickFravegaSearchBtn() {
        waitForElementToBeClickeable(BUTTON_BUSQUEDA);
        BUTTON_BUSQUEDA.click(); }

    public void clickLinkHeladeras(String subCategoria) {
        waitForElementToBeClickeable(driver.findElement(SUB_CATEGORIA));
        List<WebElement> options = driver.findElements(SUB_CATEGORIA);
        for (WebElement option : options) {
            if (option.getAttribute("innerText").contains(subCategoria+" ("))
            {
                option.click();
                break;
            }
        }
    }

    public void clickLinkVerTodas() {
        waitForElementToBeClickeable(LINK_VER_TODAS);
        LINK_VER_TODAS.click(); }

    public void focoEnModalBusqueda() {
        driver.switchTo().defaultContent(); }

    public void clickcheckboxSamsung(String checkMarca) {
        waitForElementToBeClickeable(driver.findElement(CHECK_MARCA));
        List<WebElement> options = driver.findElements(CHECK_MARCA);
        for (WebElement option : options) {
            if (option.getAttribute("innerText").contains(checkMarca+" ("))
            {
                option.click();
                break;
            }
        }
    }

    public void clickBotonAplicar() {
        waitForElementToBeClickeable(BUTTON_APLICAR);
        BUTTON_APLICAR.click();

    }

    public boolean verifyExistingWordInTitle(String marca) {
        int contador = 0;
        waitForElementToBeClickeable(driver.findElement(LISTA_MARCAS));
        List<WebElement> options = driver.findElements(LISTA_MARCAS);
        for (WebElement option : options) {
           if (option.getAttribute("innerText").contains(marca))
            {
                contador++;
            }
        }
        return contador == options.size();
    }

    public boolean verifyQuantityResult() {
        int contador = 0;
        waitForElementToBeClickeable(driver.findElement(LISTA_MARCAS));
        List<WebElement> options = driver.findElements(LISTA_MARCAS);
        for (WebElement option : options) {
            if (option.isDisplayed())
            {
                contador++;
            }

        }
        return contador == options.size();
    }

    public boolean verifyBreadcrumbExist(String breadcrumb) {
        waitForElementToBeClickeable(driver.findElement(BREADCRUMB));
        List<WebElement> options = driver.findElements(BREADCRUMB);
        for (WebElement option : options) {
            if (option.getAttribute("innerText").contains(breadcrumb))
            {
                return true;
            }
        }
        return false;
    }
}