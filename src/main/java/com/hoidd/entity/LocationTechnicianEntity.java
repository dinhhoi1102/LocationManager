package com.hoidd.entity;


import java.util.Date;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "location_technician")
@Data
@NoArgsConstructor
public class LocationTechnicianEntity {
	@Id ObjectId databaseId;
	private String id;
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private GeoJsonPoint location;
	
	private int typeVehicle;

	@DateTimeFormat(style="MM/dd/yyyy")
	private Date date;
	
	public LocationTechnicianEntity(ObjectId databaseId, String id, GeoJsonPoint location, int typeVehicle) {
		super();
		this.databaseId = databaseId;
		this.id = id;
		this.location = location;
		this.typeVehicle = typeVehicle;
	}
	public LocationTechnicianEntity( String id, GeoJsonPoint location, int typeVehicle) {
		super();
		this.id = id;
		this.location = location;
		this.typeVehicle = typeVehicle;
	}

	public LocationTechnicianEntity(String id, GeoJsonPoint location, int typeVehicle, Date date) {
		super();
		this.id = id;
		this.location = location;
		this.typeVehicle = typeVehicle;
		this.date = date;
	}

	
}
