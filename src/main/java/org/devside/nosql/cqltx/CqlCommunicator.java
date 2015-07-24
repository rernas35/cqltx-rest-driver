package org.devside.nosql.cqltx;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jettison.json.JSONException;

class CqlCommunicator {
	
	static CqlResponse send(URL address, String cqlTxReq) throws IOException,JSONException{
		System.out.println("req:" + cqlTxReq);
		HttpURLConnection con = (HttpURLConnection) address.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		 
		
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(cqlTxReq);
		wr.flush();
		wr.close();
		
		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		String ret = response.toString();
		ret = ret.replaceAll("\\\\", "");
		ret = ret.substring(1,ret.length() -1);
		System.out.println("ret: " + ret);
		return new CqlResponse(ret);
	}
	
	
	
	

}
