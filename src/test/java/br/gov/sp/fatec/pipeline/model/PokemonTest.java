package br.gov.sp.fatec.pipeline.model;

import br.gov.sp.fatec.pipeline.dto.PokemonRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class PokemonTest {

    @Test
    void of_shouldReturnPokemon_whenPokemonIsGiven() {
        var request = onePokemon();

        assertThat(Pokemon.of(request))
                .isNotNull()
                .extracting(Pokemon::getId, Pokemon::getHp, Pokemon::getNome, Pokemon::getTipo, Pokemon::getAtaque,
                        Pokemon::getDefesa, Pokemon::getAtaqueEspecial)
                .containsExactly(null, 100, "Pikachu", "Elétrico", 55, 40, 50);
    }

    private static PokemonRequest onePokemon() {
        return PokemonRequest
                .builder()
                .hp(100)
                .ataque(55)
                .defesa(40)
                .nome("Pikachu")
                .tipo("Elétrico")
                .ataqueEspecial(50)
                .build();
    }
}
