package com.hyr.groupTests;

import org.testng.annotations.Test;

public class NewTest2 {
  
  @Test(groups= {"smoke","functional"})
  public void test4() {
	  System.out.println("Test4");
  }
  @Test(groups= {"smoke","regression"})
  public void test5() {
	  System.out.println("Test2");
  }
  @Test(groups={"regression"})
  public void test6() {
	  System.out.println("Test3");
  }

}
