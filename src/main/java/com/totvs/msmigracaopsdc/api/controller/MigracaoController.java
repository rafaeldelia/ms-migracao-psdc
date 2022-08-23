package com.totvs.msmigracaopsdc.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totvs.msmigracaopsdc.api.dto.MigracaoDTO;
import com.totvs.msmigracaopsdc.api.response.MultipleMigracaoResponseMessage;
import com.totvs.msmigracaopsdc.api.service.MigracaoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/migracao")
public class MigracaoController {

	@Autowired
	MigracaoService service;

	@GetMapping("/executarMigracao/{cpf}")
	public MultipleMigracaoResponseMessage executarMigracao(@PathVariable("cpf") String cpf) {
		try {
			List<MigracaoDTO> migracoes = service.executarMigracao(cpf);
			return MultipleMigracaoResponseMessage.builder().status(200).data(migracoes).build();
		} catch (Exception ex) {
			log.error("Erro ao buscar Migrações pendentes!", ex);
			return MultipleMigracaoResponseMessage.builder().error(ex.toString()).message(ex.getMessage()).status(500).build();
		}
	}
}