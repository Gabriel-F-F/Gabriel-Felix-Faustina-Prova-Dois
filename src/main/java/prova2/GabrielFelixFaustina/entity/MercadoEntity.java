package prova2.GabrielFelixFaustina.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import prova2.GabrielFelixFaustina.dto.MercadoDto;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "mercado")
@Getter
public class MercadoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "nome_fantasia", nullable = false)
	private String nomeFantasia;
	
	@Column(name = "cnpj", nullable =  false, unique = true)
	private String cnpj;
	
	@OneToMany(mappedBy = "mercado", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<ProdutoEntity> produtos;
	
	@OneToMany(mappedBy = "mercado", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<VendaEntity> vendas;
	
	public MercadoEntity(MercadoDto dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.nomeFantasia = dto.getNomeFantasia();
		this.cnpj = dto.getCnpj();
	}
}