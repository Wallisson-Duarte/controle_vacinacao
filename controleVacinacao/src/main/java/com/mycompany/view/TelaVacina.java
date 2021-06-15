/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view;

import java.util.List;

import com.mycompany.dao.GenericDAO;
import com.mycompany.model.Vacina;

/**
 *
 * @author wallisson
 */
public class TelaVacina {

    private final GenericDAO<Vacina> vacinaDAO;
    private Vacina vacina;

    public TelaVacina() {
        this.vacinaDAO = new GenericDAO<>();
    }

    public void cadastrarVacina() {
    	
    	try {
			Vacina vacina = new Vacina();
        
	        String nome = View.inserirString("Cadastro", "Digite o nome:");
	        String fabricante = View.inserirString("Cadastro", "Digite o Fabricante:");
	        String lote = View.inserirString("Cadastro", "Digite o lote:");
	        
	        vacina.setNome(nome);
	        vacina.setFabricante(fabricante);
	        vacina.setLote(lote);
	
	        if (vacinaDAO.saveOrUpdate(vacina)) {
	        	View.exibirMensagem("Cadastro Realizado");
	        } else {
	           View.exibirError("ERROR","Cadastro não realizado!");
	        }
		} catch (Exception e) {
			View.exibirError("ERROR", e.getMessage());
		}
    }

    public void alterarVacina() {
    	
    	try {
			Integer idAlterar = View.inserirInt("Alteração", "Digite o ID da vacina para alterar:");
	        vacina = vacinaDAO.findById(Vacina.class, idAlterar);
	        String nome = View.inserirString("Cadastro", "Digite o nome:");
	        String fabricante = View.inserirString("Cadastro", "Digite o Fabricante:");
	        String lote = View.inserirString("Cadastro", "Digite o lote:");
	        
	        vacina.setNome(nome);
	        vacina.setFabricante(fabricante);
	        vacina.setLote(lote);
	
	        if (vacinaDAO.saveOrUpdate(vacina)) {
	        	View.exibirMensagem("Alteração Realizada");
	        } else {
	        	View.exibirError("ERROR","Alteração não realizada!");
	        }

		} catch (Exception e) {
			View.exibirError("ERROR", e.getMessage());
		}

    }

    public void excluirVacina() {
    	
    	try {
			Integer idExcluir = View.inserirInt("Exclusão", "Digite o ID da vacina para Excluir:");
	        if (vacinaDAO.remove(Vacina.class,idExcluir)) {
	        	View.exibirMensagem("Exclusão realizada!");
	        } else {
	            View.exibirError("ERROR","Exclusão não realizada!");
	        }
		} catch (Exception e) {
			View.exibirError("ERROR", e.getMessage());
		}


    }
    
     public void listarVacinas() {                                                  
        String vacinasList = "";
        List<Vacina> vacinas;//criando uma lista
        vacinas = vacinaDAO.list(Vacina.class);
        if (vacinas.isEmpty())
        	View.exibirError("ERROR", "Lista vazia");
        else {
        	for (Vacina i : vacinas) {
				vacinasList += "\nID: " + i.getId()+"\nNome:"+i.getNome()+"\nFabricante: "
	            		+ i.getFabricante()+"\nLote: " +i.getLote();
			}
        	View.exibirMensagem(vacinasList);
        }
        
    }   
}    
