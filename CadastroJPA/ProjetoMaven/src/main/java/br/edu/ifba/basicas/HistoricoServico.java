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
public class HistoricoServico {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
	
	
	
	
	
    public HistoricoServico() {
		super();
	}

	public HistoricoServico(int id, Funcionario funcionario, Veiculo veiculo, Servico servico) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.veiculo = veiculo;
		this.servico = servico;
	}

	@ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;
    
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	@Override
	public String toString() {
		return "HistoricoServico [id=" + id + ", funcionario=" + funcionario + ", veiculo=" + veiculo + ", servico="
				+ servico + "]";
	}
    
    
    
	
}
