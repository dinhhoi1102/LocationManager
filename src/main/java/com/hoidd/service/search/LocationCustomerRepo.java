package com.hoidd.service.search;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.hoidd.entity.LocationCustomerEntity;


public interface LocationCustomerRepo extends MongoRepository<LocationCustomerEntity, String> {
	
//	GeoResults<LocationCustomerEntity> findByLocationNearAndTypeVehicleAndDateGreaterThan(int type, Date date, Point p, Distance d);
	//Find by phone
	LocationCustomerEntity findByPhone(String phone);
	//Find by location
	GeoResults<LocationCustomerEntity> findByLocationNear(Point p, Distance d);
	LocationCustomerEntity findByNameMerchine(String name);
}