package br.gov.sp.fatec.pipeline.service;

import br.gov.sp.fatec.pipeline.dto.PokemonRequest;
import br.gov.sp.fatec.pipeline.dto.PokemonResponse;
import br.gov.sp.fatec.pipeline.model.Pokemon;
import br.gov.sp.fatec.pipeline.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonRepository repository;

    public Page<PokemonResponse> findAll(Pageable page) {
        return repository.findAll(page)
                .map(PokemonResponse::of);
    }

    public PokemonResponse findById(Integer id) {
        return PokemonResponse.of(getById(id));
    }

    public PokemonResponse save(PokemonRequest request) {
        var pokemon = Pokemon.of(request);

        repository.save(pokemon);

        return PokemonResponse.of(pokemon);
    }

    public PokemonResponse update(Integer id, PokemonRequest request) {
        var pokemon = getById(id);

        BeanUtils.copyProperties(request, pokemon);

        repository.save(pokemon);

        return PokemonResponse.of(pokemon);
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            throw new RuntimeException("Não foi possível deletar o pokemon");
        }
    }

    private Pokemon getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon não encontrado"));
    }
}
