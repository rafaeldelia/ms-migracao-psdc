package com.totvs.msmigracaopsdc.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.totvs.msmigracaopsdc.api.entity.Migracao;

@Repository
public interface MigracaoRepository extends JpaRepository<Migracao, String> {

}
