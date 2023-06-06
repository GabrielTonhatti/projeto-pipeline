package br.gov.sp.fatec.pipeline.dto;

import br.gov.sp.fatec.pipeline.model.Pokemon;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PokemonResponseTest {

    @Test
    void of_shouldReturnPokemonResponse_whenPokemonIsGiven() {
        var pokemon = onePokemon();

        assertThat(PokemonResponse.of(pokemon))
                .isNotNull()
                .extracting(PokemonResponse::getId, PokemonResponse::getHp, PokemonResponse::getNome,
                        PokemonResponse::getTipo, PokemonResponse::getAtaque, PokemonResponse::getDefesa,
                        PokemonResponse::getAtaqueEspecial)
                .containsExactly(1, 100, "Pikachu", "Elétrico", 55, 40, 50);
    }

    private static Pokemon onePokemon() {
        return Pokemon
                .builder()
                .id(1)
                .hp(100)
                .ataque(55)
                .defesa(40)
                .nome("Pikachu")
                .tipo("Elétrico")
                .ataqueEspecial(50)
                .build();
    }
}
