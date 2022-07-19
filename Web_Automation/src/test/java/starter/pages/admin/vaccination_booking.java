package starter.pages.admin;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.SerenityActions;
import org.openqa.selenium.By;

public class vaccination_booking extends PageObject {
    private By vaccinationBookingButton(){
        return By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div[2]/div/div/div[1]//a/button");
    }
    private By editStatusButton(){
        return By.xpath("//*[@class = 'cursor-pointer'][2]");
    }
    private By vaccinatedButton(){
        return By.xpath("//*[@class= 'p-[4px] mx-1 bg-green-200  font-bold text-xs rounded-xl text-white inline-block cursor-pointer']");
    }
    private By notYetButton(){
        return By.xpath("//*[@class = 'p-[4px] mx-1 bg-orange-500  font-bold text-xs rounded-xl text-white inline-block cursor-pointer']");
    }
    private By updateButton(){
        return By.xpath("//*[@class= 'css-o8hk4s']");
    }
    private By successUpdateNotYet(){
        return By.xpath("//*[@class = 'p-[4px] mx-1 bg-orange-200  font-bold text-xs rounded-xl text-white inline-block cursor-pointer']");
    }
    private By successUpdateVaccinated(){
        return By.xpath("//*[@class = 'p-[4px] mx-1 bg-green-400  font-bold text-xs rounded-xl text-white inline-block cursor-pointer']");
    }

    public void clickVaccinationBookingButton(){
        $(vaccinationBookingButton()).click();
    }
    public void clickEditStatusButton(){
        $(editStatusButton()).click();
    }
    public void scrollTo() throws Exception{
        Thread.sleep(600);
        SerenityActions scroll = new SerenityActions(getDriver());
        scroll.moveToElement($(vaccinatedButton())).perform();
    }
    public void clickVaccinatedButton(){
        $(vaccinatedButton()).click();
    }
    public void clickNotYetButton(){
        $(notYetButton()).click();
    }
    public void clickUpdateStatusButton(){
        $(updateButton()).click();
    }
    public void successUpdateNotYetStatus(){
        $(successUpdateNotYet()).isDisplayed();
    }
    public void successUpdateVaccinatedStatus(){
        $(successUpdateVaccinated()).isDisplayed();
    }

}
