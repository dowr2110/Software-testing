package test;

import model.Bulka;
import model.User;
import org.testng.annotations.Test;
import page.*;
import service.BulkaCreator;
import service.UserCreator;

import static org.assertj.core.api.Assertions.assertThat;

public class KamilMarketTest extends  CommonConditions {

    @Test (priority = 1)
    public void addToBasket() {
        Bulka bulka = BulkaCreator.withCredentialsFromProperty();
        KamilMarketBasketPage checkAddToBasket = new KamilMarketProductPage(driver)
                .openPage()
                .addToBasket()
                .openBasket();
        assertThat(checkAddToBasket.getNameInBasket()).isEqualTo(bulka.getNameOfBulka());
        assertThat(checkAddToBasket.getIDInBasket()).isEqualTo(bulka.getCountOfBulka());
        assertThat(checkAddToBasket.getCostInBasket()).isEqualTo(bulka.getCostOfBulka());
    }

    @Test (priority = 2)
    public void insertWrongPromocode() {
        KamilMarketBasketPage checkPromoCode = new KamilMarketBasketPage(driver)
                .openPage()
                .inputWrongPromocode("dowran")
                .addPromocode();
        assertThat(checkPromoCode.getErrorMessageInBasket().contains("coupon Code entered could not be applied to your order")).isTrue();
        assertThat(checkPromoCode.getCostInBasket()).isEqualTo(checkPromoCode.getCostAfterInserPromoInBasket( ));

    }

    @Test(priority = 3)
    public void searchWithFailedTerms(){
        KamilMarketSearchResultPage checkSearch  = new KamilMarketHomePage(driver)
                .openPage()
                .inputTerm("iphone12")
                .searchTerm();
        assertThat(checkSearch.getCheckResultSeacrh().contains("Your search did not match any products")).isTrue();
    }

    @Test (priority = 4)
    public void addToBasketMoreThanMaxValue() {
        Bulka bulka = BulkaCreator.withCredentialsFromProperty();
        KamilMarketProductPage checkAddToBasketMoreThanMax = new KamilMarketProductPage(driver)
               .openPage()
                .selectMoreThanMaxValue("1000000")
                .addToBasket();
        assertThat(checkAddToBasketMoreThanMax.getErrorMessageInProductPage()).isEqualTo(bulka.getErrorMessageInPage());
    }

    @Test(priority = 5)
    public void loginTest() {
        User testUser = UserCreator.withCredentialsFromProperty("first");
        KamilMarketHomePage loggedUserFirstName = new KamilMarketLoginPage(driver)
                .openPage()
                .login(testUser);
        assertThat(loggedUserFirstName.getNameInHomePage()).isEqualTo(testUser.getFirstName());
        assertThat(loggedUserFirstName.checkProfifeInHomePage().contains("My account")).isTrue();
        assertThat(loggedUserFirstName.checkOutputInHomePage().contains("Output")).isTrue();
    }

    @Test(priority = 6)
    public void buyingProductWithoutFormalization() {
        KamilMarketBillingAddressPage checkAddress = new KamilMarketBasketPage(driver)
                .openPage()
                .toFormalization()
                .toNext();
        assertThat(checkAddress.getNameInBillingAddress().contains("first the name is required.")).isTrue();
        assertThat(checkAddress.getLastNameInBillingAddress().contains("last Name is required.")).isTrue();
        assertThat(checkAddress.getAddressInBillingAddress().contains("Address required")).isTrue();
    }

    @Test(priority = 7)
    public void searchConcreteProduct(){
        KamilMarketHomePage checkConcrete  = new KamilMarketHomePage(driver)
                .openPage()
                .inputTerm("008086");
        assertThat(checkConcrete.getIdConcreteInHomePage().contains("008086")).isTrue();
        assertThat(checkConcrete.getNameConcreteInHomePage().contains("Abc Baylasdyrylan Atyr Ysly Yumsadyjy")).isTrue();
        assertThat(checkConcrete.getCostConcreteInHomePage().contains("68,50m.")).isTrue();
    }

    @Test(priority = 8)
    public void sendWishList() {
        User testUser = UserCreator.withCredentialsFromProperty("first");
        KamilMarketSendEmailPage checkEmailToFriend = new KamilMarketBasketPage(driver)
                .openPage()
                .toWishList()
                .openPage()
                .sendToFriend()
                .send(testUser);
        assertThat(checkEmailToFriend.getMessageInSendEmailPage().contains("Your message has been sent.")).isTrue();
    }

    @Test(priority = 9)
    public void registerWithBadCredentials() {
        User testUser = UserCreator.withCredentialsFromProperty("second");
        KamilMarketRegisterPage checkRegister = new KamilMarketRegisterPage(driver)
                .openPage()
                .register(testUser);
        assertThat(checkRegister.getErrorMessageInSendEmailPage().contains("Invalid email")).isTrue();
        assertThat(checkRegister.getError2MessageInSendEmailPage().contains("the Password must have at least 6 characters.")).isTrue();
    }








}
