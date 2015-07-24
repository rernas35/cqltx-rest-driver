package org.devside.nosql.cqltx;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class CqlResponse {

	String responseCode;
	int status = 0;
	String description;
	String transactionId;
	
	public CqlResponse(String ret) throws JSONException{
		JSONObject retObject = new JSONObject(ret);
		responseCode = retObject.getString("responseCode");
		status = retObject.getInt("status");
		description = retObject.getString("description");
		if (retObject.has("txId"))
			transactionId = retObject.getString("txId");
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getResponseCode() {
		return responseCode;
	}
	
	public String getDescription() {
		return description;
	}
	
	
	
	
	
}
