package com.syssolu.flightapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DateUtils {

	public static Date getFormattedDate(String date) {
		List<String> formatStrings = Arrays.asList("MM/dd/yyyy HH:mm:ss", "MM-dd-yyyy HH:mm:ss");

		for (String formatString : formatStrings) {
			try {
				return new SimpleDateFormat(formatString).parse(date);
			} catch (ParseException e) {
			}
		}
		return null;
	}
}
