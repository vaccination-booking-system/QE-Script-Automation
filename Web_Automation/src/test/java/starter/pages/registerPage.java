package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class registerPage extends PageObject {

    private By NikTidakValid(){
        return By.xpath("//*[contains (text(), 'NIK Tidak Valid.')]");
    }
    private By onRegistPage(){
        return By.xpath("//*[contains (text(), 'Buat Akun Baru')]");
    }
    private By namaField(){
        return By.xpath("//*[@name = 'nameForm']");
    }
    private By nikField(){
        return By.xpath("//*[@name = 'nikForm']");
    }
    private By noTelpField(){
        return By.xpath("//*[@name = 'number_phoneForm']");
    }
    private By passwordField(){
        return By.xpath("//*[@name = 'passwordForm']");
    }
    private By registerButton(){
        return By.xpath("//*[@class = 'css-1plwuh9']");
    }
    private By notClickableRegis(){
        return By.xpath("//*[@class = 'css-1gzshle']");
    }
    private By nikSudahTerdaftar(){
        return By.xpath("//*[contains (text(), 'NIK sudah terdaftar.')]");
    }
    private By seePasswordButton(){
        return By.xpath("//*[@class =  'absolute inset-y-[40%] right-5 cursor-pointer']");
    }

    @Step("open evizy regist page")
    public void openRegistUrl(){
        openAt("/register");
    }
    @Step
    public void verifyOnRegistPage(){
        $(onRegistPage()).isDisplayed();
    }
    @Step
    public void nikTidakValidDisplayed(){
        $(NikTidakValid()).isDisplayed();
    }
    @Step
    public void inputNama(String nama){
        $(namaField()).type(nama);
    }
    @Step
    public void inputNikforRegist(String nik){
        $(nikField()).type(nik);
    }
    @Step
    public void inputNoTelp(String nomor){
        $(noTelpField()).type(nomor);
    }
    @Step
    public void inputPassword(String pass){
        $(seePasswordButton()).click();
        $(passwordField()).type(pass);
    }
    @Step
    public void clickRegistButton(){
        $(registerButton()).click();
    }
    @Step
    public void verirfyCannotClickRegistButton(){
        $(notClickableRegis()).isDisplayed();
    }
    @Step
    public void nikSudahTerdaftarDisplayed(){
        $(nikSudahTerdaftar()).isDisplayed();
    }

}
