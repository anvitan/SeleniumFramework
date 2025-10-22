package com.practice.tests;

import com.practice.base.BaseTest;
import com.practice.constants.PageConstants;
import com.practice.dataprovider.LoginData;
import com.practice.dataprovider.UserData;
import com.practice.pages.CandyMapperFormPage;
import com.practice.pages.CandyMapperSignInPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class CandyMapperFormTest extends BaseTest {

    @Test(dataProvider = "userData",dataProviderClass = UserData.class)
    public void fillCandyFormMapperTest(Map<String, String> userData) {
        CandyMapperFormPage page = CandyMapperFormPage.getInstance();
        page.closePopup().enterFirstName(userData.get("firstName"))
                .enterLastName(userData.get("lastName")).enterEmail(userData.get("email"))
                .enterPhoneNumber(userData.get("phoneNumber")).enterMessage(userData.get("message"))
                .submitForm();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(page.getThankYouMsg(), PageConstants.THANKYOU_MSG);
        softAssert.assertAll();
    }

    @Test(dataProvider = "loginData", dataProviderClass = LoginData.class)
    public void loginTest(Map<String, String> loginData){
        CandyMapperFormPage page = CandyMapperFormPage.getInstance();
        page.closePopup().clickOnSignInOption().login(loginData.get("email"),loginData.get("password"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(CandyMapperSignInPage.getInstance().getFormErrorText(), PageConstants.SIGN_IN_ERROR);
        softAssert.assertAll();
    }
}
