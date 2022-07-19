package starter.pages.admin;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class login_admin extends PageObject {

    private By usernameField(){
        return By.xpath("//*[@name = 'username']");
    }
    private By passwordField(){
        return By.xpath("//*[@name = 'password']");
    }
    private By loginButton(){
        return By.xpath("//*[@value = 'MASUK']");
    }
    private By usernameAtauPasswordSalah(){
        return By.xpath("//*[@class = 'text-xs text-red-500']");
    }
    private By passwordTidakBolehKosong(){
        return By.xpath("//*[contains (text(), 'Password Tidak Boleh Kosong')]");
    }
    private By usernameTidakBolehKosong(){
        return By.xpath("//*[contains (text(), 'Username Tidak Boleh Kosong')]");
    }

    @Step("open evizy admin login page")
    public void openAdminUrlPage(){
        openAt("/login/admin");
    }
    @Step
    public void inputUsernameForLogin(String username){
        $(usernameField()).type(username);
    }
    @Step
    public void inputAdminPasswordForLogin(String Pass){
        $(passwordField()).type(Pass);
    }
    @Step
    public void clickAdminLoginButton(){
        $(loginButton()).click();
    }
    @Step
    public void usernameAtauPassSalahDisplayed(){
        $(usernameAtauPasswordSalah()).isDisplayed();
    }
    public void passwordTidakKosongDisplayed(){
        $(passwordTidakBolehKosong()).isDisplayed();
    }
    public void usernameTidakBolehKosongDisplayed() {
        $(usernameTidakBolehKosong()).isDisplayed();
    }

}
