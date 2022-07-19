package starter.pages.admin;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class vaccination_stock extends PageObject {
    private By vaccinationStock(){
        return By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div[2]/div/div/div[3]/div/div[2]/a/button");
    }
    private By totalPfizerStock(){
        return By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[3]/table/tbody/tr[1]/td[3]");
    }
    private By updateStockButton(){
        return By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[3]/table/tbody/tr[1]/td[4]/button");
    }

    public void clickVacinationStockButton(){
        $(vaccinationStock()).click();
    }
    public void updateVaccineStock(){
        $(totalPfizerStock()).type("4");
    }
    public void clickUpdateStockButton(){
        $(updateStockButton()).click();
    }
    public void validateUpdateStock(){
        $(updateStockButton()).isDisplayed();
    }


}
