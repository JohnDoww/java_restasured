package utils;

public class Links {

    UserInfo userInfo = new UserInfo();

    public Links() {
    }

    private final String CREATE_USER = "https://petstore.swagger.io/v2/user/createWithList";

    public String GET_CREATE_USER() {
        return CREATE_USER;
    }

    private final String FIND_USER_BY_NAME = "https://petstore.swagger.io/v2/user/";

    public String GET_FIND_USER_BY_NAME() {
        return FIND_USER_BY_NAME;
    }

    private String updateUser = "https://petstore.swagger.io/v2/user/" + userInfo.getUsername();

    public String getUpdateUser() {
        return updateUser;
    }

    private String logIn = "https://petstore.swagger.io/v2/user/login?username=" + userInfo.getUsername() + "&password=" + userInfo.getPassword();

    public String getLogIn() {
        return logIn;
    }


    private final String DELETE_USER_BY_NAME = "https://petstore.swagger.io/v2/user/";

    public String GET_DELETE_USER_BY_NAME() {
        return DELETE_USER_BY_NAME;
    }


}