package com.totvs.msmigracaopsdc.api.domain.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MigracaoDTO {

	private String cpf;
	private String nome;
	private LocalDate dtNascimento;
}