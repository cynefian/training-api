package com.cynefian.base.business.Location;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

	List<LocationEntity> findByDatetime(String datetime);

	List<LocationEntity> findByLatitude(String latitude);

	List<LocationEntity> findByLongitude(String longitude);

	List<LocationEntity> findByLatitudeAndLongitude(String latitude, String longitute);

	List<LocationEntity> findByDeviceid(String deviceid);

	List<LocationEntity> findByDatetimeAndDeviceid(String datetime, String deviceid);

	List<LocationEntity> findByLocalDateTimeBetweenAndDeviceid(LocalDateTime startL, LocalDateTime endL, String deviceid);




	List<LocationEntity> findFirstByDeviceidOrderByIdDesc(String deviceid);


//	List<LocationEntity> findTwoByDeviceidOrderByIdDesc(String deviceid);



	

	

}
