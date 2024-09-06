package prova2.GabrielFelixFaustina.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import prova2.GabrielFelixFaustina.entity.ProdutoEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDto {
	private Long id;
	private Long idMercado;
	private String nome;
	private Integer estoque;
	private BigDecimal valorUnitario;
	
	public ProdutoDto(ProdutoEntity entity) {
		this.id = entity.getId();
		this.idMercado = entity.getMercado().getId();
		this.nome = entity.getNome();
		this.estoque = entity.getEstoque();
		this.valorUnitario = entity.getValorUnitario();
	}
}