package org.devside.nosql.cqltx;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jettison.json.JSONException;

public class Runny2 {
	
	public static void main(String[] args) throws JSONException, IOException {
		CqlSessionFactory factory = new CqlSessionFactory(new URL("http://localhost:8080/cqltx"));
		CqlSession session = factory.createNewSession();
		session.execute("insert into users(user_id,fname,lname) values(3433,'4ilker','ernas')");
		session.execute("insert into users(user_id,fname,lname) values(3434,'4rifat','atar')");
		session.execute("insert into users(user_id,fname,lname) values(3435,'4ilker','akkus')");
		
		session.execute("update users set fname='naci' where user_id=3434");
		
		session.execute("delete from users where user_id=3435");
		session.rollback();
		
	}

}
