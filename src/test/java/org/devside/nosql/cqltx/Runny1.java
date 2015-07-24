package org.devside.nosql.cqltx;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jettison.json.JSONException;

public class Runny1 {
	
	public static void main(String[] args) throws JSONException, IOException {
		CqlSessionFactory factory = new CqlSessionFactory(new URL("http://localhost:8080/cqltx"));
		CqlSession session = factory.createNewSession();
		session.execute("insert into users(user_id,fname,lname) values(44433,'ilker','ernas')");
		session.execute("insert into users(user_id,fname,lname) values(44434,'rifat','atar')");
		session.execute("insert into users(user_id,fname,lname) values(44435,'ilker','akkus')");
		
		session.execute("update users set fname='naci' where user_id=44434");
		
		session.execute("delete from users where user_id=44435");
		session.commit();
		
	}

}
