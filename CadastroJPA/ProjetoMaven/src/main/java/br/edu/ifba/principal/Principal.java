package br.edu.ifba.principal;


import java.util.List;

import br.edu.ifba.basicas.Funcionario;
import br.edu.ifba.basicas.HistoricoServico;
import br.edu.ifba.basicas.Veiculo;
import br.edu.ifba.basicas.Servico;
import br.edu.ifba.basicas.Cliente;
import br.edu.ifba.basicas.Endereco;
import br.edu.ifba.dao.GetEntityManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Principal {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Endereco endereco = new Endereco();
        endereco.setCidade("São Paulo");
        endereco.setBairro("Centro");
        endereco.setRua("Rua A");
        endereco.setNumero("123");
        endereco.setCep("01000-000");
        em.persist(endereco);
        
        Cliente cliente = new Cliente();
        cliente.setNome("João Silva");
        cliente.setEmail("joao@email.com");
        cliente.setCpf("123.456.789-00");
        cliente.setEndereco(endereco);
        em.persist(cliente);
        
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo("Gol");
        veiculo.setMontadora("Volkswagen");
        veiculo.setCliente(cliente);
        em.persist(veiculo);
        
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Carlos Oliveira");
        funcionario.setCpf("987.654.321-00");
        funcionario.setFuncao("Mecânico");
        em.persist(funcionario);
        
        Servico servico = new Servico();
        servico.setDescricao("Troca de óleo");
        servico.setValor(150.0);
        em.persist(servico);
        
        HistoricoServico historico = new HistoricoServico();
        historico.setFuncionario(funcionario);
        historico.setVeiculo(veiculo);
        historico.setServico(servico);
        em.persist(historico);
        
        em.getTransaction().commit();

        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        
        System.out.println(historico);
        
        em.close();
        emf.close();
	}

}
