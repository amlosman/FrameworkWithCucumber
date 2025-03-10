package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CustomerPage;
import pages.HomePage;
import pages.ManagerPage;

import static java.sql.DriverManager.getDriver;
import static stepDef.Hooks.driver;

public class LineManagerSteps {
    HomePage homePage;
    ManagerPage managerPage;
    CustomerPage customerPage;

    public LineManagerSteps(){
        homePage = new HomePage(driver);
        managerPage =new ManagerPage(driver);
        customerPage= new CustomerPage(driver);
    }

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
         homePage.clickOnHomeBtn();
    }
    @When("the user clicks on the bank manager login button")
    public void theUserClicksOnTheBankManagerLoginButton() {
        homePage.clickOnBankManagerLogin();
    }

    @Then("the manager actions should be displayed")
    public void theManagerActionsShouldBeDisplayed() {
        Assert.assertTrue(managerPage.validateManagerActionsIsDisplayed());
    }

    @Then("the user is logged in as a manager")
    public void theUserIsLoggedInAsAManager() {
        Assert.assertTrue(managerPage.validateManagerActionsIsDisplayed());
    }

    @When("the user adds a new customer with first name {string}, last name {string}, and postcode {string}")
    public void theUserAddsANewCustomer(String firstName, String lastName, String postCode) {
        managerPage.clickOnAddCustomer();
        managerPage.fillCustomerDetails(firstName, lastName, postCode);
    }

    @Then("the customer should be added successfully message {string}")
    public void theCustomerShouldBeAddedSuccessfully(String expectedMsg) {
        Assert.assertEquals(managerPage.validatePopUpIsDisplayed(), expectedMsg + managerPage.customerIndex());
        managerPage.clickOnOkPopUp();
    }

    @When("the user opens a new account for the customer")
    public void theUserOpensANewAccountForTheCustomer() {
        managerPage.clickOnOpenAccount();
        managerPage.selectCustomerDetails(managerPage.customerIndex()-1, 1);
        managerPage.clickOnProcessToOpenAccount();
    }

    @Then("the account should be created successfully message {string}")
    public void theAccountShouldBeCreatedSuccessfully(String expectedMsg) {
        Assert.assertEquals(managerPage.getAddAccountMgs(), expectedMsg + managerPage.getAccountNumber());
        managerPage.clickOnOkPopUp();
    }

    @Then("the customer list is displayed")
    public void theCustomerListIsDisplayed() {
        managerPage.clickOnCustomers();
    }

    @When("the user sorts customers by postcode")
    public void theUserSortsCustomersByPostcode() {
        customerPage.sortByPostCode();
    }

    @Then("the customers should be sorted in ascending order")
    public void theCustomersShouldBeSortedInAscendingOrder() {
        Assert.assertTrue(customerPage.sortACS());
    }
    @Then("the customers should be sorted in descending order")
    public void theCustomersShouldBeSortedInDescendingOrder() {
        Assert.assertTrue(customerPage.sortDES());
    }
    @When("the user searches for a customer with first name {string}")
    public void theUserSearchesForACustomerWithFirstName(String firstName) {
        customerPage.searchForText(firstName);
    }

    @Then("the customer should be displayed")
    public void theCustomerShouldBeDisplayed() {
        Assert.assertEquals(customerPage.validateAccountRowIsDisplayed(), 1);
    }

    @When("the user deletes the customer with first name {string}")
    public void theUserDeletesTheCustomerWithFirstName(String firstName) {
        customerPage.searchForText(firstName);
        customerPage.clickOnDelete();
    }

    @Then("the customer should no longer be displayed")
    public void theCustomerShouldNoLongerBeDisplayed() {
        Assert.assertEquals(customerPage.validateAccountRowIsDisplayed(), 0);
    }

    @When("the user logs in as a customer")
    public void theUserLogsInAsACustomer() {
        homePage.clickOnCustomerLogin();
        customerPage.selectUserByIndex(managerPage.customerIndex()-1);
        customerPage.clickOnLogin();
    }

    @Then("the welcome message should be displayed")
    public void theWelcomeMessageShouldBeDisplayed() {
        Assert.assertTrue(customerPage.validateWelcomeMsgIsDisplayed());
    }

    @When("the user deposits {string} into the account")
    public void theUserDepositsIntoTheAccount(String amount) {
        customerPage.clickOnDeposit();
        customerPage.setAmount(amount);
        customerPage.clickOnSubmit();
    }

    @Then("the deposit should be successful message {string}")
    public void theDepositShouldBeSuccessful(String message) {
        Assert.assertEquals(customerPage.validateSuccessMsg(), message);
    }

    @When("the user views transactions")
    public void theUserViewsTransactions() {
        customerPage.clickOnTransactionsBtn();
    }

    @Then("the transaction should be displayed")
    public void theTransactionShouldBeDisplayed() {
        Assert.assertTrue(customerPage.validateTransactionAdded());
    }


    @And("a customer has been added {string} {string} {string}")
    public void aCustomerHasBeenAdded(String fName, String lName, String postCode) {
        managerPage.clickOnAddCustomer();
        managerPage.fillCustomerDetails(fName, lName, postCode);
    }
}