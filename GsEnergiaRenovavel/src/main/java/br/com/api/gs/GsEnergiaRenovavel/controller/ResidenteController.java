package br.com.api.gs.GsEnergiaRenovavel.controller;

import br.com.api.gs.GsEnergiaRenovavel.dto.residente.AtualizacaoResidenteDto;
import br.com.api.gs.GsEnergiaRenovavel.dto.residente.CadastroResidenteDto;
import br.com.api.gs.GsEnergiaRenovavel.dto.residente.DetalhesResidenteDto;
import br.com.api.gs.GsEnergiaRenovavel.dto.residente.ListagemResidenteDto;
import br.com.api.gs.GsEnergiaRenovavel.model.Residente;
import br.com.api.gs.GsEnergiaRenovavel.repository.ResidenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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


    @GetMapping("/listar")
    public ResponseEntity<List<ListagemResidenteDto>> listar(){
        var lista = residenteRepository.findAll().stream().map(ListagemResidenteDto::new).toList();
        return ResponseEntity.ok(lista);
    }

    //paginacao

    @GetMapping("/paginacao")
    public ResponseEntity<Page<ListagemResidenteDto>> listar(Pageable paginacao){
        var page = residenteRepository.findAll(paginacao).map(ListagemResidenteDto::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesResidenteDto> atualizar(@PathVariable("id") Long id,
                                                          @RequestBody AtualizacaoResidenteDto dto){
        var residente = residenteRepository.getReferenceById(id);
        residente.atualizarInformacoes(dto);

        return ResponseEntity.ok(new DetalhesResidenteDto(residente));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable("id") Long id){
        residenteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
