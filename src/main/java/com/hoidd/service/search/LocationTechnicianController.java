package com.hoidd.service.search;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoidd.core.payload.ApiResponse;
import com.hoidd.entity.LocationCustomerEntity;
import com.hoidd.entity.LocationTechnicianEntity;
import com.hoidd.entity.Technician;

@RestController
@RequestMapping("/api/driver/location")
public class LocationTechnicianController {

	@Autowired
	LocationCustomerRepo locationRepo;
	
	@Autowired
	LocationTechnicianRepo locationTechnicianRepo;
	
	@GetMapping("/get-all-near")
	public ApiResponse<List<LocationTechnicianEntity>> getAll(@RequestParam Map<String, String> requestParam){
		String latitude = requestParam.get("latitude");
		String longitude = requestParam.get("longitude");
		Double distance = Double.valueOf(requestParam.get("distance"));

//		Date date = getTimeDateBefor();
		return new ApiResponse<List<LocationTechnicianEntity>>().getSucessResponse
				(locationTechnicianRepo.findByLocationNear(
						new Point(Double.valueOf(latitude),Double.valueOf(longitude)),
						new Distance(distance, Metrics.KILOMETERS)),"Danh sách khách hàng gần đây.");
	}
	
	@GetMapping("/count-all-near")
	public ApiResponse<Integer> countNearLocation(@RequestParam Map<String, String> requestParam){
		String latitude = requestParam.get("latitude");
		String longitude = requestParam.get("longitude");
		Double distance = Double.valueOf(requestParam.get("distance"));
//		Date date = getTimeDateBefor();
		return new ApiResponse<Integer>().getSucessResponse
				(locationTechnicianRepo.findByLocationNear(
						new Point(Double.valueOf(latitude),Double.valueOf(longitude)),
						new Distance(distance, Metrics.KILOMETERS)).size(),"Số lượng khách hàng quanh đây.");
	}
	
	@PostMapping("/update-location")
	public ApiResponse<LocationCustomerEntity> updateLocation(@RequestParam Map<String, String> requestParam, @RequestAttribute("driver") Technician technician){
		String latitude = requestParam.get("latitude");
		String longitude = requestParam.get("longitude");
		String sid = String.valueOf(technician.getId());
		int type =1;
		if(technician.getVehicle()!=null) {
			 type =technician.getVehicle().getId();
		}
		if(latitude==null||longitude==null||sid==null) {
			return new ApiResponse<LocationCustomerEntity>().getSucessResponse
					(null,"Cập nhật không thành công.");
		}
		List<Double> position = new ArrayList<>();
		position.add(Double.valueOf(latitude));
		position.add(Double.valueOf(longitude));
		LocationCustomerEntity locationEntity = new LocationCustomerEntity();
		locationEntity.setId(sid);
		locationEntity.setTypeCustomer(type);
		locationEntity.setDate(new Date());
		locationEntity.setLocation(new GeoJsonPoint(Double.valueOf(latitude),Double.valueOf(longitude)));
		List<LocationCustomerEntity> listLocationEntity = new ArrayList<>();
		listLocationEntity.add(locationEntity);
		return new ApiResponse<LocationCustomerEntity>().getSucessResponse
				(locationRepo.save(locationEntity),"Cập nhật thành công.");
		
	}
	
	
	private Date getTimeDateBefor() {
		Date date = new Date();
		Calendar cal =  Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, -10);
		date = cal.getTime();
		return date;
	}
}
