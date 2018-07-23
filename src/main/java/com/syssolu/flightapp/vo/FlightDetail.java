package com.syssolu.flightapp.vo;

import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FlightDetail {
	private String origin;
	private Date departureTime;
	private String destination;
	private Date destinationTime;
	private double price;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FlightDetail that = (FlightDetail) o;
		return Objects.equals(origin, that.origin) &&
				Objects.equals(departureTime, that.departureTime) &&
				Objects.equals(destination, that.destination) &&
				Objects.equals(destinationTime, that.destinationTime) &&
				Objects.equals(price, that.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(origin, departureTime, destination, destinationTime, price);
	}
}
