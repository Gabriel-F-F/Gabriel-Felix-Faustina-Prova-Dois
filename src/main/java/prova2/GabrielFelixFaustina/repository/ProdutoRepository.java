package prova2.GabrielFelixFaustina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prova2.GabrielFelixFaustina.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long>, ProdutoRepositoryCustom {

	ProdutoEntity findProdutoById(Long idProduto);
}