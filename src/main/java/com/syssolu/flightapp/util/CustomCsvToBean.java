package com.syssolu.flightapp.util;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameMappingStrategy;

@Data
public class CustomCsvToBean<T> extends CsvToBean<T> {
	private String separator;
	private int colLength;
	private boolean hasDataReturned;

	public List<T> parse(HeaderColumnNameMappingStrategy<T> mapper, CSVReader csv) throws IOException {
		String[] header = null;
		List<T> list = new ArrayList<T>();
//		try {
		mapper.captureHeader(csv);
		Field[] fields = mapper.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
			if (fields[i].getName().equals("header")) {
				fields[i].setAccessible(true);
				try {
					header = (String[]) fields[i].get(mapper);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (header.length < colLength) {
					break;
				}

			}
		}

		if (header.length < colLength) {
			throw new IOException("Invalid separator");
		}
		String[] line;

		while (null != (line = csv.readNext())) {
			T obj = null;
			try {
				obj = processLine(mapper, line);
			} catch (IllegalAccessException | InvocationTargetException | InstantiationException
					| IntrospectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(obj); // TODO: (Kyle) null check object
		}
           
        /*} catch (Exception e) {
          //  throw new RuntimeException("Error parsing CSV!", e);
        }*/
		setHasDataReturned(true);
		return list;
	}
}
