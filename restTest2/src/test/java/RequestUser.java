


public class RequestUser {


private String name;

private String job;


/**
* No args constructor for use in serialization
*
*/
public RequestUser() {
}

/**
*
* @param name
* @param job
*/
public RequestUser(String name, String job) {
super();
this.name = name;
this.job = job;
}


public String getName() {
return name;
}


public void setName(String name) {
this.name = name;
}



public String getJob() {
return job;
}


public void setJob(String job) {
this.job = job;
}

public RequestUser withJob(String job) {
this.job = job;
return this;
}





}