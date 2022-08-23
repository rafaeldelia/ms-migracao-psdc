package com.totvs.msmigracaopsdc.api.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totvs.msmigracaopsdc.api.domain.dto.MigracaoDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/migracao")
public class MigracaoController {

	@GetMapping("/executarMigracao/{cpf}")
	public MigracaoDTO executarMigracao(@PathVariable("cpf") String cpf) {
		log.info("CPF [ " + cpf + "]");
		MigracaoDTO migracao = new MigracaoDTO();
		migracao.setCpf(cpf);
		migracao.setDtNascimento(LocalDate.now());
		migracao.setNome("Rafael D'Elia");
		return migracao;
	}
}