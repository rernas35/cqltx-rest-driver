package org.devside.nosql.cqltx;

import java.io.IOException;
import java.net.URL;

import org.codehaus.jettison.json.JSONException;

public class CqlSessionFactory {

	URL restAddress;
			
	public CqlSessionFactory(URL address) {
		restAddress = address;
	}
	
	public CqlSession createNewSession() throws JSONException,IOException{
		CqlResponse resp = CqlCommunicator.send(restAddress, CqlSession.CqlTxCommand.OPEN_TRANSACTION_COMMAND.getTemplate());
		return new CqlSession(restAddress, resp.getTransactionId());
	}
	
}
