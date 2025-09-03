package br.com.santacasa.api_gateway.repository;

import br.com.santacasa.api_gateway.entities.Funcao;
import br.com.santacasa.api_gateway.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, Long> {

}
