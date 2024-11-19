package br.com.api.gs.GsEnergiaRenovavel.model;

import br.com.api.gs.GsEnergiaRenovavel.dto.residente.AtualizacaoResidenteDto;
import br.com.api.gs.GsEnergiaRenovavel.dto.residente.CadastroResidenteDto;
import jakarta.persistence.*;
import br.com.api.gs.GsEnergiaRenovavel.model.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_GS_RESIDENTE")
@Getter@Setter
@NoArgsConstructor
public class Residente {
    @GeneratedValue
    @Id
    private Long id;

    private String nome;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Residente(CadastroResidenteDto dto){
        nome = dto.nome();
        email = dto.email();
        endereco = dto.endereco();
    }

    public void atualizarInformacoes(AtualizacaoResidenteDto dto) {
        if(dto.nome() != null)
            nome = dto.nome();
        if (dto.email() != null)
            email = dto.email();
        if(dto.endereco() != null)
            endereco = dto.endereco();
    }
}
