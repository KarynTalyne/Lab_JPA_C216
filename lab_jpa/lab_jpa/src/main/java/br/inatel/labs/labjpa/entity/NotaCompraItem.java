package br.inatel.labs.labjpa.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class NotaCompraItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private BigDecimal valorCompraProduto;
	
	@NotNull
	private Integer quantidade;
	
	@Override
	public String toString() {
		return "NotaCompraItem [valorCompraProduto=" + valorCompraProduto + ", quantidade=" + quantidade + ", produto="
				+ produto + "]";
	}


	@NotNull
	@ManyToOne
	private NotaCompra notaCompra;
	
	@NotNull
	@ManyToOne
	private Produto produto;
	
    public NotaCompraItem() {}
	
	public NotaCompraItem(NotaCompra notaCompra, Produto produto, BigDecimal valorCompraProduto, Integer quantidade) {
		this.valorCompraProduto = valorCompraProduto;
		this.quantidade = quantidade;
		this.notaCompra = notaCompra;
		this.produto = produto;
	}

    
	public BigDecimal getCalculoTotalItem() {
		return valorCompraProduto.multiply(BigDecimal.valueOf(quantidade));
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public BigDecimal getValorCompraProduto() {
		return valorCompraProduto;
	}


	public void setValorCompraProduto(BigDecimal valorCompraProduto) {
		this.valorCompraProduto = valorCompraProduto;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public NotaCompra getNotaCompra() {
		return notaCompra;
	}


	public void setNotaCompra(NotaCompra notaCompra) {
		this.notaCompra = notaCompra;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaCompraItem other = (NotaCompraItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
