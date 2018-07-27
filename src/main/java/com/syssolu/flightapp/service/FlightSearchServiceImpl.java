package com.syssolu.flightapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syssolu.flightapp.vo.FlightDetailBean;

@Slf4j
@Service
public class FlightSearchServiceImpl implements FlightSearchService {

	private ProviderDataLoaderService providerDataLoaderService;

	@Autowired
	public FlightSearchServiceImpl(ProviderDataLoaderService providerDataLoaderService) {
		this.providerDataLoaderService = providerDataLoaderService;
	}

	@Override
	public List<FlightDetailBean> search(String origin, String destination) {
		log.info("searching the flights with origin={} and destination={}", origin, destination);

		Comparator departureDateReverse = Comparator.comparing((FlightDetailBean p)->p.getDepartureTime());
		Comparator c = Comparator.comparing((FlightDetailBean p)->p.getPrice()).thenComparing(departureDateReverse);

		return (List<FlightDetailBean>) providerDataLoaderService.getFlightDetails().stream().filter(f->f.getOrigin().equalsIgnoreCase(origin) && f.getDestination().equalsIgnoreCase(destination))
				.sorted(c).collect(Collectors.toList());
	}
}
