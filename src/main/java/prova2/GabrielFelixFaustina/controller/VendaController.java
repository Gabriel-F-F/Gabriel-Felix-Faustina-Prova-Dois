package prova2.GabrielFelixFaustina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prova2.GabrielFelixFaustina.dto.VendaDto;
import prova2.GabrielFelixFaustina.service.VendaService;

@RestController
@RequestMapping("/mercado/venda")
public class VendaController {

	@Autowired
	private VendaService vendaService;
	
	@PostMapping("/adicionar/{idMercado}")
	public void postVenda(@PathVariable Long idMercado, @RequestBody VendaDto produtoDto) {
		vendaService.postVenda(idMercado, produtoDto);
	}
	
	@DeleteMapping("/deletar/{idVenda}")
	public void deleteVenda(@PathVariable Long idVenda) {
		vendaService.deleteVenda(idVenda);
	}
}