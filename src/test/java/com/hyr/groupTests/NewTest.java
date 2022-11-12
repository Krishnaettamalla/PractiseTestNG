package com.hyr.groupTests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class NewTest {
 
  @Test(groups= {"smoke"})
  public void test1() {
	  System.out.println("Test1");
  }
  
  @Test(groups= {"smoke","functional"})
  public void test2() {   
	  System.out.println("Test2");
  }
  @Ignore
  @Test
  public void test3() {
	  System.out.println("Test3");
  }

}
