package com.hyr.dependencyTests;

import org.testng.annotations.Test;

public class TestGroupDependency {

	@Test(groups="sanity")
	public void test1() {
		System.out.println("sanity");
	}
	
	@Test(groups="smoke")
	public void test2() {
		System.out.println("smoke");
	}
	@Test(groups="smoke")
	public void test3() {
		System.out.println("smoke");
	}
	@Test(dependsOnGroups = "smoke",alwaysRun=true)
	public void test0() {
		System.out.println("main test");
	}

}
