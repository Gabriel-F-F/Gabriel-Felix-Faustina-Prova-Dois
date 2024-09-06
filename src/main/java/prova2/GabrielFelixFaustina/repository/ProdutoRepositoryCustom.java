package prova2.GabrielFelixFaustina.repository;

import java.util.List;

import prova2.GabrielFelixFaustina.entity.ProdutoEntity;

public interface ProdutoRepositoryCustom {

	List<ProdutoEntity> getProdutoMaisVenda(Long idMercado);
	
	List<ProdutoEntity> getProduto(String nomeProduto);
}