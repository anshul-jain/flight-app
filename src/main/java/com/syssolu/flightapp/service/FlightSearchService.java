package com.syssolu.flightapp.service;

import java.util.List;

import com.syssolu.flightapp.vo.FlightDetail;

public interface FlightSearchService {
	List<FlightDetail> search(String origin, String destination);
}
