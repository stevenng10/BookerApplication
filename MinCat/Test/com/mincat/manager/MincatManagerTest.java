package com.mincat.manager;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class MincatManagerTest {

	MincatManager mng; 
	
	@Before
	public void setUpBeforeClass() throws Exception {
		mng = new MincatManager();
	}

	@Test
	public void HelloHi() {
		Assert.assertEquals("loHi", mng.minCat("Hello", "Hi"));
	}
	
	@Test
	public void HelloJava() {
		Assert.assertEquals("ellojava", mng.minCat("Hello", "java"));
	}
	
	@Test
	public void JavaHello() {
		Assert.assertEquals("javaello", mng.minCat("java", "Hello"));
	}
	
	@Test
	public void abcx() {
		Assert.assertEquals("cx", mng.minCat("abc", "x"));
	}
	
	@Test
	public void xabc() {
		Assert.assertEquals("xc", mng.minCat("x", "abc"));
	}
	
	@Test
	public void abc() {
		Assert.assertEquals("", mng.minCat("abc", ""));
	}

}
