package com.cynefian.base.business.Location;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/LocationDo")
public class LocationFilterController {

	@Autowired
	LocationService service;

	@GetMapping("/deviceid={deviceid}/startdate={startdate}/enddate={enddate}")
	public List<LocationEntity> getLocationFilterByStartdate(@PathVariable("deviceid") String deviceid,
			@PathVariable("startdate") String startdate, @PathVariable("enddate") String enddate) throws ParseException

	{

		String sDate = startdate+" 00:00:00";
		String eDate = enddate+" 23:59:59";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date dStart = sdf.parse(sDate);
		Date dEnd = sdf.parse(eDate);

		LocalDateTime startL = dStart.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime endL = dEnd.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		List<LocationEntity> dve = service.getLocationByDateTimeBetweenAndDeviceId(startL, endL, deviceid);

		// List<LocationEntity>
		// dve=service.getLocationByDatetimeAndDeviceid(startdate,deviceid);
		// today's date

		List<LocationEntity> dve1 = service.getLocationByDatetimeAndDeviceid(enddate, deviceid);

		/*
		 * String localDateStart =dve.get(0).getDatetime(); Long maxindex1;
		 * if(dve1.size()==1) { maxindex1 = dve1.get(0).getId(); } else{ maxindex1 =
		 * (long) 0;} for (int i = 0; i < dve1.size()-1; i++) {
		 * 
		 * if (dve1.get(i).getId() < dve1.get(i+1).getId()) { maxindex1 =
		 * dve1.get(i+1).getId(); } }
		 * 
		 * LocationEntity le=service.getLocationById(maxindex1);
		 * 
		 * String localDateEnd =le.getDatetime();
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * List<String> dateList =new ArrayList<String>(); dateList.add(localDateStart);
		 * dateList.add(localDateEnd); List<LocationEntity> fe=new
		 * ArrayList<LocationEntity>();
		 * 
		 * List<LocationEntity> Nfrd=new ArrayList<LocationEntity>(); for(String
		 * dL:dateList) {
		 * 
		 * fe=null; fe=service.getLocationByDatetimeAndDeviceid(dL,deviceid);
		 * 
		 * 
		 * if(fe!=null) { Long maxindex; if(fe.size()==1) { maxindex =
		 * fe.get(0).getId(); } else{ maxindex = (long) 0;} for (int i = 0; i <
		 * fe.size()-1; i++) {
		 * 
		 * if (fe.get(i).getId() < fe.get(i+1).getId()) { maxindex =
		 * fe.get(i+1).getId(); } }
		 * 
		 * LocationEntity frd =new LocationEntity();
		 * frd=service.getLocationById(maxindex); LocationEntity frd1 =new
		 * LocationEntity(); frd1.setLatitude(frd.getLatitude());
		 * frd1.setLongitude(frd.getLongitude()); frd1.setDatetime(frd.getDatetime());
		 * frd1.setDeviceid(frd.getDeviceid());
		 * 
		 * Nfrd.add(frd1); } }
		 */

		return dve;

	}

}