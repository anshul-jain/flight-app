package com.syssolu.flightapp.util;

import org.springframework.stereotype.Component;

import com.syssolu.flightapp.vo.FlightDetail;
import com.syssolu.flightapp.vo.FlightDetailBean;

@Component
public class FlightDetailBeanBuilder {
	public FlightDetailBean build(FlightDetail flightDetail){
		FlightDetailBean flightDetailBean = new FlightDetailBean();
		flightDetailBean.setOrigin(flightDetail.getOrigin());
		flightDetailBean.setDestination(flightDetail.getDestination());
		//flightDetailBean.setDepartureTime(new Date(flightDetail.getDepartureTime()));
		//flightDetailBean.setDestinationTime(flightDetail.getDestinationTime());
		//flightDetailBean.setPrice(flightDetail.getPrice());
		System.out.println("called builder");
		return flightDetailBean;
	}
}
