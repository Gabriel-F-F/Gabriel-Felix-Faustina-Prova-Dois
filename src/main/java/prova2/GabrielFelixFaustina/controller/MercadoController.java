package prova2.GabrielFelixFaustina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prova2.GabrielFelixFaustina.dto.MercadoDto;
import prova2.GabrielFelixFaustina.service.MercadoService;

@RestController
@RequestMapping("/mercado")
public class MercadoController {

	@Autowired
	private MercadoService mercadoService;
	
	@PostMapping("/adicionar")
	public void postMercado(@RequestBody MercadoDto mercadoDto) {
		mercadoService.postMercado(mercadoDto);
	}
}