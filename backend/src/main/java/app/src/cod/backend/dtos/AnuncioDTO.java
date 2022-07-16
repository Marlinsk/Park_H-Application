package app.src.cod.backend.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnuncioDTO {
	
	@NotBlank
	private String tituloAnuncio;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String tipoLogradouro;
	
	@NotBlank
	private String tamanhoLocal;
	
	@NotBlank
	private String tipoVeiculo;
	
	@NotBlank
	private String vagas;
	
	@NotBlank
	private String horarioFuncionamento;
	
	private String[] diasdaSemana;
	
	@NotBlank
	private String portaria;
	
	private String[] recursosVigilancia;
	
	@NotBlank
	@Size(max = 9)
	private String cep;
	
	@NotBlank
	private String estado;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String rua;
	
	@NotBlank
	private String bairro;
	
	@NotBlank
	private String numero;
	
	private String complementoLocal;
	
	@NotBlank
	private String tipoPagamento;
	
	@NotBlank
	private String preco;
	
	@NotBlank
	private String temIPTU;
    
	private String[] canaisPagamento;

}	
