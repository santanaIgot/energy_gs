package br.com.api.gs.GsEnergiaRenovavel.dto.residente;

import br.com.api.gs.GsEnergiaRenovavel.model.Endereco;
import br.com.api.gs.GsEnergiaRenovavel.model.Residente;

public record ListagemResidenteDto(Long id, String nome, String email, Endereco endereco) {

    public ListagemResidenteDto(Residente residente){
        this(residente.getId(), residente.getNome(), residente.getEmail(), residente.getEndereco());
    }


}
