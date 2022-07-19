package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPage extends PageObject {

    private By nikField(){
        return By.xpath("//*[@name = 'nik']");
    }
    private By passwordField(){
        return By.xpath("//*[@name = 'password']");
    }
    private By loginButton(){
        return By.xpath("//*[@value = 'MASUK']");
    }
    private By nikAtauPasswordSalah(){
        return By.xpath("//*[@class = 'text-xs text-red-500']");
    }
    private By passwordTidakBolehKosong(){
        return By.xpath("//*[contains (text(), 'Password Tidak Boleh Kosong')]");
    }
    private By nikTidakBolehKosong(){
        return By.xpath("//*[@class = 'text-red-500 text-xs']");
    }
    private By nikTidakaValid(){
        return By.xpath("//*[contains (text(), 'NIK Tidak Valid')]");
    }

    @Step("open evizy login page")
    public void openUrl(){
        openAt("/login");
    }
    @Step
    public void inputNikForLogin(String NIK){
        $(nikField()).type(NIK);
    }
    @Step
    public void inputPasswordForLogin(String Pass){
        $(passwordField()).type(Pass);
    }
    @Step
    public void clickLoginButton(){
        $(loginButton()).click();
    }
    @Step
    public void nikAtauPassSalahDisplayed(){
        $(nikAtauPasswordSalah()).isDisplayed();
    }
    public void passTidakKosongDisplayed(){
        $(passwordTidakBolehKosong()).isDisplayed();
    }
    public void nikTidakKosongDisplayed(){
        $(nikTidakBolehKosong()).isDisplayed();
    }
    public void nikTidakValidDisplayed(){
        $(nikTidakaValid()).isDisplayed();
    }

}
