package com.hoidd.service.search;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoidd.core.payload.ApiResponse;
import com.hoidd.entity.LocationCustomerEntity;
import com.hoidd.entity.LocationEntity;
import com.hoidd.entity.LocationPickerEntity;
import com.hoidd.entity.Technician;
//import com.hoidd.service.driver.account.repository.AccountRepo;

@RestController
@RequestMapping("/api/picker/location-picker")
public class LocationCustomerController {

	@Autowired
	LocationTechnicianRepo locationTechnicianRepo;
	
	@Autowired
	LocationCustomerRepo locationCustomerRepo;
	
//	@Autowired
//	private AccountRepo accountRepo;

	
	@GetMapping("/get-all")
	public ApiResponse<List<LocationCustomerEntity>> getAll(){
		return new ApiResponse<List<LocationCustomerEntity>>().getSucessResponse(locationCustomerRepo.findAll(),"Danh sách khách hàng.");
	}
	
	@GetMapping("/get-all-near")
	public ApiResponse<List<LocationCustomerEntity>> getAll(@RequestParam Map<String, String> requestParam){
		String latitude = requestParam.get("latitude");
		String longitude = requestParam.get("longitude");
//		String typeString = requestParam.get("type");
//		int type =1;
//		if(typeString!=null) {
//			type = Integer.parseInt(typeString);
//		}
//		
		Double distance = Double.valueOf(requestParam.get("distance"));
		GeoResults<LocationCustomerEntity> geoResulfs = locationCustomerRepo.findByLocationNear(new Point(Double.valueOf(latitude),Double.valueOf(longitude)),
			      new Distance(distance, Metrics.KILOMETERS));
		List<GeoResult<LocationCustomerEntity>> listLocation = geoResulfs.getContent();
//		return new ApiResponse<List<LocationCustomerEntity>>().getSucessResponse
//				(listLocation,"Danh sách tài xế gần đây.");
		return null;
	}
	
	@GetMapping("/get-by-phone")
	public ApiResponse<LocationCustomerEntity> getByPhone(@RequestParam Map<String, String> requestParam){
		String phone = requestParam.get("phone");
		LocationCustomerEntity locationCustomerEntity = locationCustomerRepo.findByPhone(phone);
		return new ApiResponse<LocationCustomerEntity>().getSucessResponse
				(locationCustomerEntity,"Tìm kiếm khách hàng bằng sdt.");
	}
	@GetMapping("/get-by-name")
	public ApiResponse<LocationCustomerEntity> getByNameMerchine(@RequestParam Map<String, String> requestParam){
		String nameMerchine = requestParam.get("name_merchine");
		LocationCustomerEntity locationCustomerEntity = locationCustomerRepo.findByNameMerchine(nameMerchine);
		return new ApiResponse<LocationCustomerEntity>().getSucessResponse
				(locationCustomerEntity,"Tìm kiếm khách hàng bằng thông tin máy.");
	}
	@PostMapping("/update-location")
	public ApiResponse<LocationCustomerEntity> updateLocation(@RequestParam Map<String, String> requestParam){
		String latitude = requestParam.get("latitude");
		String longitude = requestParam.get("longitude");
		String sid = requestParam.get("sid");
		if(latitude==null||longitude==null||sid==null) {
			return null;
		}
		List<Double> position = new ArrayList<>();
		position.add(Double.valueOf(latitude));
		position.add(Double.valueOf(longitude));
		LocationCustomerEntity locationEntity = new LocationCustomerEntity();
		locationEntity.setId(sid);
		locationEntity.setLocation(new GeoJsonPoint(Double.valueOf(latitude),Double.valueOf(longitude)));
		List<LocationCustomerEntity> listLocationEntity = new ArrayList<>();
		listLocationEntity.add(locationEntity);
		return new ApiResponse<LocationCustomerEntity>().getSucessResponse
				(locationCustomerRepo.save(locationEntity),"Cập nhật thành công.");
		
	}
	
	private Date getTimeDefault() {
		Date date = new Date();
		Calendar cal =  Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, -1);
		date = cal.getTime();
		return date;
	}

//	private List<LocationDriverDTO> convertToListLocation(GeoResults<LocationEntity> geoResulfs) {
//		List<LocationDriverDTO> listLocation = new ArrayList<LocationDriverDTO>();
//		geoResulfs.getContent();
//		List<Integer> listId = geoResulfs.getContent().stream().map(x->Integer.parseInt(x.getContent().getId())).collect(Collectors.toList());
//		List<Driver> listDriver = accountRepo.findAllById(listId);
//		Map<Integer, Driver> mapListDriver =
//				listDriver.stream().collect(Collectors.toMap(Driver::getId,
//			                                              Function.identity()));
//		for (GeoResult<LocationEntity> geoSingle : geoResulfs) {
//			geoSingle.getContent();
//			LocationDriverDTO locationDto= new LocationDriverDTO(); 
//			locationDto.setLatitude(geoSingle.getContent().getLocation().getX());
//			locationDto.setLongitude(geoSingle.getContent().getLocation().getY());
//			locationDto.setDistance(geoSingle.getDistance().getValue());
//			Driver driver = mapListDriver.get(Integer.parseInt(geoSingle.getContent().getId()));
//			if(driver!=null) {
//				locationDto.setDriver(driver);
//			}
//			listLocation.add(locationDto);
//		}
//		listLocation.sort(Comparator.comparing(LocationDriverDTO::getDistance));
//		return listLocation;
//	}
}
