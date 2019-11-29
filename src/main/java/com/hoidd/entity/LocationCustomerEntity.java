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

@Document(collection = "location_customer")
@Data
@NoArgsConstructor
public class LocationCustomerEntity {
	@Id ObjectId databaseId;
	private String id;
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private GeoJsonPoint location;
	
	private int typeCustomer;
	
	private String phone;
	private String nameMerchine;
	private int typePurchase;
	private Date datePurchased;
	private String note;
	@DateTimeFormat(style="MM/dd/yyyy")
	private Date date;
	
	public LocationCustomerEntity(ObjectId databaseId, String id, GeoJsonPoint location, int typeCustomer) {
		super();
		this.databaseId = databaseId;
		this.id = id;
		this.location = location;
		this.typeCustomer = typeCustomer;
	}
	public LocationCustomerEntity( String id, GeoJsonPoint location, int typeCustomer) {
		super();
		this.id = id;
		this.location = location;
		this.typeCustomer = typeCustomer;
	}

	public LocationCustomerEntity(String id, GeoJsonPoint location, int typeCustomer, Date date) {
		super();
		this.id = id;
		this.location = location;
		this.typeCustomer = typeCustomer;
		this.date = date;
	}

	
}
