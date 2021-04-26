package com.henriquedemetrio.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henriquedemetrio.cursomc.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
