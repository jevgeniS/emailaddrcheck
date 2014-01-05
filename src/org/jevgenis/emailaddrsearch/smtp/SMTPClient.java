package org.jevgenis.emailaddrsearch.smtp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SMTPClient {
	private Socket socket;
	private String domain;
	private String error=Status.EMPTY;
	
	public SMTPClient(String domain){
		this.domain=domain;
	}
	
	public String getError(){
		return error;
	}
	
	public void check(){
		socket=new Socket();
		openConnection();
		closeConnection();
		
	}
	
	private void openConnection(){
		try {
			socket=new SMTPSocket(domain);
		} catch (UnknownHostException e) {
			error=Status.CONNECTION_ERR;
		} catch (IOException e) {
			error=Status.CONNECTION_ERR;
		}
	}
	
	private void closeConnection(){
		try {
			socket.close();
		} catch (IOException e) {
		}
	}
}
