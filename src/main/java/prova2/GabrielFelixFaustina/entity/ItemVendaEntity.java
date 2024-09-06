package prova2.GabrielFelixFaustina.entity;

import java.math.BigDecimal;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import prova2.GabrielFelixFaustina.dto.ItemVendaDto;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "item_venda")
@Getter
public class ItemVendaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "venda_id", nullable = false)
	private VendaEntity venda;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "produto_id", nullable = false)
	private ProdutoEntity produto;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal;
	
	public ItemVendaEntity(ItemVendaDto dto, VendaEntity vendaEntity, ProdutoEntity produtoEntity) {
		this.id = dto.getId();
		this.venda = vendaEntity;
		this.produto = produtoEntity;
		this.quantidade = dto.getQuantidade();
		this.valorTotal = produto.getValorUnitario();
	}
}