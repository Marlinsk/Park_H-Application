package app.src.cod.backend.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	private String capacidade;
	
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
}	
