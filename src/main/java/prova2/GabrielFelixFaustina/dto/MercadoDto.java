package prova2.GabrielFelixFaustina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import prova2.GabrielFelixFaustina.entity.MercadoEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MercadoDto {
	private Long id;
	private String nome;
	private String nomeFantasia;
	private String cnpj;
	
	public MercadoDto(MercadoEntity entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.nomeFantasia = entity.getNomeFantasia();
		this.cnpj = entity.getCnpj();
	}
}