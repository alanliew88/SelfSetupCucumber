package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class learningtogether {

    public WebDriver ldriver;

    public learningtogether(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
    }

    @FindBy(id="Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id="Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath ="//a[contains(text(),'Logout')]")
    @CacheLookup
    WebElement lnkLogout;

    @FindBy(xpath="//a[@class='nav-link']//p[contains(text(),'Customers')]")
    @CacheLookup
    WebElement lnkCustomers_menu;

    @FindBy(xpath="//ul[@class='nav nav-treeview']//a//p")
    @CacheLookup
    List<WebElement> dropDowns;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    @CacheLookup
    WebElement addnewbutton;






    public void setUserName(String uname){
        txtEmail.clear();
        txtEmail.sendKeys(uname);

    }

    public void setPassword(String pwd){
        txtPassword.clear();
        txtPassword.sendKeys(pwd);

    }

    public void clickLogin(){
        btnLogin.click();
    }
    public void clickLogout(){
        lnkLogout.click();
    }

    public String getPageTitle(){
        return ldriver.getTitle();
    }

    public void clickOnCustomersMenu() throws InterruptedException {
        lnkCustomers_menu.click();
        Thread.sleep(3000);
    }

    public void clickOnCustomerMenuItem() throws InterruptedException {

       /* int i =1;
        for (WebElement dd:dropDowns){
            System.out.println("iteration "+ i + " => " + dd.getText());
            if (dd.getText().equals("Customers")){
                dd.click();
            }

        }*/

        Thread.sleep(3000);


        int total = dropDowns.size();
        System.out.println("Total element got : " + total);

        for (WebElement singleoption : dropDowns) {

            if (singleoption.getText().equals("Customers")) {
                singleoption.click();
                break;
            } else {
                System.out.println("Menu detail element is not found");
            }

        }

        Thread.sleep(3000);
    }

    public void clickonaddnewbutton(){
        addnewbutton.click();


    }





}
