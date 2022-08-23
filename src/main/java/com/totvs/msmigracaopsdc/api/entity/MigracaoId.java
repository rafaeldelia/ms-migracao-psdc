package com.totvs.msmigracaopsdc.api.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Identificador da entidade Migracao.
 *
 * @see Migracao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MigracaoId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codCpfCnpj;
	private LocalDate dtInclusao;
	private Long numSequencial;
	private String tpOrigem;
	private String numContrato;
}