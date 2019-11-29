package com.hoidd.entity;


import java.util.Date;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

//@Document(collection = "location_picker")
public class LocationPickerEntity {
	@Id ObjectId databaseId;
	private String id;
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private GeoJsonPoint location;

	@DateTimeFormat(style="MM/dd/yyyy")
	private Date date;
	
	public LocationPickerEntity( final GeoJsonPoint location) {
		this.location = location;
	}

	public LocationPickerEntity(ObjectId databaseId, String id, GeoJsonPoint location, Date date) {
		super();
		this.databaseId = databaseId;
		this.id = id;
		this.location = location;
		this.date = date;
	}

	public ObjectId getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(ObjectId databaseId) {
		this.databaseId = databaseId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public GeoJsonPoint getLocation() {
		return location;
	}

	public void setLocation(GeoJsonPoint location) {
		this.location = location;
	}

	public Date getTimestamp() {
		return date;
	}

	public void setTimestamp(Date timestamp) {
		this.date = timestamp;
	}

	public LocationPickerEntity() {
		super();
	}

	@Override
	public String toString() {
		return "LocationPickerEntity [databaseId=" + databaseId + ", id=" + id + ", location=" + location
				+ ", timestamp=" + date + "]";
	}

	

}
