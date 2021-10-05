package com.toomuch2learn.vehiclesopenAPI3.entities;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Entity
@Table(name = "VEHICLES")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @NonNull
    @Column(name = "TYPE", nullable = false, length = 255)
    private String type;

    @NonNull
    @Column(name = "NAME", unique = true, nullable = false, length = 255)
    private String name;

    @NonNull
    @Column(name = "WHEELS", nullable = false)
    private Integer wheels;

    @Column(name = "SEATS")
    private Integer seats;

    @Column(name = "MUSIC_SYSTEM")
    private Boolean musicSystem;

    @Column(name = "BOOSTER")
    private Boolean Booster;

    @Column(name = "HYDRAULIC_SYSTEM")
    private Boolean hydraulicSystem;
}
