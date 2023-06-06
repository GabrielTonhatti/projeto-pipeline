package br.gov.sp.fatec.pipeline.controller;

import br.gov.sp.fatec.pipeline.dto.PokemonRequest;
import br.gov.sp.fatec.pipeline.dto.PokemonResponse;
import br.gov.sp.fatec.pipeline.service.PokemonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/pokemons")
public class PokemonController {

    private final PokemonService service;

    @GetMapping
    public Page<PokemonResponse> findAll(Pageable page) {
        return service.findAll(page);
    }

    @GetMapping("{id}")
    public PokemonResponse findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public PokemonResponse save(@Valid @RequestBody PokemonRequest request) {
        return service.save(request);
    }

    @PutMapping("{id}")
    public PokemonResponse update(@PathVariable Integer id, @Valid @RequestBody PokemonRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
