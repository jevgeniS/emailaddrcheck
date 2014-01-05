package org.jevgenis.emailaddrsearch.mx;

import  java.util.Hashtable;

import  javax.naming.*;
import  javax.naming.directory.*;

public class MXLookup {
	private String domain;
	
	public MXLookup(String domain){
		this.domain=domain;
	}
	
	public Record[] getMXRecords(){
		Record[] recs=null;
		try {
			Attribute attr=doLookup();
			recs=parseToRecords(attr);
		} catch (NamingException e) {
			
		}
		
		return recs==null ? new Record[0] : recs;
		
	}
	
	private Attribute doLookup() throws NamingException {
	    Hashtable<String, String> env = new Hashtable<String, String>();
	    env.put("java.naming.factory.initial","com.sun.jndi.dns.DnsContextFactory");
	    DirContext ictx = new InitialDirContext( env );
	    Attributes attrs =ictx.getAttributes( domain, new String[] { "MX" });
	    Attribute attr = attrs.get( "MX" );
	    return attr;
	}
	
	Record[] parseToRecords(Attribute attr){
		int size=attr.size();
		Record[] recs=new Record[size];
		for (int i=0;i<size;i++){
			try {
				String row=(String) attr.get(i);
				String[] chunks=row.split(" ");
				int priority=Integer.parseInt(chunks[0]);
				String addr=chunks[1];
				recs[i]=new Record(priority,addr);
				
			} catch (Exception e) {
			}
			
		}
		return recs;
	}
	
	

}