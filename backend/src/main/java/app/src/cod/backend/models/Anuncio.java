package app.src.cod.backend.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name ="TB_ANUNCIO")
public class Anuncio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false, unique = false, length = 70)
	private String tituloAnuncio;
	
	@Column(nullable = false, unique = false, length = 1000)
	private String descricao;
	
	@Column(nullable = false, unique = false, length = 50)
	private String tipoLogradouro;
	
	@Column(nullable = false, unique = false, length = 30)
	private String tamanhoLocal;
	
	@Column(nullable = false, unique = false, length = 20)
	private String tipoVeiculo;
	
	@Column(nullable = false, unique = false, length = 20)
	private String vagas;
	
	@Column(nullable = false, unique = false, length = 30)
	private String horarioFuncionamento;
	
	@Column(nullable = false, unique = false, length = 80)
	private String[] diasdaSemana;
	
	@Column(nullable = false, unique = false, length = 50)
	private String portaria;
	
	@Column(nullable = false, unique = false, length = 80)
	private String[] recursosVigilancia;
	
	@Column(nullable = false, unique = false, length = 9)
	private String cep;
	
	@Column(nullable = false, unique = false, length = 30)
	private String estado;
	
	@Column(nullable = false, unique = false, length = 30)
	private String cidade;
	
	@Column(nullable = false, unique = false, length = 70)
	private String rua;
	
	@Column(nullable = false, unique = false, length = 20)
	private String bairro;
	
	@Column(nullable = false, unique = false, length = 10)
	private String numero;
	
	@Column(nullable = true, unique = false, length = 30)
	private String complementoLocal;
	
	@Column(nullable = false, unique = false, length = 20)
	private String tipoPagamento;
	
	@Column(nullable = false, unique = false, length = 30)
	private String preco;
	
	@Column(nullable = false, unique = false, length = 15)
	private String temIPTU;
	
	@Column(nullable = false, unique = false, length = 80)
    private String[] canaisPagamento;
	
    @Column(nullable = false)
    private LocalDateTime registrationDate;

}
