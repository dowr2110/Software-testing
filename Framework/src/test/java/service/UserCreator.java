package service;

import model.User;

public class UserCreator {

    public static final String TESTDATA_USER_EMAIL = "testdata.user.%s.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.%s.password";
    public static final String TETSDATA_USER_FIRSTNAME = "testdata.user.%s.firstName";
    public static final String TESTDATA_USER_LASTNAME = "testdata.user.%s.lastName";
    public static final String TESTDATA_USER_PHONE = "testdata.user.%s.phone";

    public static User withCredentialsFromProperty(String number){
        String userEmail = String.format(TESTDATA_USER_EMAIL, number);
        String userPassword = String.format(TESTDATA_USER_PASSWORD, number);
        String userFirstName = String.format(TETSDATA_USER_FIRSTNAME, number);
        String userLastName = String.format(TESTDATA_USER_LASTNAME, number);
        String userPhone = String.format(TESTDATA_USER_PHONE, number);

        return new User(TestDataReader.getTestData(userEmail),
                TestDataReader.getTestData(userPassword),
                TestDataReader.getTestData(userFirstName),
                TestDataReader.getTestData(userLastName),
                TestDataReader.getTestData(userPhone));
    }
}
