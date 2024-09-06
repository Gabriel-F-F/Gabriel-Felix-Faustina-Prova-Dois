package prova2.GabrielFelixFaustina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prova2.GabrielFelixFaustina.dto.ItemVendaDto;
import prova2.GabrielFelixFaustina.entity.ItemVendaEntity;
import prova2.GabrielFelixFaustina.entity.ProdutoEntity;
import prova2.GabrielFelixFaustina.entity.VendaEntity;
import prova2.GabrielFelixFaustina.enuns.StatusVendaEnum;
import prova2.GabrielFelixFaustina.repository.ItemVendaRepository;
import prova2.GabrielFelixFaustina.repository.ProdutoRepository;
import prova2.GabrielFelixFaustina.repository.VendaRepository;
import prova2.GabrielFelixFaustina.service.ItemVendaService;

@Service
public class ItemVendaServiceImpl implements ItemVendaService {

	@Autowired
	private ItemVendaRepository itemVendaRepository;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void validaVendaEmAberto(StatusVendaEnum status) {
		if(status.equals(StatusVendaEnum.FINALIZADO)) {
			throw new IllegalArgumentException("A venda já está finalizada!");
		}
	}
	
	@Override
	public void postItemVenda(Long idVenda, Long idProduto, ItemVendaDto itemVendaDto) {
		VendaEntity vendaEntity = vendaRepository.findVendaById(idVenda);
		ProdutoEntity produtoEntity = produtoRepository.findProdutoById(idProduto);
		produtoEntity.descontaEstoque(produtoEntity.getEstoque(), itemVendaDto.getQuantidade());
		if(vendaEntity.getStatus().equals(StatusVendaEnum.EM_ABERTO)) {
		itemVendaRepository.save(new ItemVendaEntity(itemVendaDto, vendaEntity, produtoEntity));
		} else {
			throw new IllegalArgumentException("A venda precisa estar em aberto para acrescentar itens!");
		}
	}
	
	@Override
	public void deleteItemVenda(Long idVenda, Long idProduto, Long idItemVenda) {
		VendaEntity vendaEntity = vendaRepository.findVendaById(idVenda);
		validaVendaEmAberto(vendaEntity.getStatus());
		ProdutoEntity produtoEntity = produtoRepository.findProdutoById(idProduto);
		ItemVendaEntity itemVendaEntity = itemVendaRepository.findItemVendaById(idItemVenda);
		produtoEntity.retornaEstoque(itemVendaEntity.getQuantidade());
		itemVendaRepository.deleteById(idItemVenda);
	}
}