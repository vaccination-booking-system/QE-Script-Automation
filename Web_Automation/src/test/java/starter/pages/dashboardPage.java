package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class dashboardPage extends PageObject {

    private By menu(){
        return By.xpath("//*[@class = 'bg-[#DBF5FE] shadow-sm p-2 rounded-md flex items-center']");
    }

    @Step
    public void menuOnDashboardDisplayed(){
        $(menu()).isDisplayed();
    }
}
