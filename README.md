# cqltx-rest-driver
driver for restful interface of cql-tx

## Usage
```java
...
	// cql-tx rest server address
	CqlSessionFactory factory = new CqlSessionFactory(new URL("http://localhost:8080/cqltx"));
	//create new session	
 	CqlSession session = factory.createNewSession();
	session.execute("insert into grouped_users(user_id,fname,lname, group,age) values(7004,'test1','test2','engineering',21)");
	//commit the session	
	session.commit();

```

