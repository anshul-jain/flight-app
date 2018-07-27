package com.syssolu.flightapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.syssolu.flightapp.vo.FlightDetailBean;

public class FlightSearchServiceImplTest {

	@Mock
	private ProviderDataLoaderService providerDataLoaderService;
	@InjectMocks
	private FlightSearchServiceImpl flightSearchService;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void searchTest_FlightFound() {

		when(providerDataLoaderService.getFlightDetails()).thenReturn(Collections.singleton(new FlightDetailBean("demoOrigin", new Date("6/23/2014 13:30:00"), "demoDestination", new Date("6/23/2014 14:40:00"), 150.00)));
		List<FlightDetailBean> flightDetailBeanList = flightSearchService.search("demoOrigin", "demoDestination");

		assertThat(flightDetailBeanList).isNotNull();
		assertThat(flightDetailBeanList).hasSize(1);
	}

	@Test
	public void searchTest_FlightNotFound() {

		when(providerDataLoaderService.getFlightDetails()).thenReturn(Collections.singleton(new FlightDetailBean("demoOrigin", new Date("6/23/2014 13:30:00"), "demoDestination", new Date("6/23/2014 14:40:00"), 150.00)));
		List<FlightDetailBean> flightDetailBeanList = flightSearchService.search("demoOrigin", "destination");

		assertThat(flightDetailBeanList).isNotNull();
		assertThat(flightDetailBeanList).hasSize(0);
	}
}
