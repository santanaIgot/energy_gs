package br.com.api.gs.GsEnergiaRenovavel.dto.residente;

import br.com.api.gs.GsEnergiaRenovavel.model.Residente;

public record DetalhesResidenteDto(long id, String nome, String email) {
    public DetalhesResidenteDto(Residente residente){
        this(residente.getId(), residente.getNome(), residente.getEmail());
    }
}
