package com.syssolu.flightapp.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.syssolu.flightapp.vo.FlightDetail;

public interface FlightSearchApi {
	public ResponseEntity<List<FlightDetail>> search(@PathVariable("origin") String origin, @PathVariable("destination") String destination);
}
