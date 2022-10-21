

public class ResponseUser {


private String name;

private String job;

private String id;

private String createdAt;



/**
* No args constructor for use in serialization
*
*/
public ResponseUser() {
}

/**
*
* @param createdAt
* @param name
* @param id
* @param job
*/
public ResponseUser(String name, String job, String id, String createdAt) {
super();
this.name = name;
this.job = job;
this.id = id;
this.createdAt = createdAt;
}


public String getName() {
return name;
}


public void setName(String name) {
this.name = name;
}

public ResponseUser withName(String name) {
this.name = name;
return this;
}


public String getJob() {
return job;
}


public void setJob(String job) {
this.job = job;
}

public ResponseUser withJob(String job) {
this.job = job;
return this;
}


public String getId() {
return id;
}


public void setId(String id) {
this.id = id;
}

public ResponseUser withId(String id) {
this.id = id;
return this;
}


public String getCreatedAt() {
return createdAt;
}


public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public ResponseUser withCreatedAt(String createdAt) {
this.createdAt = createdAt;
return this;
}




}