package com.toomuch2learn.vehiclesopenAPI3.mapper;

import com.toomuch2learn.vehiclesopenAPI3.entities.VehicleEntity;
import com.toomuch2learn.vehiclesopenAPI3.model.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleMapper {

    public List<Vehicle> mapVehicleFromEntity(List<VehicleEntity> vehicleEntityList) {

        List<Vehicle> vehicleList = null;
        if(!CollectionUtils.isEmpty(vehicleEntityList)){
            vehicleList = vehicleEntityList.stream()
                    .map(vehicleEntity -> {
                        Vehicle vehicle = new Vehicle();
                        vehicle.setId(vehicleEntity.getId());
                        vehicle.setName(vehicleEntity.getName());
                        vehicle.setType(vehicleEntity.getType());
                        return vehicle;
                    }).collect(Collectors.toList());
        }
        return vehicleList;
    }

    public Vehicle mapVehicleFromAEntity(VehicleEntity vehicleEntity) {

        if(vehicleEntity != null){
            if(vehicleEntity.getType().equalsIgnoreCase("NC")){
                NormalCar vehicle = new NormalCar();
                 VehicleUtil( vehicle, vehicleEntity);
                if(vehicleEntity.getSeats() != null){
                    vehicle.setSeats(vehicleEntity.getSeats());
                }
                if(vehicleEntity.getMusicSystem() != null){
                    vehicle.setHasMusicSystem(vehicleEntity.getMusicSystem());
                }
                return vehicle;
            }
            if(vehicleEntity.getType().equalsIgnoreCase("SC")) {
                SuperCar vehicle = new SuperCar();
                VehicleUtil( vehicle, vehicleEntity);
                if(vehicleEntity.getSeats() != null){
                    vehicle.setSeats(vehicleEntity.getSeats());
                }
                if(vehicleEntity.getBooster() != null){
                    vehicle.setHasBooster(vehicleEntity.getBooster());
                }
                return vehicle;
            }
            if(vehicleEntity.getType().equalsIgnoreCase("TT")) {
                TransportTruck vehicle = new TransportTruck();
                VehicleUtil( vehicle, vehicleEntity);
                if(vehicleEntity.getMusicSystem() != null){
                    vehicle.setHasMusicSystem(vehicleEntity.getMusicSystem());
                }
                return vehicle;
            }
            if(vehicleEntity.getType().equalsIgnoreCase("MT")) {
                MiningTruck vehicle = new MiningTruck();
                VehicleUtil( vehicle, vehicleEntity);
                if(vehicleEntity.getHydraulicSystem() != null){
                    vehicle.setHasHydraulicSystem(vehicleEntity.getHydraulicSystem()
                    );
                }
                return vehicle;
            }

        }
        return null;
    }

    private void VehicleUtil(Vehicle vehicle, VehicleEntity vehicleEntity){
        vehicle.setId(vehicleEntity.getId());
        vehicle.setName(vehicleEntity.getName());
        vehicle.setType(vehicleEntity.getType());
    }
}
