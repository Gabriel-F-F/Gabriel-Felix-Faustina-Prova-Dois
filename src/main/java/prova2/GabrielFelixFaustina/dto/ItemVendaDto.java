package prova2.GabrielFelixFaustina.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import prova2.GabrielFelixFaustina.entity.ItemVendaEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemVendaDto {
	private Long id;
	private Long idVenda;
	private Long idProduto;
	private Integer quantidade;
	private BigDecimal valorTotal;
	
	public ItemVendaDto(ItemVendaEntity entity) {
		this.id = entity.getId();
		this.idVenda = entity.getVenda().getId();
		this.idProduto = entity.getProduto().getId();
		this.quantidade = entity.getQuantidade();
		this.valorTotal = entity.getValorTotal();
	}
}
