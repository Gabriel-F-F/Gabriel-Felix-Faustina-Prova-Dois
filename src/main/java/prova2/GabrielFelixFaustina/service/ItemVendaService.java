package prova2.GabrielFelixFaustina.service;

import prova2.GabrielFelixFaustina.dto.ItemVendaDto;

public interface ItemVendaService {

	void postItemVenda(Long idVenda, Long idProduto, ItemVendaDto itemVendaDto);
	
	void deleteItemVenda(Long idVenda, Long idItemVenda);
}