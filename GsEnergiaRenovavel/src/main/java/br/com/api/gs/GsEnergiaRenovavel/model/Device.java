package br.com.api.gs.GsEnergiaRenovavel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_GS_DEVICE")
@Entity

public class Device {
    @Id
    @GeneratedValue
    private long id;

    private String name;

}
