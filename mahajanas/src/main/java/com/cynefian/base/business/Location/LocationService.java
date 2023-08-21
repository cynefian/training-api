package com.cynefian.base.business.Location;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cynefian.base.exceptions.RecordNotFoundException;

@Service
public class LocationService {

	@Autowired
	LocationRepository repository;
	
	
	public LocationService(LocationRepository repo) {
		this.repository = repo;
	}

	public List<LocationEntity> getAllLocation() {
		List<LocationEntity> locList = repository.findAll();

		if (locList.size() > 0) {

			return locList;
		} else {
			return new ArrayList<LocationEntity>();
		}
	}

	public LocationEntity getLocationById(Long id) throws RecordNotFoundException {
		Optional<LocationEntity> feature = repository.findById(id);

		if (feature.isPresent()) {
			return feature.get();
		} else {
			throw new RecordNotFoundException("No Location exist for given id", id);
		}
	}
	

	
	
	
	public List<LocationEntity> getLocationByDatetime(String datetime) throws RecordNotFoundException {
		List<LocationEntity> obj = repository.findByDatetime(datetime);

		if (obj != null && obj.size() > 0) {
			return obj;
		} else {
			throw new RecordNotFoundException("No location exist for given datetime", datetime);
		}
	}

public List<LocationEntity> getLocationByDatetimeAndDeviceid(String datetime,String deviceid) throws RecordNotFoundException {
		
		List<LocationEntity> obj = repository.findByDatetimeAndDeviceid(datetime,deviceid);

		if (obj != null && obj.size() > 0) {
			return obj;
		} else {
return null;		}
	}
	
	
public List<LocationEntity> getLocationByrecentDeviceid(String deviceid) throws RecordNotFoundException {
		List<LocationEntity> obj = repository.findFirstByDeviceidOrderByIdDesc(deviceid);

		if (obj != null && obj.size() > 0) {
			return obj;
		} else {
			return null;
		}
	}
public List<LocationEntity> getLocationByDeviceid(String deviceid) throws RecordNotFoundException {
		List<LocationEntity> obj = repository.findByDeviceid(deviceid);

		if (obj != null && obj.size() > 0) {
			return obj;
		} else {
			return null;
		}
	}
public List<LocationEntity> getLocationByLatitude(String latitude) throws RecordNotFoundException {
		List<LocationEntity> obj = repository.findByLatitude(latitude);

		if (obj != null && obj.size() > 0) {
			return obj;
		} else {
			throw new RecordNotFoundException("No location exist for given latitude", latitude);
		}
	}

	
public List<LocationEntity> getLocationByLatitudeAndLongitude(String latitude, String longitude) throws RecordNotFoundException {
		List<LocationEntity> obj = repository.findByLatitudeAndLongitude(latitude, longitude);

		if (obj != null && obj.size() > 0) {
			return obj;
		} else {
			throw new RecordNotFoundException("No location exist for given latitude", latitude, longitude);
		}
	}
public List<LocationEntity> getLocationByLongitude(String longitude) throws RecordNotFoundException {
		List<LocationEntity> obj = repository.findByLongitude(longitude);

		if (obj != null && obj.size() > 0) {
			return obj;
		} else {
			throw new RecordNotFoundException("No location exist for given Longitude", longitude);
		}
	}

	public LocationEntity createLocation(LocationEntity entity) throws RecordNotFoundException {
		return entity = repository.save(entity);

	}
public LocationEntity updateLocation(LocationEntity entity) throws RecordNotFoundException {
		if (entity.getId() != null) {
			Optional<LocationEntity> obj = repository.findById(entity.getId());
			if (obj.isPresent()){
			LocationEntity newEntity = obj.get();
			newEntity.setDeviceid(entity.getDeviceid()!=null?entity.getDeviceid():obj.get().getDeviceid());
			newEntity.setDatetime(entity.getDatetime()!=null?entity.getDatetime():obj.get().getDatetime());
			newEntity.setLatitude(entity.getLatitude()!=null?entity.getLatitude():obj.get().getLatitude());
			newEntity.setLongitude(entity.getLongitude()!=null?entity.getLongitude():obj.get().getLongitude());
		    newEntity = repository.save(newEntity);
		    
		    return newEntity;
		    
			} else {
				return entity;
			}
		}
		throw new RecordNotFoundException("No location exist for given id", entity.getId());
	}

public List<LocationEntity> getLocationByDeviceidAndDateTime(Object datetime) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<LocationEntity> getLocationByDateTimeBetweenAndDeviceId(LocalDateTime startL, LocalDateTime endL,
			String deviceid) {
		List<LocationEntity> list = repository.findByLocalDateTimeBetweenAndDeviceid(startL, endL, deviceid);
		return list;
	}
private static String generateRandomDarkColorHex() {
		    Random random = new Random();
		    String hex = "#";
		    for (int i = 0; i < 3; i++) {
		      int colorComponent = random.nextInt(96) + 32; // generate value between 32 and 127
		      hex += Integer.toHexString(colorComponent);
		    }
		    return hex;
		  }
 

	



		
		
	}



