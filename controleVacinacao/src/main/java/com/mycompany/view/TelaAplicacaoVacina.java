package com.mycompany.view;

import java.util.List;

import com.mycompany.dao.GenericDAO;
import com.mycompany.model.Aplicacaovacina;
import com.mycompany.model.Paciente;
import com.mycompany.model.Posto;
import com.mycompany.model.Vacina;
import com.mycompany.model.Vacinador;

public class TelaAplicacaoVacina {

	private final GenericDAO<Aplicacaovacina> aplicacaoDAO;
	Aplicacaovacina aplicacaovacina;
	
	TelaAplicacaoVacina(){
		this.aplicacaoDAO = new GenericDAO<>();
	}
	
	public void inserir(String vacinador, String vacina, String paciente, String posto, Integer dose, Integer dia, Integer mes, Integer ano) {
		
		aplicacaovacina = new Aplicacaovacina();
		aplicacaovacina.setData(dia+"/"+mes+"/"+ano);
		aplicacaovacina.setDose(dose.toString());
		
		final GenericDAO<Vacinador> vDAO = new GenericDAO<>();
		List<Vacinador> vacinadores = vDAO.list(Vacinador.class);
    	for (Vacinador vacinadorL : vacinadores) {
    		if(vacinadorL.getNome().equals(vacinador)) {
    			aplicacaovacina.setVacinadorid(vacinadorL);
    		}
		}
    	
		final GenericDAO<Vacina> vacinaDAO = new GenericDAO<>();
		List<Vacina> vacinas = vacinaDAO.list(Vacina.class);
    	for (Vacina vacinaL : vacinas) {
    		if(vacinaL.getNome().equals(vacina)) {
    			aplicacaovacina.setVacinaid(vacinaL);
    		}
		}

    	
		final GenericDAO<Paciente> pacienteDAO = new GenericDAO<>();
		List<Paciente> pacientes = pacienteDAO.list(Paciente.class);
    	for (Paciente pacienteL : pacientes) {
    		if(pacienteL.getNome().equals(paciente)) {
    			aplicacaovacina.setPacienteid(pacienteL);
    		}
		}
    	
    	final GenericDAO<Posto> postoDAO = new GenericDAO<>();
		List<Posto> postos = postoDAO.list(Posto.class);
    	for (Posto postosL : postos) {
    		if(postosL.getNome().equals(posto)) {
    			aplicacaovacina.setPostoid(postosL);
    		}
		}
    	
    	if (aplicacaoDAO.saveOrUpdate(aplicacaovacina)) {
    		View.exibirMensagem("Dose Aplicada");
        } else {
        	View.exibirError("ERROR","Cadastro não realizado!");
        }
    	
    	
	}

	public void listar() {
		String pacientesLista = "";
        List<Aplicacaovacina> aplicacoes;//criando uma lista
        aplicacoes = aplicacaoDAO.list(Aplicacaovacina.class);
        if (aplicacoes.isEmpty())
        	View.exibirError("ERROR", "Lista vazia");
        else {
        	for (Aplicacaovacina aplicacao : aplicacoes) {
        		pacientesLista += "\nID: " + aplicacao.getId()+"\nNome: "+aplicacao.getPacienteid().getNome()+"\n";
        	}
        	View.exibirMensagem(pacientesLista);
        }
        
	}
}
