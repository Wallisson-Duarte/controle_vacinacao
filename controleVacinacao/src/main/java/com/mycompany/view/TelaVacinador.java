/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view;

import java.util.List;

import com.mycompany.dao.GenericDAO;
import com.mycompany.model.Endereco;
import com.mycompany.model.Vacinador;

/**
 *
 * @author wallisson
 */
public class TelaVacinador {

    private final GenericDAO<Vacinador> vacinadorDAO;
    private Vacinador vacinador;
    private final GenericDAO<Endereco> enderecoDAO;
    private Endereco endereco;

    public TelaVacinador() {
        this.vacinadorDAO = new GenericDAO<>();
        this.enderecoDAO = new GenericDAO<>();
    }

    public void cadastrarVacinador() {
    	try {
			this.vacinador = new Vacinador();
	        String nome = View.inserirString("Cadastro", "Digite o nome:");
	        int idade = View.inserirInt("Cadastro", "Digite a idade:");
	        String cpf = View.inserirString("Cadastro", "Digite o cpf:");
	        String telefone = View.inserirString("Cadastro", "Digite o telefone:");
	        this.vacinador.setNome(nome);
	        this.vacinador.setIdade(idade);
	        this.vacinador.setCpf(cpf);
	        this.vacinador.setTelefone(telefone);
	        
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
	        this.vacinador.setEnderecoid(this.endereco);
	        
	        if (enderecoDAO.saveOrUpdate(endereco) && vacinadorDAO.saveOrUpdate(vacinador)) {
	            System.out.println("Cadastro Realizado");
	        } else {
	           System.out.println("Cadastro não realizado!");
	        }
		} catch (Exception e) {
			View.exibirError("ERROR", e.getMessage());
		}


    }

    public void alterarVacinador() {
  
    	try {
			Integer idAlterar = View.inserirInt("Alteração", "Digite o ID do vacinador para alterar:");
	        this.vacinador = vacinadorDAO.findById(Vacinador.class, idAlterar);
	    	String opcoes = View.menu("Pessoal", "Endereço", "Alterar", "Escolha as opções abaixo");
	    	switch (opcoes) {
				case "Pessoal":
			        String nome = View.inserirString("Alterar", "Digite o nome:");
			        int idade = View.inserirInt("Alterar", "Digite a idade:");
			        String cpf = View.inserirString("Alterar", "Digite o cpf:");
			        String telefone = View.inserirString("Alterar", "Digite o telefone:");
			        this.vacinador.setNome(nome);
			        this.vacinador.setIdade(idade);
			        this.vacinador.setCpf(cpf);
			        this.vacinador.setTelefone(telefone);
		
			        if (vacinadorDAO.saveOrUpdate(vacinador)) {
			            View.exibirMensagem("Alteração realizada");
			        } else {
			        	View.exibirError("ERROR","Alteração não realizada!");
			        }
					break;
		
				case "Endereço":
					this.endereco = this.vacinador.getEnderecoid();
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
			        this.vacinador.setEnderecoid(this.endereco);
		
			        if (enderecoDAO.saveOrUpdate(endereco)) {
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

    public void excluirVacinador() {
    	
    	try {
			Integer idExcluir = View.inserirInt("Exclusão", "Digite o ID do vacinador para Exclusão:");
	        if (vacinadorDAO.remove(Vacinador.class, idExcluir)) {
	        	View.exibirMensagem("Exclusão realizada!");
	        } else {
	        	View.exibirError("ExcluirPaciente","Exclusão não realizada!");
	        }
		} catch (Exception e) {
			View.exibirError("ERROR", e.getMessage());
		}


    }
    
     public void listarVacinadors() {                                                  
    	String vacinadores = "";
        List<Vacinador> vacinadors;//criando uma lista
        vacinadors = vacinadorDAO.list(Vacinador.class);
        if (vacinadors.isEmpty())
        	View.exibirError("ERROR", "Lista vazia");
        else {
        	for (Vacinador vacinador : vacinadors) {
            	vacinadores += "\nID: " + vacinador.getId()+"\nNome: "+vacinador.getNome()+"\n";
			}
        	View.exibirMensagem(vacinadores);
        }
        
    }                                                 
}
