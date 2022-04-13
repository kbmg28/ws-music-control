package constants;

import java.util.UUID;

import static br.com.kbmg.wshammeron.constants.JwtConstants.BEARER;

public abstract class BaseTestsConstants {

    public static final String ANY_VALUE = "Any value " + UUID.randomUUID();

    public static final String TOKEN =BEARER.concat("tokenTest");
    public static final String USER_TEST_NAME = "Integration test name";
    public static final String USER_TEST_PASSWORD = "739qpf*";
    public static final String USER_TEST_CELLPHONE = "47984366284";

    public static final String EVENT_TEST_CELLPHONE = "47984366284";

    public static String generateRandomEmail(){
        return "integration_test_"+ UUID.randomUUID().toString().replaceAll("-", "") +"@test.com";
    }
}
