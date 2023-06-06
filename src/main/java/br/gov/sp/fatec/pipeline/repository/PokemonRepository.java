package br.gov.sp.fatec.pipeline.repository;

import br.gov.sp.fatec.pipeline.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
