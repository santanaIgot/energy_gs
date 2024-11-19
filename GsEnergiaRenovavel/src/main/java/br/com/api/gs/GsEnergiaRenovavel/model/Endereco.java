package br.com.api.gs.GsEnergiaRenovavel.model;

import br.com.api.gs.GsEnergiaRenovavel.dto.endereco.CadastroEnderecoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_GS_ENDERECO")
@Getter@Setter
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue
    @Column(name = "cd_endereco")
    private long id;
    @Column(name = "end_logradouro")
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(CadastroEnderecoDto dto){
        logradouro = dto.logradouro();
        numero = dto.numero();
        bairro = dto.bairro();
        cidade = dto.cidade();
        estado = dto.estado();
    }
}
