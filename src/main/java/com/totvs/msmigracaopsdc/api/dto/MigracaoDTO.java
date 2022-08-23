package com.totvs.msmigracaopsdc.api.dto;

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

	private String codCpfCnpj;
	private LocalDate dtInclusao;
	private Long numSequencial;
	private String tpOrigem;
	private String numContrato;
}