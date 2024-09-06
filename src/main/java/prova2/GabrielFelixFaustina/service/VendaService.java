package prova2.GabrielFelixFaustina.service;

import prova2.GabrielFelixFaustina.dto.VendaDto;

public interface VendaService {

	void postVenda(Long idMercado, VendaDto vendaDto);
	
	void finalizaVenda(Long idVenda, VendaDto dto);
	
	void deleteVenda(Long idVenda);
}