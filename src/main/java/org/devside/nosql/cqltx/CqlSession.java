package org.devside.nosql.cqltx;

import java.io.IOException;
import java.net.URL;

import org.codehaus.jettison.json.JSONException;

public class CqlSession {
	
	String transactionId;
	URL address;
	
	static public enum CqlTxCommand{
		OPEN_TRANSACTION_COMMAND("{\"commandType\" : \"openTransaction\" }"),
		EXECUTE_COMMAND("{\"commandType\" : \"execute\", \"txId\" : \"${transactionId}\" ,\"cql\":\"${cql}\" }"),
		COMMIT_TRANSACTION_COMMAND("{\"commandType\" : \"commitTransaction\", \"txId\" : \"${transactionId}\" }"),
		ROLLBACK_TRANSACTION_COMMAND("{\"commandType\" : \"commitTransaction\", \"txId\" : \"${transactionId}\" }");
		String template;
		
		private CqlTxCommand(String template){
			this.template = template;
		}
		
		public String getTemplate() {
			return template;
		}
	}
	
	public CqlSession(URL address,String transactionId) {
		this.transactionId = transactionId;
		this.address = address;
	}
	
	public CqlResponse execute(String cql) throws IOException, JSONException{
		String template = CqlTxCommand.EXECUTE_COMMAND.getTemplate();
		template = template.replaceAll("\\$\\{transactionId\\}", transactionId);
		template = template.replaceAll("\\$\\{cql\\}", cql);
		return CqlCommunicator.send(address, template);
	}
	
	public CqlResponse commit() throws IOException, JSONException{
		String template = CqlTxCommand.COMMIT_TRANSACTION_COMMAND.getTemplate();
		template = template.replaceAll("\\$\\{transactionId\\}", transactionId);
		return CqlCommunicator.send(address, template);
	}
	
	public CqlResponse rollback() throws IOException, JSONException{
		String template = CqlTxCommand.ROLLBACK_TRANSACTION_COMMAND.getTemplate();
		template = template.replaceAll("\\$\\{txId\\}", transactionId);
		return CqlCommunicator.send(address, template);
	}
	
	public static void main(String[] args) {
		String template = CqlTxCommand.EXECUTE_COMMAND.getTemplate().replaceAll("\\$\\{transactionId\\}", "12312");
		System.out.println(template);
	}
	
	
	

}
