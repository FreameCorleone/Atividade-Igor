package br.edu.ifba.basicas;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Veiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String modelo;
    private String montadora;
    
    
    
    public Veiculo() {
		super();
	}

	public Veiculo(int id, String modelo, String montadora, Cliente cliente) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.montadora = montadora;
		this.cliente = cliente;
	}

	@ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMontadora() {
		return montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", modelo=" + modelo + ", montadora=" + montadora + ", cliente=" + cliente + "]";
	}
    
    
	
	
}
