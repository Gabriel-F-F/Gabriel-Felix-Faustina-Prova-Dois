package prova2.GabrielFelixFaustina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prova2.GabrielFelixFaustina.dto.MercadoDto;
import prova2.GabrielFelixFaustina.entity.MercadoEntity;
import prova2.GabrielFelixFaustina.repository.MercadoRepository;
import prova2.GabrielFelixFaustina.service.MercadoService;

@Service
public class MercadoServiceImpl implements MercadoService {

	@Autowired
	private MercadoRepository mercadoRepository;
	
	@Override
	public void postMercado(MercadoDto mercadoDto) {
		mercadoRepository.save(new MercadoEntity(mercadoDto));
	}
}
