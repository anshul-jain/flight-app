package com.syssolu.flightapp.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class FlightDetailBean implements Serializable {
	private static final long serialVersionUID = 5025128657888275954L;

	private String origin;
	private Date departureTime;
	private String destination;
	private Date destinationTime;
	private double price;

	/*@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FlightDetailBean that = (FlightDetailBean) o;
		return Objects.equals(origin, that.origin) &&
				Objects.equals(departureTime, that.departureTime) &&
				Objects.equals(destination, that.destination) &&
				Objects.equals(destinationTime, that.destinationTime) &&
				Objects.equals(price, that.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(origin, departureTime, destination, destinationTime, price);
	}*/
}
