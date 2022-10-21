

public class RequestregisterUser {


private String email;

private String password;



/**
* No args constructor for use in serialization
*
*/
public RequestregisterUser() {
}

/**
*
* @param password
* @param email
*/
public RequestregisterUser(String email, String password) {
super();
this.email = email;
this.password = password;
}


public String getEmail() {
return email;
}


public void setEmail(String email) {
this.email = email;
}

public RequestregisterUser withEmail(String email) {
this.email = email;
return this;
}


public String getPassword() {
return password;
}


public void setPassword(String password) {
this.password = password;
}

public RequestregisterUser withPassword(String password) {
this.password = password;
return this;
}





}