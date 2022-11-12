package com.hyr.dependencyTests;


import org.testng.annotations.Test;

public class TestDependency {
	static String trackingNumber=null;
	@Test()
	public void CreateShipment() {
		System.out.println("CreateShipment");
		trackingNumber="ABC12YH";
	}
	@Test(dependsOnMethods = {"CreateShipment"})
	public void TrackShipment() throws Exception {
		System.out.println("CreateShipment");
		if(trackingNumber!=null) {
			System.out.println("TrackShipment");
		}
		else {
			throw new Exception("invalid tracking number");
		}  
	}
	@Test(dependsOnMethods = {"CreateShipment"})
	public void CancelShipment() throws Exception {
		System.out.println("CreateShipment");
		if(trackingNumber!=null) {
			System.out.println("Shipment");
		}
		else {
			throw new Exception("invalid tracking number");
		}
	}
	
}
