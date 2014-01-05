package org.jevgenis.emailaddrsearch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmailAddrSearcherTest {
	
	EmailAddrSearcher searcher;
	
	@Test
	public void getDomainTest() {
		searcher=new EmailAddrSearcher("email@domain.com");
		assertEquals("domain.com",searcher.getDomain());
		
		searcher=new EmailAddrSearcher("@domain.com");
		assertEquals("domain.com",searcher.getDomain());
		
		searcher=new EmailAddrSearcher("emaildomain.com");
		assertEquals("",searcher.getDomain());
		
		searcher=new EmailAddrSearcher("email@");
		assertEquals("",searcher.getDomain());
	}
	
	@Test
	public void isEmailServerFoundTest(){
		searcher=new EmailAddrSearcher("email@rosagroleasing.ru");
		assertTrue(searcher.isEmailServerFound());
		
		searcher=new EmailAddrSearcher("email@y21hoo.com");
		assertFalse(searcher.isEmailServerFound());
	}

}
