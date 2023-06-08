package lt.marius.pom.tests.restapi;

import lt.marius.rest_api.User;
import lt.marius.rest_api.UserRemoteRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersRestApiTest {

    @Test
    public void testUserRestApi() {
        String userName = "mojombo";
        String expectedResult = "mojombo";
        String actualResult;

        User user = UserRemoteRepository.getUser(userName);
        actualResult = user.getLogin();

        Assert.assertEquals(actualResult, expectedResult);

    }
}
