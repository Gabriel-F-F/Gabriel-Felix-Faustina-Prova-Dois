package prova2.GabrielFelixFaustina.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prova2.GabrielFelixFaustina.dto.ProdutoDto;
import prova2.GabrielFelixFaustina.service.ProdutoService;

@RestController
@RequestMapping("/mercado/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/maior-vendas/{idRestaurante}")
	public List<ProdutoDto> getProdutoMaisVenda(@PathVariable Long idRestaurante) {
		return produtoService.getProdutoMaisVenda(idRestaurante);
	}
	
	@GetMapping("/buscar/{nomeProduto}")
	public List<ProdutoDto> getProduto(@PathVariable String nomeProduto) {
		return produtoService.getProduto(nomeProduto);
	}
	
	@PostMapping("/adicionar/{idMercado}")
	public void postProduto(@PathVariable Long idMercado, @RequestBody ProdutoDto produtoDto) {
		produtoService.postProduto(idMercado, produtoDto);
	}
	
	@PutMapping("/atualizar-estoque/{idProduto}")
	public void putEstoqueProduto(@PathVariable Long idProduto, @RequestBody ProdutoDto produtoDto) {
		produtoService.putEstoqueProduto(idProduto, produtoDto);
	}
	
	@PutMapping("/atualizar-valor/{idProduto}")
	public void putValorProduto(@PathVariable Long idProduto, @RequestBody ProdutoDto produtoDto) {
		produtoService.putValorProduto(idProduto, produtoDto);
	}
}