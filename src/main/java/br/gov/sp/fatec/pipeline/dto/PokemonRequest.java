package br.gov.sp.fatec.pipeline.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonRequest {

    @NotNull
    private Integer hp;
    @NotBlank
    private String nome;
    @NotBlank
    private String tipo;
    @NotNull
    private Integer ataque;
    @NotNull
    private Integer defesa;
    @NotNull
    private Integer ataqueEspecial;

}
