package com.mobiquity.assignment.atmlocator.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;


import com.mobiquity.assignment.atmlocator.beans.AtmDetails;
import com.mobiquity.assignment.atmlocator.beans.AtmDetails.Address;



public class ServiceLocatorTest {
	
	 
	   ServiceLocator locator;
	 
	 private List<AtmDetails> atmLocationList;

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testGetATMListfromService() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLocationsByCity() throws Exception {
		  when(locator.getDataFromService()).thenReturn(atmLocationList);
	        List<AtmDetails> AtmLocation = locator.getDataFromService();
	        assertEquals(AtmLocation.size(), 2);
	}
}
