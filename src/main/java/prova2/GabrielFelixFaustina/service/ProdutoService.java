package prova2.GabrielFelixFaustina.service;

import java.util.List;

import prova2.GabrielFelixFaustina.dto.ProdutoDto;

public interface ProdutoService {

	List<ProdutoDto> getProdutoMaisVenda(Long idRestaurante);
	
	List<ProdutoDto> getProduto(String nomeProduto);
	
	void postProduto(Long idMercado, ProdutoDto produtoDto);
	
	void putEstoqueProduto(Long idProduto, ProdutoDto produtoDto);

	void putValorProduto(Long idProduto, ProdutoDto produtoDto);

}