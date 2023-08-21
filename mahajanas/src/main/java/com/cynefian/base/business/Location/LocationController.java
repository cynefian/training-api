package com.cynefian.base.business.Location;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cynefian.base.exceptions.*;

@RestController
@CrossOrigin
@RequestMapping("/api/location")
public class LocationController {

	@Autowired
	LocationService service;
	
	@GetMapping
	public ResponseEntity<List<LocationEntity>> getAllLocation() {
		List<LocationEntity> list = service.getAllLocation();

		return new ResponseEntity<List<LocationEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	
	public ResponseEntity<LocationEntity> getLocationById(@PathVariable("id") Long id) throws RecordNotFoundException {
		LocationEntity entity = service.getLocationById(id);

		return new ResponseEntity<LocationEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/deviceid={deviceid}")
	
	public ResponseEntity<List<LocationEntity>> getLocationByrecentDeviceid(@PathVariable("deviceid") String deviceid)
			throws RecordNotFoundException {
		List<LocationEntity> entity = service.getLocationByrecentDeviceid(deviceid);

		return new ResponseEntity<List<LocationEntity>>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	@GetMapping("/device={deviceid}")
		public ResponseEntity<List<LocationEntity>> getLocationByDeviceid(@PathVariable("deviceid") String deviceid)
			throws RecordNotFoundException {
		List<LocationEntity> entity = service.getLocationByDeviceid(deviceid);

		return new ResponseEntity<List<LocationEntity>>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	

	@GetMapping("/datetime={datetime}")
		public ResponseEntity<List<LocationEntity>> getLocationByDatetime(@PathVariable("datetime") String datetime)
			throws RecordNotFoundException {
		List<LocationEntity> entity = service.getLocationByDatetime(datetime);

		return new ResponseEntity<List<LocationEntity>>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/latitude={latitude}")
		public ResponseEntity<List<LocationEntity>> getLocationByLatitude(@PathVariable("latitude") String latitude)
			throws RecordNotFoundException {
		List<LocationEntity> entity = service.getLocationByLatitude(latitude);

		return new ResponseEntity<List<LocationEntity>>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/longitude={longitude}")
		public ResponseEntity<List<LocationEntity>> getLocationByLongitude(@PathVariable("longitude") String longitude)
			throws RecordNotFoundException {
		List<LocationEntity> entity = service.getLocationByLongitude(longitude);

		return new ResponseEntity<List<LocationEntity>>(entity, new HttpHeaders(), HttpStatus.OK);
	}


	@PostMapping("/create")
	public ResponseEntity<Void> createLocation(@Valid @RequestBody LocationEntity Location)
			throws RecordNotFoundException, ParseException {

		Date d = null;
		String dt = "";
		SimpleDateFormat sdfDevice = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		d = sdfDevice.parse(Location.getDatetime());
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		dt = sdf2.format(d);

		Location.setDatetime(dt);
		Location.setLocalDateTime(d.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());

		LocationEntity create = service.createLocation(Location);
		if(create.getId()!=null){
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		
		
		
	}

	@PostMapping("/update")
		public ResponseEntity<LocationEntity> updateLocation(@Valid @RequestBody LocationEntity Location)
			throws RecordNotFoundException {
		LocationEntity updated = service.updateLocation(Location);
		return new ResponseEntity<LocationEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}
	 

}
