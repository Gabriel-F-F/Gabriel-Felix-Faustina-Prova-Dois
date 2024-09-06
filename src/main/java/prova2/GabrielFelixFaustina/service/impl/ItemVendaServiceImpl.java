package prova2.GabrielFelixFaustina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova2.GabrielFelixFaustina.dto.ItemVendaDto;
import prova2.GabrielFelixFaustina.dto.VendaDto;
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
		itemVendaRepository.save(new ItemVendaEntity(itemVendaDto, vendaEntity, produtoEntity));
	}
	
	@Override
	public void deleteItemVenda(Long idVenda, Long idItemVenda) {
		VendaEntity vendaEntity = vendaRepository.findVendaById(idVenda);
		validaVendaEmAberto(vendaEntity.getStatus());
		itemVendaRepository.deleteById(idItemVenda);
	}
}