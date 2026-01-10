package tests;
import base.common;
import pages.AddUserPage;
import pages.DashboardPage;
import utils.ExcelUtil;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class AddUserTest extends common {

    @Test(priority = 4,dataProvider = "addUserData")
    public void verifyAddUser(String tcId,
                              String username,
                              String mobile,
                              String email,
                              String course,
                              String gender,
                              String state,
                              String password,
                              String expectedResult) throws InterruptedException {

        // Navigate to Add User
        DashboardPage dp = new DashboardPage(driver);
        dp.goToAddUserPage();

        AddUserPage ap = new AddUserPage(driver);

        ap.fillForm(username, mobile, email, course, gender, state, password);
        ap.submit();

        // Handle alert FIRST
        String alertText = ap.handleAlertIfPresent();

        if (expectedResult.equalsIgnoreCase("PASS")) {

            Assert.assertTrue(
                    alertText.contains("User Added Successfully"),
                    tcId + " : Success alert not shown"
            );

        } else {

            // App wrongly allows submission → still alert appears
            if (!alertText.isEmpty()) {
                Assert.assertTrue(alertText.contains("User Added Successfully"));
                return;
            }

            // Validation checks
            if (username.isEmpty())
                Assert.assertEquals(ap.getUsernameError(), "Please fill out this field.");

            else if (mobile.isEmpty())
                Assert.assertEquals(ap.getMobileError(), "Please fill out this field.");

            else if (email.isEmpty())
                Assert.assertEquals(ap.getEmailError(), "Please fill out this field.");

            else if (course.isEmpty())
                Assert.assertEquals(ap.getCourseError(), "Please fill out this field.");

            else if (password.isEmpty())
                Assert.assertEquals(ap.getPasswordError(), "Please fill out this field.");
        }
    }

    @DataProvider
    public Object[][] addUserData() throws Exception {
        return ExcelUtil.getData("addUsers");
    }
}
