package org.jevgenis.emailaddrsearch;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;

import org.jevgenis.emailaddrsearch.mx.MXLookup;
import org.jevgenis.emailaddrsearch.mx.Record;

public class EmailAddrSearcher {
	
	private String address;
	private Record[] rows;
	
	public EmailAddrSearcher(String address){
		this.address=address;
	}
	
	public boolean isEmailServerFound(){
		this.rows=new MXLookup(getDomain()).getMXRecords();
		return rows.length>0 ? true : false;
	}
	
	public boolean isEmailAddressFound(){
		if (!isEmailServerFound()){
			return false;
		}
		
		return true;
		
	}
	
	String getDomain(){
		int domainStartsFrom=address.indexOf('@')+1;
		if (domainStartsFrom>=address.length() || domainStartsFrom<1){
			return "";
		}
		return address.substring(domainStartsFrom, address.length());
	}
	
	private void findAddrFromServers(Record[] serverAddr){
		
	}
}
