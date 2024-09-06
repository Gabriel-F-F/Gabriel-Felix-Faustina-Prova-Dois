package prova2.GabrielFelixFaustina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prova2.GabrielFelixFaustina.entity.ItemVendaEntity;

public interface ItemVendaRepository extends JpaRepository<ItemVendaEntity, Long> {

	ItemVendaEntity findItemVendaById(Long idItemVenda);
}