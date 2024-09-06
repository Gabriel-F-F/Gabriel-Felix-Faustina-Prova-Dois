package prova2.GabrielFelixFaustina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prova2.GabrielFelixFaustina.entity.VendaEntity;

public interface VendaRepository extends JpaRepository<VendaEntity, Long> { 

	VendaEntity findVendaById(Long idVenda);
	
}