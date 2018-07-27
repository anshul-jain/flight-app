package com.syssolu.flightapp.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class FlightDetailBean implements Serializable {
	private static final long serialVersionUID = 5025128657888275954L;

	private String origin;
	private Date departureTime;
	private String destination;
	private Date destinationTime;
	private double price;
}
