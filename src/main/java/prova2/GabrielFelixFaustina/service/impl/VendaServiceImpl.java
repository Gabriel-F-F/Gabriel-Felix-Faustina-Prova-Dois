package prova2.GabrielFelixFaustina.service.impl;

import java.util.Optional;
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
	public void finalizaVenda(Long idVenda, VendaDto vendaDto) {
		Optional<VendaEntity> vendaEncontrada = vendaRepository.findById(idVenda);
		if (vendaEncontrada.isPresent()) {
			VendaEntity vendaEntity = vendaEncontrada.get();
			vendaEntity.finalizaVenda(vendaDto);
			vendaRepository.save(vendaEntity);
		}
	}

	@Override
	public void deleteVenda(Long idVenda) {
		vendaRepository.deleteById(idVenda);
	}
}
