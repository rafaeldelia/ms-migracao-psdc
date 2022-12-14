package com.totvs.msmigracaopsdc.api.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(MigracaoId.class)
@Table(name = "SCC_PSDC_INTEGRACAO")
public class Migracao implements Serializable{

	private static final long serialVersionUID = 7654085082009185461L;

	@Id
	@Column(name = "COD_CPF_CNPJ", unique = false, nullable = false)
	private String codCpfCnpj;

	@Id
	@Column(name = "DT_INCLUSAO", unique = false, nullable = false)
	private LocalDate dtInclusao;

	@Id
	@Column(name = "NUM_SEQUENCIAL", unique = false, nullable = false)
	private Long numSequencial;

	@Id
	@Column(name = "TP_ORIGEM", unique = false, nullable = false)
	private String tpOrigem;

	@Id
	@Column(name = "NUM_CONTRATO", unique = false, nullable = false)
	private String numContrato;
    
    /*
	private String stProcessamento;
	private String flEnvioTratamento;
	private String nomCliente;
	private LocalDate dtNascimento;
	private String tpSexo;
	private String tpEstadoCivil;
	private String numRg;
	private String desOrgaoRg;
	private String desUfRg;
	private LocalDate dtEmissaoRg;
	private String desNacionalidade;
	private String nomPai;
	private String nomMae;
	private String dddTel;
	private String numTel;
	private String desEmail;
	private String desCep;
	private String desRua;
	private String desNumero;
	private String desComplemento;
	private String desBairro;
	private String desCidade;
	private String desUf;
	private String desResidDesde;
	private String tpConvenio;
	private String nomEmpresa;
	private String tpOcupacaoEmp;
	private double valSalario;
	private String desEmpDesde;
	private String desCepEmp;
	private String desRuaEmp;
	private String desNumEmp;
	private String desComplEmp;
	private String desBairroEmp;
	private String desCidadeEmp;
	private String desUfEmp;
	private String dddTelEmp;
	private String numTelEmp;
	private String nomReferencia;
	private String dddTelReferencia;
	private String numTelReferencia;
	private String dddCelular;
	private String numCelular;
	private LocalDate dtRetorno;
	private Long idClubPsdc;
	private Long idEndRes;
	private Long idEndCom;
	private Long idEndContato;
	private Long idTelRes;
	private Long idTelCel;
	private Long idEmail;
	private Long codRetornoPsdc;
	private String codErroPsdc;
	private String codMensagemErroPsdc;
	private String flIncCodCpfCnpj;
	private String flIncNomCliente;
	private String flIncDtNascimento;
	private String flIncTpSexo;
	private String flIncTpEstadoCivil;
	private String flIncNumRg;
	private String flIncDesOrgaoRg;
	private String flIncDesUfRg;
	private String flIncDtEmissaoRg;
	private String flIncDesNacionalidade;
	private String flIncNomPai;
	private String flIncNomMae;
	private String flIncDddTel;
	private String flIncNumTel;
	private String flIncDesEmail;
	private String flIncDesCep;
	private String flIncDesRua;
	private String flIncDesNumero;
	private String flIncDesComplemento;
	private String flIncDesBairro;
	private String flIncDesCidade;
	private String flIncDesUf;
	private String flIncDesResidDesde;
	private String flIncTpConvenio;
	private String flIncNomEmpresa;
	private String flIncTpOcupacaoEmp;
	private String flIncValSalario;
	private String flIncDesEmpDesde;
	private String flIncDesCepEmp;
	private String flIncDesRuaEmp;
	private String flIncDesNumEmp;
	private String flIncDesComplEmp;
	private String flIncDesBairroEmp;
	private String flIncDesCidadeEmp;
	private String flIncDesUfEmp;
	private String flIncDddTelEmp;
	private String flIncNumTelEmp;
	private String flIncNomReferencia;
	private String flIncDddTelReferencia;
	private String flIncNumTelReferencia;
	private String flIncDddCelular;
	private String flIncNumCelular;
	private String flAltCodCpfCnpj;
	private String flAltNomCliente;
	private String flAltDtNascimento;
	private String flAltTpSexo;
	private String flAltTpEstadoCivil;
	private String flAltNumRg;
	private String flAltDesOrgaoRg;
	private String flAltDesUfRg;
	private String flAltDtEmissaoRg;
	private String flAltDesNacionalidade;
	private String flAltNomPai;
	private String flAltNomMae;
	private String flAltDddTel;
	private String flAltNumTel;
	private String flAltDesEmail;
	private String flAltDesCep;
	private String flAltDesRua;
	private String flAltDesNumero;
	private String flAltDesComplemento;
	private String flAltDesBairro;
	private String flAltDesCidade;
	private String flAltDesUf;
	private String flAltDesResidDesde;
	private String flAltTpConvenio;
	private String flAltNomEmpresa;
	private String flAltTpOcupacaoEmp;
	private String flAltValSalario;
	private String flAltDesEmpDesde;
	private String flAltDesCepEmp;
	private String flAltDesRuaEmp;
	private String flAltDesNumEmp;
	private String flAltDesComplEmp;
	private String flAltDesBairroEmp;
	private String flAltDesCidadeEmp;
	private String flAltDesUfEmp;
	private String flAltDddTelEmp;
	private String flAltNumTelEmp;
	private String flAltNomReferencia;
	private String flAltDddTelReferencia;
	private String flAltNumTelReferencia;
	private String flAltDddCelular;
	private String flAltNumCelular; */
}