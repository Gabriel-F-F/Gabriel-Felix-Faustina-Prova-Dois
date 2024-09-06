package prova2.GabrielFelixFaustina.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import prova2.GabrielFelixFaustina.dto.VendaDto;
import prova2.GabrielFelixFaustina.enuns.StatusVendaEnum;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "venda")
@Getter
public class VendaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "mercado_id", nullable = false)
	private MercadoEntity mercado;
	
	@Column(name = "status", nullable = false)
	private StatusVendaEnum status;
	
	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal;
	
	@Column(name = "data_criacao", nullable = false)
	private LocalDate dataCriacao;
	
	@OneToMany(mappedBy = "venda", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<ItemVendaEntity> itemVendas;
	
	public VendaEntity(VendaDto dto, MercadoEntity mercadoEntity) {
		this.id = dto.getId();
		this.mercado = mercadoEntity;
		this.status = StatusVendaEnum.EM_ABERTO;
		this.valorTotal = BigDecimal.ZERO;
		this.dataCriacao = dto.getDataCriacao();
	}
	
	public VendaEntity finalizaVenda(VendaDto dto) {
		this.status = dto.getStatus();
		return this;
	}
}