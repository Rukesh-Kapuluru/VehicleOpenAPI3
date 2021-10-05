package com.toomuch2learn.vehiclesopenAPI3.dao;

import com.toomuch2learn.vehiclesopenAPI3.entities.VehicleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<VehicleEntity, Integer> {

}
