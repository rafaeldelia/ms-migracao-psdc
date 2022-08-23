package com.totvs.msmigracaopsdc.api.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.totvs.msmigracaopsdc.api.dto.MigracaoDTO;
import com.totvs.msmigracaopsdc.api.entity.Migracao;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MigracaoConverter {
	private final ModelMapper modelMapper;

	public Migracao toEntity(MigracaoDTO dto) {
		return modelMapper.map(dto, Migracao.class);
	}

	public MigracaoDTO toDTO(Migracao entity) {
		return modelMapper.map(entity, MigracaoDTO.class);
	}
}