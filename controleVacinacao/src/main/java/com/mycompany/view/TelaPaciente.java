/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view;

import java.util.List;

import com.mycompany.dao.GenericDAO;
import com.mycompany.model.Endereco;
import com.mycompany.model.Paciente;

/**
 *
 * @author wallisson
 */
public class TelaPaciente {

    private final GenericDAO<Paciente> pacienteDAO;
    private Paciente paciente;
    private final GenericDAO<Endereco> enderecoDAO;
    private Endereco endereco;

    public TelaPaciente() {
        this.pacienteDAO = new GenericDAO<>();
        this.enderecoDAO = new GenericDAO<>();
    }

    public void cadastrarPaciente() {
    	
    	try {		
	        this.paciente = new Paciente();
	        String nome = View.inserirString("Cadastro", "Digite o nome:");
	        int idade = View.inserirInt("Cadastro", "Digite a idade:");
	        String cpf = View.inserirString("Cadastro", "Digite o cpf:");
	        String telefone = View.inserirString("Cadastro", "Digite o telefone:");
	        String fator_de_risco = View.inserirString("Cadastro", "Digite o fator de risco:");
	        this.paciente.setNome(nome);
	        this.paciente.setIdade(idade);
	        this.paciente.setCpf(cpf);
	        this.paciente.setTelefone(telefone);
	        this.paciente.setFatorRisco(fator_de_risco);
	        
	        //endereco
	        this.endereco = new Endereco();
	        String estado = View.inserirString("Cadastro", "Digite o estado:");
	        String cep = View.inserirString("Cadastro", "Digite o CEP:");
	        int rua = View.inserirInt("Cadastro", "Digite a Rua:");
	        String numero = View.inserirString("Cadastro", "Digite o Numero:");
	        String cidade = View.inserirString("Cadastro", "Digite a cidade:");
	        this.endereco.setCep(estado);
	        this.endereco.setRua(cep);
	        this.endereco.setNumero(rua);
	        this.endereco.setCidade(numero);
	        this.endereco.setEstado(cidade);        
	        this.paciente.setEnderecoid(this.endereco);
        	if (enderecoDAO.saveOrUpdate(endereco) && pacienteDAO.saveOrUpdate(paciente)) {
        		View.exibirMensagem("Cadastro Realizado");
	        } else {
	        	View.exibirError("ERROR","Cadastro não realizado!");
	        }
		} catch (Exception e) {
			View.exibirError("ERROR", e.getMessage());
		}
        


    }

    public void alterarPaciente() {
    	
    	try {
        	Integer idAlterar = View.inserirInt("Alteração", "Digite o ID da paciente para alterar:");
        	this.paciente = pacienteDAO.findById(Paciente.class, idAlterar);
        	
        	String opcoes = View.menu("Pessoal", "Endereço", "Alterar", "Escolha as opções abaixo");
        	switch (opcoes) {
    		case "Pessoal":
    	        String nome = View.inserirString("Alterar", "Digite o nome:");
    	        int idade = View.inserirInt("Alterar", "Digite a idade:");
    	        String cpf = View.inserirString("Alterar", "Digite o cpf:");
    	        String telefone = View.inserirString("Alterar", "Digite o telefone:");
    	        String fator_de_risco = View.inserirString("Alterar", "Digite o fator de risco:");
    	        this.paciente.setNome(nome);
    	        this.paciente.setIdade(idade);
    	        this.paciente.setCpf(cpf);
    	        this.paciente.setTelefone(telefone);
    	        this.paciente.setFatorRisco(fator_de_risco);

    	        if (pacienteDAO.saveOrUpdate(paciente)) {
    	            View.exibirMensagem("Alteração realizada");
    	        } else {
    	        	View.exibirError("ERROR","Alteração não realizada!");
    	        }
    			break;

    		case "Endereço":
    			this.endereco = this.paciente.getEnderecoid();
    	        String estado = View.inserirString("Alterar", "Digite o estado:");
    	        String cep = View.inserirString("Alterar", "Digite o CEP:");
    	        int rua = View.inserirInt("Alterar", "Digite a Rua:");
    	        String numero = View.inserirString("Alterar", "Digite o Numero:");
    	        String cidade = View.inserirString("Alterar", "Digite a cidade:");
    	        this.endereco.setCep(estado);
    	        this.endereco.setRua(cep);
    	        this.endereco.setNumero(rua);
    	        this.endereco.setCidade(numero);
    	        this.endereco.setEstado(cidade);        
    	        this.paciente.setEnderecoid(this.endereco);

    	        if ( enderecoDAO.saveOrUpdate(endereco)) {
    	        	View.exibirMensagem("Alteração realizada");
    	        } else {
    	        	View.exibirError("ERROR","Alteração não realizada!");
    	        }
    			break;
    		}
		} catch (Exception e) {
			View.exibirError("ERROR", e.getMessage());
		}

    }

    public void excluirPaciente() {
    	try {
    		Integer idExluir = View.inserirInt("Exclusão", "Digite o ID da paciente para exclusão:");
			if (pacienteDAO.remove(Paciente.class, idExluir)) {
	        	View.exibirMensagem("Exclusão realizada!");
	        } else {
	        	View.exibirError("ExcluirPaciente","Exclusão não realizada!");
	        }
		} catch (Exception e) {
			View.exibirError("ERROR", e.getMessage());
		}
        

    }
    
     void listarPacientes() {                                                  
    	String pacientesLista = "";
        List<Paciente> pacientes;//criando uma lista
        pacientes = pacienteDAO.list(Paciente.class);
        if (pacientes.isEmpty())
        	View.exibirError("ERROR", "Lista vazia");
        else {
        	for (Paciente paciente : pacientes) {
        		pacientesLista += "\nID: " + paciente.getId()+"\nNome: "+paciente.getNome()+"\n";
        	}
        	View.exibirMensagem(pacientesLista);
        }
        
    }                                                 
}
