package com.totvs.msmigracaopsdc.api.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.totvs.msmigracaopsdc.api.dto.MigracaoDTO;
import com.totvs.msmigracaopsdc.api.service.MigracaoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class MigracaoEngine {

	@Autowired
	private final MigracaoService service;

	@Scheduled(cron = "0 0/1 * 1/1 * *", zone = "America/Sao_Paulo")
	@Async
	public void findAll() {
		List<MigracaoDTO> todas = service.executarMigracao();
		for (MigracaoDTO migracao : todas) {
			log.info("----------------------------------------------------------------");
			log.info("MIGRAÇÃO SCHEDULING......");
			log.info("MIGRAÇÃO SCHEDULING.. CPF[" + migracao.getCodCpfCnpj() + "]");
			log.info("MIGRAÇÃO SCHEDULING.. DATA[" + migracao.getDtInclusao() + "]");
			log.info("MIGRAÇÃO SCHEDULING.. CONTRATO[" + migracao.getNumContrato() + "]");
			log.info("MIGRAÇÃO SCHEDULING.. SEQUENCIA[" + migracao.getNumSequencial() + "]");
			log.info("MIGRAÇÃO SCHEDULING.. ORIGEM[" + migracao.getTpOrigem() + "]");
		}
	}
}