package prova2.GabrielFelixFaustina.entity;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import prova2.GabrielFelixFaustina.dto.ProdutoDto;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "produto")
@Getter
public class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "mercado_id", nullable = false)
	private MercadoEntity mercado;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "estoque", nullable = false)
	private Integer estoque;
	
	@Column(name = "valor_unitario", nullable = false)
	private BigDecimal valorUnitario;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<ItemVendaEntity> itemVendas;
	
	public ProdutoEntity(ProdutoDto dto, MercadoEntity mercadoEntity) {
		this.id = dto.getId();
		this.mercado = mercadoEntity;
		this.nome = dto.getNome();
		this.estoque = dto.getEstoque();
		this.valorUnitario = dto.getValorUnitario();
	}
	
	public ProdutoEntity putEstoqueProduto(ProdutoDto produtoDto) {
		this.estoque = produtoDto.getEstoque();
		return this;
	}
	
	public ProdutoEntity putValorProduto(ProdutoDto produtoDto) {
		this.valorUnitario = produtoDto.getValorUnitario();
		return this;
	}
}