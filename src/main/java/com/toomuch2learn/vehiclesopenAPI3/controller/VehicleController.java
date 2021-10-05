package com.toomuch2learn.vehiclesopenAPI3.controller;

import com.toomuch2learn.vehiclesopenAPI3.dao.VehicleRepository;
import com.toomuch2learn.vehiclesopenAPI3.entities.VehicleEntity;
import com.toomuch2learn.vehiclesopenAPI3.handler.VehicleApi;
import com.toomuch2learn.vehiclesopenAPI3.mapper.VehicleMapper;
import com.toomuch2learn.vehiclesopenAPI3.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class VehicleController implements VehicleApi {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public ResponseEntity<List<Vehicle>> getVehicles() {
        List<VehicleEntity>  vehicleEntityList = (List<VehicleEntity>) vehicleRepository.findAll();
        List<Vehicle> vehicleList = vehicleMapper.mapVehicleFromEntity(vehicleEntityList);
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Vehicle> getVehicleById(Integer id){
        Optional<VehicleEntity> vehicleEntity = vehicleRepository.findById(id);
        Vehicle vehicle = vehicleMapper.mapVehicleFromAEntity(vehicleEntity.get());
        //InlineResponse200 inlineResponse200 = new InlineResponse200();
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }
}
