package prova2.GabrielFelixFaustina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import prova2.GabrielFelixFaustina.dto.ItemVendaDto;
import prova2.GabrielFelixFaustina.service.ItemVendaService;
@RestController
@RequestMapping("/mercado/item")
public class ItemVendaController {

	@Autowired
	private ItemVendaService itemVendaService;
	
	@PostMapping("/adicionar/{idProduto}/{idVenda}")
	public void postItemVenda(@PathVariable Long idProduto, @PathVariable Long idVenda, @RequestBody ItemVendaDto itemVendaDto) {
		itemVendaService.postItemVenda(idVenda, idProduto, itemVendaDto);
	}
	
	@DeleteMapping("/deletar/{idVenda}/{idItemVenda}")
	public void deleteItemVenda(@PathVariable Long idVenda, @PathVariable Long idItemVenda) {
		itemVendaService.deleteItemVenda(idVenda, idVenda);
	}
}