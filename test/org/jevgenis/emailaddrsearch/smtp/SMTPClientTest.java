package org.jevgenis.emailaddrsearch.smtp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SMTPClientTest{

	public SMTPClient client;
	
	@Test
	public void testValidConnection(){
		client=new SMTPClient("alt1.gmail-smtp-in.l.google.com");
		client.check();
		assertEquals("",client.getError());
	}

}
