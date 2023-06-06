package br.gov.sp.fatec.pipeline.dto;

import br.gov.sp.fatec.pipeline.model.Pokemon;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonResponse {

    private Integer id;
    private Integer hp;
    private String nome;
    private String tipo;
    private Integer ataque;
    private Integer defesa;
    private Integer ataqueEspecial;

    public static PokemonResponse of(Pokemon pokemon) {
        return PokemonResponse.builder()
                .id(pokemon.getId())
                .hp(pokemon.getHp())
                .nome(pokemon.getNome())
                .tipo(pokemon.getTipo())
                .ataque(pokemon.getAtaque())
                .defesa(pokemon.getDefesa())
                .ataqueEspecial(pokemon.getAtaqueEspecial())
                .build();
    }
}
