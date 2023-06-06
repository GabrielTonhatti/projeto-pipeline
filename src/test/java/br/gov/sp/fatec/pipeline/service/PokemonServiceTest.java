package br.gov.sp.fatec.pipeline.service;

import br.gov.sp.fatec.pipeline.dto.PokemonResponse;
import br.gov.sp.fatec.pipeline.model.Pokemon;
import br.gov.sp.fatec.pipeline.repository.PokemonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    @InjectMocks
    private PokemonService service;
    @Mock
    private PokemonRepository repository;

    @Test
    void findById_shouldReturnAllPokemons_whenPokemonsAreGiven() {
        doReturn(Optional.of(Pokemon
                        .builder()
                        .id(1)
                        .hp(100)
                        .ataque(55)
                        .defesa(40)
                        .nome("Pikachu")
                        .tipo("Elétrico")
                        .ataqueEspecial(50)
                        .build()
                )
        )
                .when(repository)
                .findById(1);

        Assertions.assertThat(service.findById(1))
                .extracting(PokemonResponse::getId, PokemonResponse::getHp, PokemonResponse::getNome, PokemonResponse::getTipo,
                        PokemonResponse::getAtaque, PokemonResponse::getDefesa, PokemonResponse::getAtaqueEspecial)
                .containsExactly(1, 100, "Pikachu", "Elétrico", 55, 40, 50);
    }
}
