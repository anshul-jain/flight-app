package com.syssolu.flightapp.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.syssolu.flightapp.util.CustomCsvToBean;
import com.syssolu.flightapp.util.FlightDetailBeanBuilder;
import com.syssolu.flightapp.vo.FlightDetail;
import com.syssolu.flightapp.vo.FlightDetailBean;

@Slf4j
@Service
public class ProviderDataLoaderService {

	private ResourceLoader resourceLoader;
	private FlightDetailBeanBuilder flightDetailBeanBuilder;
	public static Integer count = 0;
	String[] delimiter = {",", ":", "|"};
	private Set<FlightDetailBean> flightDetails = new HashSet<FlightDetailBean>();

	@Autowired
	public ProviderDataLoaderService(ResourceLoader resourceLoader, FlightDetailBeanBuilder flightDetailBeanBuilder) {
		this.resourceLoader = resourceLoader;
		this.flightDetailBeanBuilder = flightDetailBeanBuilder;
	}


	@PostConstruct
	public void init() {
		log.info("resource reading");
		Resource[] resources = null;
		try {
			resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:csv/*");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Resource resource : resources) {
			try {
				flightDetails.addAll(parseCsvFileToBeans(resource.getURL().getPath(), delimiter, FlightDetail.class).stream().map(this::convertToBean).collect(Collectors.toSet()));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static <T> List<T> parseCsvFileToBeans(final String filename, final String[] fieldDelimiter,
	                                               final Class<T> beanClass) throws FileNotFoundException {
		List<T> finalData = new ArrayList();
		CSVReader reader = null;
		final CustomCsvToBean<T> csv = new CustomCsvToBean<T>();
		try {
			reader = new CSVReader(new BufferedReader(new FileReader(filename)), fieldDelimiter[count].toCharArray()[0]);
			final HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<T>();
			strategy.setType(beanClass);

			csv.setColLength(5);
			finalData = csv.parse(strategy, reader);
		} catch (IOException e) {
			count++;

			finalData = parseCsvFileToBeans(filename, fieldDelimiter,
					beanClass);
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return finalData;
		}
	}

	public Set<FlightDetailBean> getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(Set<FlightDetailBean> flightDetails) {
		this.flightDetails = flightDetails;
	}

	private FlightDetailBean convertToBean(FlightDetail flightDetail) {
		return flightDetailBeanBuilder.build(flightDetail);
	}
}

