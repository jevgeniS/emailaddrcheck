package org.jevgenis.emailaddrsearch.smtp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SMTPSocket extends Socket{
	public static final int PORT=25;
	
	public SMTPSocket(String hostName) throws UnknownHostException, IOException{
		super(hostName,PORT);
	}
}
