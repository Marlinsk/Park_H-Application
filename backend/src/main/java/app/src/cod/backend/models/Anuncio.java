package app.src.cod.backend.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

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
	private String capacidade;
	
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
	
	@Column(nullable = false, unique = false, length = 15)
	private String estado;
	
	@Column(nullable = false, unique = false, length = 20)
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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTituloAnuncio() {
		return tituloAnuncio;
	}

	public void setTituloAnuncio(String tituloAnuncio) {
		this.tituloAnuncio = tituloAnuncio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getTamanhoLocal() {
		return tamanhoLocal;
	}

	public void setTamanhoLocal(String tamanhoLocal) {
		this.tamanhoLocal = tamanhoLocal;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public String[] getDiasdaSemana() {
		return diasdaSemana;
	}

	public void setDiasdaSemana(String[] diasdaSemana) {
		this.diasdaSemana = diasdaSemana;
	}

	public String getPortaria() {
		return portaria;
	}

	public void setPortaria(String portaria) {
		this.portaria = portaria;
	}

	public String[] getRecursosVigilancia() {
		return recursosVigilancia;
	}

	public void setRecursosVigilancia(String[] recursosVigilancia) {
		this.recursosVigilancia = recursosVigilancia;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplementoLocal() {
		return complementoLocal;
	}

	public void setComplementoLocal(String complementoLocal) {
		this.complementoLocal = complementoLocal;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getTemIPTU() {
		return temIPTU;
	}

	public void setTemIPTU(String temIPTU) {
		this.temIPTU = temIPTU;
	}

	public String[] getCanaisPagamento() {
		return canaisPagamento;
	}

	public void setCanaisPagamento(String[] canaisPagamento) {
		this.canaisPagamento = canaisPagamento;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	
}
