package com.syssolu.flightapp.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.syssolu.flightapp.vo.FlightDetail;

@Slf4j
@Service
public class FlightSearchServiceImpl implements FlightSearchService {

	@Override
	public List<FlightDetail> search(String origin, String destination) {
		log.info("searching the flights with origin={} and destination={}",origin, destination);

		// Test data to remove 

		FlightDetail f = new FlightDetail("LAS",new Date("6/23/2014 13:30:00"),"LAX",new Date("6/23/2014 14:40:00"),151.00);
		FlightDetail f1 = new FlightDetail("LAS",new Date("6/23/2014 13:30:00"),"LAX",new Date("6/23/2014 14:40:00"),151.00);
		FlightDetail f2 = new FlightDetail("ABC",new Date("6/23/2014 13:30:00"),"LAX",new Date("6/23/2014 14:40:00"),100.00);
		FlightDetail f3 = new FlightDetail("BCD",new Date("6/23/2014 13:30:00"),"LAX",new Date("6/23/2014 14:40:00"),90.00);
		FlightDetail f4 = new FlightDetail("BCD",new Date("6/23/2014 13:30:00"),"LAX",new Date("6/23/2014 14:40:00"),90.00);
		Set<FlightDetail> s = new HashSet<FlightDetail>();
		s.add(f);
		s.add(f1);
		s.add(f2);
		s.add(f3);
		s.add(f4);
		System.out.print(s.size());
		List<FlightDetail> flightDetails = s.stream().
				filter(flightDetail -> flightDetail.getOrigin().equalsIgnoreCase(origin) && flightDetail.getDestination().equalsIgnoreCase(destination))
				.collect(Collectors.toList());
		return flightDetails;
	}
}
