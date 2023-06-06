package br.gov.sp.fatec.pipeline.model;

import br.gov.sp.fatec.pipeline.dto.PokemonRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "POKEMON")
public class Pokemon {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SEQ_POKEMON", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_POKEMON", sequenceName = "SEQ_POKEMON", allocationSize = 1)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "ATAQUE")
    private Integer ataque;

    @Column(name = "DEFESA")
    private Integer defesa;

    @Column(name = "HP")
    private Integer hp;

    @Column(name = "ATAQUE_ESPECIAL")
    private Integer ataqueEspecial;

    @Column(name = "DATA_CADASTRO")
    private LocalDateTime dataCadastro;

    public static Pokemon of(PokemonRequest request) {
        return Pokemon
                .builder()
                .hp(request.getHp())
                .nome(request.getNome())
                .tipo(request.getTipo())
                .ataque(request.getAtaque())
                .defesa(request.getDefesa())
                .dataCadastro(LocalDateTime.now())
                .ataqueEspecial(request.getAtaqueEspecial())
                .build();
    }
}
