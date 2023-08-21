package com.cynefian.base.business.Location;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "location")

public class LocationEntity {

	public LocationEntity() {
	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "datetime")
	private String datetime;
	
	@Column(name="LocalDateTime")
	private LocalDateTime localDateTime;


	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}


	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	@Column(name = "deviceid")
	private String deviceid;

	@Column(name = "longitude")
	private String longitude;

	@Column(name = "latitude")
	private String latitude;
	
	@Transient
	private String colorCode;
		
    public String toString() {
		
		return "LocationEntity [id=" + id + ", datetime=" + datetime + ", deviceid=" + deviceid + ", longitude=" + longitude
				+ ", latitude=" + latitude +"]";
		
	}
	
	


	public LocationEntity(String datetime, String deviceid, String longitude, String latitude) {
		this.datetime = datetime;
	


		this.deviceid = deviceid;
		this.latitude = latitude;
		this.longitude=longitude;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDatetime() {
		return datetime;
	}


	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}



	public String getDeviceid() {
		return deviceid;
	}


	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getColorCode() {
		return colorCode;
	}


	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	
}
