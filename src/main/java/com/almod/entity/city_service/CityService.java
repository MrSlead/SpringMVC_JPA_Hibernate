package com.almod.entity.city_service;

import com.almod.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public void save(City city){
        cityRepository.save(city);
    }

    public void delete(City city){
        cityRepository.delete(city);
    }

    public List<City> findAll(){
        return (List<City>) cityRepository.findAll();
    }

    public City getId(int id){
        return cityRepository.findById(id).get();
    }
}
