package starter.stepdefinitions;

import io.cucumber.java.en.And;
import starter.pages.admin.vaccination_stock;

public class vaccineStockSteps {

    vaccination_stock vacc_stock;
    @And("I click vaccine stock section")
    public void iClickVaccineStockSection() {
        vacc_stock.clickVacinationStockButton();
    }

    @And("I input new value of vaccination stock")
    public void iInputNewValueOfVaccinationStock() {
        vacc_stock.updateVaccineStock();
    }

    @And("I click add stock button")
    public void iClickAddStockButton() {
        vacc_stock.clickUpdateStockButton();
    }

    @And("I success update vaccine stock")
    public void iSuccessUpdateVaccineStock() throws Exception {
        Thread.sleep(2000);
        vacc_stock.validateUpdateStock();
    }
}
