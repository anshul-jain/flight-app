package com.syssolu.flightapp.service;

import java.util.ArrayList;
import java.util.List;

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

		// Test data to remove
		/*FlightDetailBean f = new FlightDetailBean("LAS",new Date("6/23/2014 13:30:00"),"LAX",new Date("6/23/2014 14:40:00"),151.00);
		FlightDetailBean f1 = new FlightDetailBean("LAS",new Date("6/23/2014 13:30:00"),"LAX",new Date("6/23/2014 14:40:00"),151.00);
		FlightDetailBean f2 = new FlightDetailBean("ABC",new Date("6/23/2014 13:30:00"),"LAX",new Date("6/23/2014 14:40:00"),100.00);
		FlightDetailBean f3 = new FlightDetailBean("BCD",new Date("6/23/2014 13:30:00"),"LAX",new Date("6/23/2014 14:40:00"),90.00);
		FlightDetailBean f4 = new FlightDetailBean("BCD",new Date("6/23/2014 13:30:00"),"LAX",new Date("6/23/2014 14:40:00"),90.00);
		Set<FlightDetailBean> s = new HashSet<FlightDetailBean>();
		s.add(f);
		s.add(f1);
		s.add(f2);
		s.add(f3);
		s.add(f4);
		System.out.print(s.size());
		List<FlightDetailBean> flightDetails = s.stream().
				filter(flightDetail -> flightDetail.getOrigin().equalsIgnoreCase(origin) && flightDetail.getDestination().equalsIgnoreCase(destination))
				.collect(Collectors.toList());*/
		List<FlightDetailBean> flightDetails = new ArrayList<>();
		
		/*for (FlightDetailBean flightDetailBean : providerDataLoaderService.flightDetails) {
			System.out.println(flightDetailBean.getDestination());
		}*/
		return flightDetails;
	}
}
