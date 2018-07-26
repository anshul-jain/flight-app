package com.syssolu.flightapp.api;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.syssolu.flightapp.service.FlightSearchService;
import com.syssolu.flightapp.vo.FlightDetailBean;

@Slf4j
@FlightSearchController
@RequestMapping(value = "/searchflights", produces = MediaType.APPLICATION_JSON_VALUE)
public class FlightSearchApiImpl implements FlightSearchApi {

	private FlightSearchService flightSearchService;

	@Autowired
	public FlightSearchApiImpl(FlightSearchService flightSearchService) {
		this.flightSearchService = flightSearchService;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/{origin}/{destination}")
	public ResponseEntity<List<FlightDetailBean>> search(@PathVariable("origin") String origin, @PathVariable("destination") String destination) {
		log.info("searching the flights with origin={} and destination={}", origin, destination);
		return new ResponseEntity<List<FlightDetailBean>>(flightSearchService.search(origin, destination), HttpStatus.OK);
	}
}
