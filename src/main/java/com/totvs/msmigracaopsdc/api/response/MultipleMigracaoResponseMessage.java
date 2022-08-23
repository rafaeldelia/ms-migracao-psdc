package com.totvs.msmigracaopsdc.api.response;

import java.util.List;

import com.totvs.msmigracaopsdc.api.dto.MigracaoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MultipleMigracaoResponseMessage extends ResponseMessage {
	private List<MigracaoDTO> data;

	@Builder
	public MultipleMigracaoResponseMessage(int status, String error, String message, List<MigracaoDTO> data) {
		super(status, error, message);
		this.data = data;
	}
}
