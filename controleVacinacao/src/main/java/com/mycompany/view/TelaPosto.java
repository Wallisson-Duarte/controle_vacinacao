/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view;

import java.util.List;

import com.mycompany.dao.GenericDAO;
import com.mycompany.model.Endereco;
import com.mycompany.model.Posto;

/**
 *
 * @author wallisson
 */
public class TelaPosto {

    private final GenericDAO<Posto> postoDAO;
    private Posto posto;
    private final GenericDAO<Endereco> enderecoDAO;
    private Endereco endereco;

    public TelaPosto() {
        this.postoDAO = new GenericDAO<>();
        this.enderecoDAO = new GenericDAO<>();
    }

    public void cadastrarPosto() {
    	try {
    		this.endereco = new Endereco();
    		this.posto = new Posto();
    		
			String nome = View.inserirString("Cadastro", "Digite o nome:");
	        String estado = View.inserirString("Cadastro", "Digite o estado:");
	        String cep = View.inserirString("Cadastro", "Digite o CEP:");
	        String rua = View.inserirString("Cadastro", "Digite a Rua:");
	        Integer numero = View.inserirInt("Cadastro", "Digite o Numero:");
	        String cidade = View.inserirString("Cadastro", "Digite a cidade:");
	        
	        this.posto.setNome(nome);
	        this.endereco.setCep(cep);
	        this.endereco.setRua(rua);
	        this.endereco.setNumero(numero);
	        this.endereco.setCidade(cidade);
	        this.endereco.setEstado(estado);  
	        this.posto.setEnderecoid(this.endereco);
	    	} catch (Exception e) {
	    		View.exibirError("ERROR", e.getMessage());
	    	}
	               
	        	
	        if (enderecoDAO.saveOrUpdate(endereco) && postoDAO.saveOrUpdate(posto)) {
	        	View.exibirMensagem("Cadastro Realizado");
	        } else {
	        	View.exibirError("ERROR","Cadastro não realizado!");
	        }

    }

    public void alterarPosto() {

    	Integer idAlterar = View.inserirInt("Alteração", "Digite o ID do posto para alterar:");
        this.posto = postoDAO.findById(Posto.class, idAlterar);
        this.endereco = this.posto.getEnderecoid();
        try {
	    	String nome = View.inserirString("Cadastro", "Digite o nome:");
	        String estado = View.inserirString("Cadastro", "Digite o estado:");
	        String cep = View.inserirString("Cadastro", "Digite o CEP:");
	        int rua = View.inserirInt("Cadastro", "Digite a Rua:");
	        String numero = View.inserirString("Cadastro", "Digite o Numero:");
	        String cidade = View.inserirString("Cadastro", "Digite a cidade:");
	        
	        this.posto.setNome(nome);
	        this.endereco.setCep(estado);
	        this.endereco.setRua(cep);
	        this.endereco.setNumero(rua);
	        this.endereco.setCidade(numero);
	        this.endereco.setEstado(cidade);  
	
	        if (postoDAO.saveOrUpdate(posto) && enderecoDAO.saveOrUpdate(endereco)) {
	            View.exibirMensagem("Alteração realizada");
	        } else {
	        	View.exibirError("ERROR","Alteração não realizada!");
	        }			
		} catch (Exception e) {
			View.exibirError("ERROR", e.getMessage());
		}


    }

    public void excluirPosto() {
    	try {
	    	Integer idExluir = View.inserirInt("Exclusão", "Digite o ID da paciente para exclusão:");
	        if (postoDAO.remove(Posto.class, idExluir)) {
	        	View.exibirMensagem("Exclusão realizada!");
	        } else {
	        	View.exibirError("ExcluirPaciente","Exclusão não realizada!");
	        }			
		} catch (Exception e) {
			View.exibirError("ERROR", e.getMessage());
		}

    }
    
     public void listarPostos() {                                                  
    	String postoList = "";
        List<Posto> postos;//criando uma lista
        postos = postoDAO.list(Posto.class);
        if (postos.isEmpty())
        	View.exibirError("ERROR", "Lista vazia");
        else {
        	for (Posto posto : postos) {
        		postoList += "\nID: " + posto.getId()+"\nNome: "+posto.getNome()+"\n";
			}
        	View.exibirMensagem(postoList);
        }
        
    }                                                 
}
