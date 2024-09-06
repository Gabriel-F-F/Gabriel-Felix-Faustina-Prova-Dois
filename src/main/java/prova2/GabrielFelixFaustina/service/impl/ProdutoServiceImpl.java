package prova2.GabrielFelixFaustina.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova2.GabrielFelixFaustina.dto.ProdutoDto;
import prova2.GabrielFelixFaustina.entity.MercadoEntity;
import prova2.GabrielFelixFaustina.entity.ProdutoEntity;
import prova2.GabrielFelixFaustina.repository.MercadoRepository;
import prova2.GabrielFelixFaustina.repository.ProdutoRepository;
import prova2.GabrielFelixFaustina.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private MercadoRepository mercadoRepository;
	
	@Override
	public void postProduto(Long idMercado, ProdutoDto produtoDto) {
		MercadoEntity mercadoEncontrado = mercadoRepository.findMercadoById(idMercado);
		produtoRepository.save(new ProdutoEntity(produtoDto, mercadoEncontrado));
	}
	
	@Override
	public void putEstoqueProduto(Long idProduto, ProdutoDto produtoDto) {
		Optional<ProdutoEntity> produtoEncontrado = produtoRepository.findById(idProduto);
		if(produtoEncontrado.isPresent()) {
			ProdutoEntity produtoEntity = produtoEncontrado.get();
			produtoEntity.putEstoqueProduto(produtoDto);
			produtoRepository.save(produtoEntity);
		}
	}
	
	@Override
	public void putValorProduto(Long idProduto, ProdutoDto produtoDto) {
		Optional<ProdutoEntity> produtoEncontrado = produtoRepository.findById(idProduto);
		if(produtoEncontrado.isPresent()) {
			ProdutoEntity produtoEntity = produtoEncontrado.get();
			produtoEntity.putValorProduto(produtoDto);
			produtoRepository.save(produtoEntity);
		}
	}
}