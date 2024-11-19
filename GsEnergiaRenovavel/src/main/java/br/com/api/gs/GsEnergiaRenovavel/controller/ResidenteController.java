package br.com.api.gs.GsEnergiaRenovavel.controller;

import br.com.api.gs.GsEnergiaRenovavel.dto.residente.CadastroResidenteDto;
import br.com.api.gs.GsEnergiaRenovavel.dto.residente.DetalhesResidenteDto;
import br.com.api.gs.GsEnergiaRenovavel.model.Residente;
import br.com.api.gs.GsEnergiaRenovavel.repository.ResidenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("residentes")
public class ResidenteController {

    @Autowired
    private ResidenteRepository residenteRepository;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<DetalhesResidenteDto> cadastrar(@RequestBody CadastroResidenteDto dto,
                                                          UriComponentsBuilder uriBuilder){
        var residente = new Residente(dto);
        residenteRepository.save(residente);
        var uri = uriBuilder.path("/residentes/{id}").buildAndExpand(residente.getId()).toUri();

        return  ResponseEntity.created(uri).body(new DetalhesResidenteDto(residente));
    }


}
