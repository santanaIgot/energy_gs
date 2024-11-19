package br.com.api.gs.GsEnergiaRenovavel.dto.residente;

import br.com.api.gs.GsEnergiaRenovavel.model.Endereco;

public record CadastroResidenteDto(String nome, String email, Endereco endereco) {
}
