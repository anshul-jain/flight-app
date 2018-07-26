package com.syssolu.flightapp.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.syssolu.flightapp.vo.FlightDetailBean;

public interface FlightSearchApi {
	public ResponseEntity<List<FlightDetailBean>> search(@PathVariable("origin") String origin, @PathVariable("destination") String destination);
}
