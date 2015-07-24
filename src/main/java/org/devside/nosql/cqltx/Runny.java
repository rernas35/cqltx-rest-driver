package org.devside.nosql.cqltx;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jettison.json.JSONException;

public class Runny {
	
	public static void main(String[] args) throws JSONException, IOException {
		CqlSessionFactory factory = new CqlSessionFactory(new URL("http://localhost:8080/cqltx"));
		CqlSession session = factory.createNewSession();
		session.execute("insert into users(user_id) values(64433)");
		session.execute("insert into users(user_id) values(64434)");
		session.execute("insert into users(user_id) values(64435)");
		session.commit();
		
	}

}
