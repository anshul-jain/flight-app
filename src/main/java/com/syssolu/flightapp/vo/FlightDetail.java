package com.syssolu.flightapp.vo;

import lombok.Data;

@Data
public class FlightDetail {
	private String origin;
	private String departureTime;
	private String destination;
	private String destinationTime;
	private String price;
}
