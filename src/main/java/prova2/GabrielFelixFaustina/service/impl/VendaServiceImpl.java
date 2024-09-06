package prova2.GabrielFelixFaustina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova2.GabrielFelixFaustina.dto.VendaDto;
import prova2.GabrielFelixFaustina.entity.MercadoEntity;
import prova2.GabrielFelixFaustina.entity.VendaEntity;
import prova2.GabrielFelixFaustina.repository.MercadoRepository;
import prova2.GabrielFelixFaustina.repository.VendaRepository;
import prova2.GabrielFelixFaustina.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private MercadoRepository mercadoRepository;
	
	@Override
	public void postVenda(Long idMercado, VendaDto vendaDto) {
		MercadoEntity mercadoEncontrado = mercadoRepository.findMercadoById(idMercado);
		vendaRepository.save(new VendaEntity(vendaDto, mercadoEncontrado));
	}
	
	@Override
	public void deleteVenda(Long idVenda) {
		vendaRepository.deleteById(idVenda);
	}
}
