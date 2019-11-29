package com.hoidd.service.search;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.hoidd.entity.LocationTechnicianEntity;


public interface LocationTechnicianRepo extends MongoRepository<LocationTechnicianEntity, String> {
	/**
	 * 
	 * @param date
	 * @param p
	 * @param d
	 * @return
	 */
	// tạm thời bỏ chuyển thành method dưới.
//	List<LocationPickerEntity> findByDateGreaterThanAndLocationNear(Date date, Point p, Distance d);
	
	List<LocationTechnicianEntity> findByLocationNear(Point p, Distance d);

}