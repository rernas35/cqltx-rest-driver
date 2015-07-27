# cqltx-rest-driver
drive for restful interface of cql-tx

## Usage
```java
    CqlSessionFactory factory = new CqlSessionFactory(new URL("http://localhost:8080/cqltx"));
		CqlSession session = factory.createNewSession();
		session.execute("insert into grouped_users(user_id,fname,lname, group,age) values(7004,'test1','test2','engineering',21)");
		
		
//		session.execute("delete from users where user_id=3435");
		session.commit();

```

