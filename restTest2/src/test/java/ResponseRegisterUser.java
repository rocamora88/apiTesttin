

public class ResponseRegisterUser {


private int id;

private String token;



/**
* No args constructor for use in serialization
*
*/
public ResponseRegisterUser() {
}

/**
*
* @param id
* @param token
*/
public ResponseRegisterUser(int id, String token) {
super();
this.id = id;
this.token = token;
}


public int getId() {
return id;
}


public void setId(int id) {
this.id = id;
}

public ResponseRegisterUser withId(int id) {
this.id = id;
return this;
}


public String getToken() {
return token;
}


public void setToken(String token) {
this.token = token;
}

public ResponseRegisterUser withToken(String token) {
this.token = token;
return this;
}


}