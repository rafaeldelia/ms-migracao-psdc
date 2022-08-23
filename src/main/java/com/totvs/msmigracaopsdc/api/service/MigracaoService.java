package com.totvs.msmigracaopsdc.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totvs.msmigracaopsdc.api.converter.MigracaoConverter;
import com.totvs.msmigracaopsdc.api.dto.MigracaoDTO;
import com.totvs.msmigracaopsdc.api.repository.MigracaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MigracaoService {

	@Autowired
	private final MigracaoRepository migracaoRepository;

	private final MigracaoConverter migracaoConverter;

	public List<MigracaoDTO> executarMigracao() {
		return migracaoRepository.findAll().stream().map(migracaoConverter::toDTO).collect(Collectors.toList());
	}
}