package com.syssolu.flightapp.util;

import org.springframework.stereotype.Component;

import com.syssolu.flightapp.vo.FlightDetail;
import com.syssolu.flightapp.vo.FlightDetailBean;

@Component
public class FlightDetailBeanBuilder {
	public FlightDetailBean build(FlightDetail flightDetail) {
		FlightDetailBean flightDetailBean = new FlightDetailBean();
		flightDetailBean.setOrigin(flightDetail.getOrigin());
		flightDetailBean.setDestination(flightDetail.getDestination());
		flightDetailBean.setDepartureTime(DateUtils.getFormattedDate(flightDetail.getDepartureTime()));
		flightDetailBean.setDestinationTime(DateUtils.getFormattedDate(flightDetail.getDestinationTime()));
		flightDetailBean.setPrice(Double.parseDouble(flightDetail.getPrice().substring(1)));
		return flightDetailBean;
	}
}
