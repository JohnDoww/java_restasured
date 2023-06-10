import static io.restassured.RestAssured.*;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import utils.Links;
import utils.UserInfo;

public class PetStoreTest {
    int id = 123123123;
    int userStatus = 0;
    String userName = "asdasdasdas";
    String firstName = "string";
    String lastName = "string";
    String email = "string";
    String password = "123";
    String phone = "string";
    String nameForChanging = "Alohaaa";

    Links links = new Links();
    UserInfo userInfo = new UserInfo(id, userName,
            firstName, lastName, email, password, phone, userStatus);
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();

    @Test(priority = 1)
    public void createUser() {
        String as = "[" + gson.toJson(userInfo) + "]";
        given().
                contentType(ContentType.JSON).
                body(as).
                when().
                post(links.GET_CREATE_USER()).
                then().
                statusCode(SC_OK).
                body("code", equalTo(SC_OK));
    }

    @Test(priority = 2)
    public void updateUser() {
        userInfo.setUsername(nameForChanging);

        given().
                contentType(ContentType.JSON).
                body(gson.toJson(userInfo)).
                when().
                put(links.getUpdateUser() + userName).
                then().
                statusCode(SC_OK).
                body("message", equalTo(Integer.toString(id)));

    }

    @Test(priority = 3)
    public void findUser() {
        get(links.GET_FIND_USER_BY_NAME() + userInfo.getUsername()).
                then().
                statusCode(SC_OK).
                body("id", equalTo(id)).
                and().
                body("username", equalTo(userInfo.getUsername()));
    }

    @Test(priority = 4)
    public void userLogIn() {
        get(links.getLogIn()).
                then().
                statusCode(SC_OK).
                body("code", equalTo(SC_OK));

    }

    @Test(priority = 5)
    public void deleteUser() {
        delete(links.GET_DELETE_USER_BY_NAME() + userInfo.getUsername()).
                then().
                statusCode(SC_OK).
                body("message", equalTo(userInfo.getUsername()));
    }
}
