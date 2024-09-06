package prova2.GabrielFelixFaustina.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import prova2.GabrielFelixFaustina.entity.VendaEntity;
import prova2.GabrielFelixFaustina.enuns.StatusVendaEnum;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaDto {
	private Long id;
	private Long idMercado;
	private StatusVendaEnum status;
	private BigDecimal valorTotal;
	private LocalDate dataCriacao;
	
	public VendaDto(VendaEntity entity) {
		this.id = entity.getId();
		this.idMercado = entity.getMercado().getId();
		this.status = entity.getStatus();
		this.valorTotal = entity.getValorTotal();
		this.dataCriacao = entity.getDataCriacao();
	}
}