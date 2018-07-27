package com.syssolu.flightapp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.syssolu.flightapp.service.FlightSearchService;
import com.syssolu.flightapp.vo.FlightDetailBean;

public class FlightSearchApiImplTest {

	@Mock
	private FlightSearchService flightSearchService;
	@InjectMocks
	private FlightSearchApiImpl flightSearchApi;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void searchTest() {
		when(flightSearchService.search(anyString(), anyString())).thenReturn(Collections.singletonList(new FlightDetailBean()));
		ResponseEntity<List<FlightDetailBean>> response = flightSearchApi.search("testOr", "testDes");

		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).hasSize(1);
	}
}
