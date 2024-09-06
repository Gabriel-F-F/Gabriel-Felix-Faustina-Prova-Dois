package prova2.GabrielFelixFaustina.repository.impl;

import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import prova2.GabrielFelixFaustina.entity.ProdutoEntity;
import prova2.GabrielFelixFaustina.entity.QItemVendaEntity;
import prova2.GabrielFelixFaustina.entity.QMercadoEntity;
import prova2.GabrielFelixFaustina.entity.QProdutoEntity;
import prova2.GabrielFelixFaustina.repository.ProdutoRepositoryCustom;

public class ProdutoRepositoryImpl implements ProdutoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	final QMercadoEntity mercado = QMercadoEntity.mercadoEntity;
	final QProdutoEntity produto = QProdutoEntity.produtoEntity;
	final QItemVendaEntity itemVenda = QItemVendaEntity.itemVendaEntity;
	
	public ProdutoEntity getProdutoMaisVenda(Long idMercado) {
		var query = new JPAQuery<ProdutoEntity>(em);
		
		query.select(produto.nome)
		.from(mercado)
		.innerJoin(mercado.produtos, produto)
		.innerJoin(produto.itemVendas, itemVenda);
			
		return query.fetchFirst();
	}
}