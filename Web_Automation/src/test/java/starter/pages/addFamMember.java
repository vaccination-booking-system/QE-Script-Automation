package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.SerenityActions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class addFamMember extends PageObject {



    private By addFamilyMemberSection(){
        return By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/a/button");
    }
    private By addFamilyMemberButton(){
        return By.xpath("//*[@class = 'css-a7xbot']");
    }

    private By nikField(){
        return By.xpath("//*[@name = 'nik']");
    }
    private By passwordField(){
        return By.xpath("//*[@name = 'password']");
    }
    private By fullnameField(){
        return By.xpath("//*[@name = 'nama']");
    }
    private By dobField(){
        return By.xpath("//*[@name = 'birthday']");
    }
    private By nikAddFamField(){
        return By.xpath("//*[@name = 'nik']");
    }
    private By phoneNumberField(){
        return By.xpath("//*[@name = 'phoneNumber']");
    }
    private By genderField(){
        return By.xpath("//*[@name= 'gender']");
    }
    private By selectFemale(){
        return By.xpath("//*[@value= 'F']");
    }
    private By relationField(){
        return By.xpath("//*[@name= 'relation']");
    }
    private By siblingRelation(){
        return By.xpath("//*[@value= 'sibling']");
    }
    private By FinalButtonForAddFamily(){
        return By.xpath("//*[@type= 'submit']");
    }
    private By invalidName(){
        return By.xpath("//*[text() = 'Nama tidak sesuai format']");
    }
    private By invalidNIK(){
        return By.xpath("//*[contains (text(), 'NIK Tidak Valid')]");
    }
    private By invalidPhoneNumber(){
        return By.xpath("//*[contains (text(), 'Input dimulai dengan 08 & harus berupa angka')]");
    }
    private  By errorButton(){
        return By.xpath("//*[@class = 'swal2-confirm swal2-styled']");
    }
    private By onAddFmilyMemberPage(){
        return By.xpath("//*[@class = 'font-bold text-[25px] leading-[32.5px]']");
    }
    private By successAddFam(){
        return By.xpath("//*[span = 'Jessica Sheva']");
    }
    private By selectMale(){
        return By.xpath("//*[@value= 'M']");
    }
    private By otherRelation(){
        return By.xpath("//*[@value= 'other']");
    }

    public void inputNikForAddFamMember(){
        $(nikField()).type("3534518716226907");
    }
    public void inputPassForAddFamMember() throws Exception{

        $(passwordField()).type("jennieRubyjane16");
    }

    @Step("click add family member section")
    public void clickAddFamilyMemberSection(){
        $(addFamilyMemberSection()).click();
    }
    @Step
    public void verifyOnAddFamilyMemberFormPage(){
        $(fullnameField()).isDisplayed();
    }
    @Step
    public void inputFullname(String fullname) throws Exception{
//        $(fullname).click();
        Thread.sleep(600);
        $(fullnameField()).type(fullname);
    }
    @Step
    public void inputDot(String dot) throws Exception{
//        $(dobField()).click();
        Thread.sleep(600);
        $(dobField()).type(dot);
    }
    @Step
    public void inputFamMemberNik(String nik) throws Exception{
        $(nikAddFamField()).click();
        Thread.sleep(600);
        $(nikAddFamField()).type(nik);
    }
    @Step
    public void inputPhoneNumber(String phonenumber)throws Exception{
        $(phoneNumberField()).click();
        Thread.sleep(600);
        $(phoneNumberField()).type(phonenumber);
    }
    @Step
    public void selectGender() throws Exception {
        $(genderField()).click();
        Thread.sleep(600);
        $(selectFemale()).click();
    }
    @Step
    public void selectRelation() throws Exception{
        Thread.sleep(600);
        $(relationField()).click();
        Thread.sleep(600);
        $(siblingRelation()).click();
    }
    @Step
    public void clickFinalAddFamButton() throws Exception{
        Thread.sleep(600);
        $(FinalButtonForAddFamily()).click();

    }
    @Step
    public void invalidNameDisplayed() throws Exception {
        Thread.sleep(600);
        $(invalidName()).isDisplayed();
    }
    @Step
    public void invalidNikDisplayed() throws Exception{
        Thread.sleep(600);
        $(invalidNIK()).isDisplayed();
    }
    @Step
    public void scrollTo() throws Exception{
        Thread.sleep(600);
        SerenityActions scroll = new SerenityActions(getDriver());
        scroll.moveToElement($(FinalButtonForAddFamily())).perform();
    }
    @Step
    public void invalidPhoneNumberDispalyed() throws Exception{
        Thread.sleep(600);
        $(invalidPhoneNumber()).isDisplayed();
    }
    @Step
    public void errorButtonDisplayed() throws Exception{
        Thread.sleep(600);
        $(errorButton()).isDisplayed();
        $(errorButton()).click();
    }
    @Step
    public void verifySuccessAddFamMember() throws Exception{
        Thread.sleep(600);
        $(successAddFam()).isDisplayed();
    }
    @Step
    public void verifyStillOnFamAddMemPage() throws Exception {
        Thread.sleep(600);
        $(onAddFmilyMemberPage()).isDisplayed();
    }
    @Step
    public void clickAddFamilyMemberButton(){
        $(addFamilyMemberButton()).click();
    }

    @Step
    public void clickMale() throws Exception{
        Thread.sleep(600);
        $(selectMale()).click();
    }
    public void clickOtherRelation() throws Exception{
        Thread.sleep(600);
        $(otherRelation()).click();
    }




}
