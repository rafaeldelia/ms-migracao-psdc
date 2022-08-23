package com.totvs.msmigracaopsdc.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totvs.msmigracaopsdc.api.converter.MigracaoConverter;
import com.totvs.msmigracaopsdc.api.dto.MigracaoDTO;
import com.totvs.msmigracaopsdc.api.entity.Migracao;
import com.totvs.msmigracaopsdc.api.repository.MigracaoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MigracaoService {

	@Autowired
	private final MigracaoRepository migracaoRepository;

	private final MigracaoConverter migracaoConverter;

	public List<MigracaoDTO> executarMigracao(String cpf) {
		log.info("CPF [ " + cpf + "]");
		List<Migracao> migracoes = migracaoRepository.findAll();
		for (Migracao migracao : migracoes) {
			log.info("MIGRACAO -> [" + migracao.getCodCpfCnpj() + "]");
			log.info("MIGRACAO -> [" + migracao.getNumContrato() + "]");
		}
		return migracoes.stream().map(migracaoConverter::toDTO).collect(Collectors.toList());
	}
}