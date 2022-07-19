package starter.pages.admin;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class sessionAvailability  extends PageObject {
    private By usernameField() {
        return By.xpath("//*[@name = 'username']");
    }

    private By passwordField() {
        return By.xpath("//*[@name = 'password']");
    }

    private By loginButton() {
        return By.xpath("//*[@value = 'MASUK']");
    }
    private By sessionAvailButton(){
        return By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div[2]/div/div/div[2]//a/button");
    }
    private By healthFac(){
        return By.xpath("//*[@class = 'p-4 border-2 rounded-2xl my-2 cursor-pointer']");
    }
    private By addSessionButton(){
        return By.xpath("//*[@class = 'css-oegmdv']");
    }
    private By sessionDate(){
        return By.xpath("//*[@name = 'tanggalLahir']");
    }
    private By vaccineTypeSection(){
        return By.xpath("//*[@name = 'jenisVaksin']");
    }
    private By pfizerVacc(){
        return By.xpath("//*[@value = '3']");
    }
    private By nusantaraVacc(){
        return By.xpath("//*[@value = '13']");
    }
    private By startTime(){
        return By.xpath("//*[@name = 'jamMulai']");
    }
    private By vaccineQuota(){
        return By.xpath("//*[@name = 'kuotaVaksin']");
    }
    private By finishTime(){
        return By.xpath("//*[@name = 'jamSelesai']");
    }
    private By finaladdSesionButton(){
        return By.xpath("//*[@class = 'css-o8hk4s']");
    }
    private By editVaccSessionButton(){
        return By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div/table/tbody/tr[1]/td[6]/div/div[2]");
    }
    private By vaccQuotaForEdit(){
        return By.xpath("//*[@name= 'kuotaVaksin']");
    }
    private By deleteSessButton(){
        return By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div/table/tbody/tr[1]/td[6]/div/div[3]");
    }
    private By cantDeleteVaccSess(){
        return By.xpath("//*[contains (text(), '2022-08-20')]");
    }

    public void inputAdminUsername(){
        $(usernameField()).type("kebonJeruk");
    }
    public void inputAdminPassword(){
        $(passwordField()).type("KebonJeruk01");
    }
    public void clickAdminLoginButton(){
        $(loginButton()).click();
    }
    public void clickSessionAvailSection(){
        $(sessionAvailButton()).click();
    }
    public void selectHealthFac(){
        $(healthFac()).click();
    }
    public void clickAddSessionButton(){
        $(addSessionButton()).click();
    }
    public void setSessionDate(String date){
        $(sessionDate()).type(date);
    }
    public void setVaccineTypeField(){
        $(vaccineTypeSection()).click();
    }
    public void pickPfizer(){
        $(pfizerVacc()).click();
    }
    public void pickNusantara(){
        $(nusantaraVacc()).click();
    }
    public void setStartTime(String start_time){
        $(startTime()).type(start_time);
    }
    public  void setVaccineQuota(String quota){
        $(vaccineQuota()).type(quota);
    }
    public void setFinishTime(String finish_time){
        $(finishTime()).type(finish_time);
    }
    public void clickFinallAddSesionButton(){
        $(finaladdSesionButton()).click();
    }
    public void addSessionButtonIsDisplayed(){
        $(addSessionButton()).isDisplayed();
    }
    public void stilOnAddSessionPage(){
        $(sessionDate()).isDisplayed();
    }
    public void clickEditButton(){
        $(finaladdSesionButton()).click();
    }
    public void editVaccineQuota(){
        $(vaccQuotaForEdit()).type("3");
    }
    public void verifySuccessEditSession(){
        $(editVaccSessionButton()).isDisplayed();
    }
    public void clearvaccineQuota(){
        $(vaccQuotaForEdit()).clear();
    }
    public void stillOnEditVacPage(){
        $(vaccQuotaForEdit()).isDisplayed();
    }
    public void clickDeleteVaccSessionButton(){
        $(deleteSessButton()).click();
    }
    public void verifyCantDeleteVaccSession(){
        $(cantDeleteVaccSess()).isDisplayed();
    }
    public void editDetail1(){
        $(sessionDate()).type("05052016");
    }

}
