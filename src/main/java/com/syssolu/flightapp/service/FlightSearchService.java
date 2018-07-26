package com.syssolu.flightapp.service;

import java.util.List;

import com.syssolu.flightapp.vo.FlightDetailBean;

public interface FlightSearchService {
	List<FlightDetailBean> search(String origin, String destination);
}
