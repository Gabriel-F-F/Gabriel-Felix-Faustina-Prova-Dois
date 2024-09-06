package prova2.GabrielFelixFaustina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prova2.GabrielFelixFaustina.entity.MercadoEntity;

public interface MercadoRepository extends JpaRepository<MercadoEntity, Long> {

	MercadoEntity findMercadoById(Long idMercado);
}