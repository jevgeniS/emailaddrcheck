package org.jevgenis.emailaddrsearch.mx;

public class Record {
	private int priority;
	private String serverAddress;
	
	public Record(int priority, String serverAddress){
		this.priority=priority;
		this.serverAddress=serverAddress;
	}
	
	public int getPriority() {
		return priority;
	}
	public String setserverAddress() {
		return serverAddress;
	}
}
