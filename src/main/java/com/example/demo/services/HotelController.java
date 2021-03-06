package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Hotel;

@RestController
@RequestMapping(path = "/api/v1")
public class HotelController {

	
	private HotelService service;
	
	@Value("${server.port}")
	String portNumber;

	public HotelController(HotelService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping(path = "/hotels")
	public List<Hotel> getAllHotels(){
		return this.service.getHotels();
	}
	
	
	@GetMapping(path = "/hotels/{id}")
	public Hotel getHotelById(@PathVariable int id){
		Hotel hotel =  this.service.getHotelById(id);
		hotel.setId(Integer.parseInt(portNumber));
		return hotel;
	}
	
}