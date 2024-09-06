package prova2.GabrielFelixFaustina.service;

import prova2.GabrielFelixFaustina.dto.ProdutoDto;

public interface ProdutoService {

	ProdutoDto getProdutoMaisVenda(Long idRestaurante);
	
	void postProduto(Long idMercado, ProdutoDto produtoDto);
	
	void putEstoqueProduto(Long idProduto, ProdutoDto produtoDto);

	void putValorProduto(Long idProduto, ProdutoDto produtoDto);

}