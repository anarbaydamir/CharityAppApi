package com.itway.charity.controller;

import com.itway.charity.dto.CitiesDto;
import com.itway.charity.dto.ResponseDto;
import com.itway.charity.entity.Cities;
import com.itway.charity.service.inter.CitiesServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CityRestController {

    @Autowired
    private CitiesServiceInter citiesServiceInter;

    @GetMapping("cities")
    public ResponseEntity getAll(){
        try{
            List<Cities> citiesList = citiesServiceInter.getAll();

            List<CitiesDto> citiesDtoList = new ArrayList<>();
            for (int i = 0;i<citiesList.size();i++){
                Cities cities = citiesList.get(i);
                citiesDtoList.add(new CitiesDto(cities));
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("ok",citiesDtoList));
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(404,"error",null));
        }
    }
}
