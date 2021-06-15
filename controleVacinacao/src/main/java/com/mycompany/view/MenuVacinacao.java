package com.mycompany.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mycompany.dao.GenericDAO;
import com.mycompany.model.Paciente;
import com.mycompany.model.Posto;
import com.mycompany.model.Vacina;
import com.mycompany.model.Vacinador;

public class MenuVacinacao {
	public static void main(String[] args) {
		final GenericDAO<Posto> postoDAO = new GenericDAO<>();
		final GenericDAO<Paciente> pacienteDAO = new GenericDAO<>();
		final GenericDAO<Vacina> vacinaDAO = new GenericDAO<>();
		final GenericDAO<Vacinador> vacinadorDAO = new GenericDAO<>();
		JFrame TelaMenu = new JFrame(); //Assigned the JFrame name
		
		TelaMenu.setTitle("Posto de Vacina");
		
		TelaMenu.setSize(800, 600);
		
		TelaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Asigned the close operator
		TelaMenu.getContentPane().setLayout(null);
		
		JComboBox<String> cbPostos = new JComboBox<String>();
		cbPostos.setBounds(29, 180, 157, 21);
		List<Posto> postos = postoDAO.list(Posto.class);
    	for (Posto posto : postos) {
    		cbPostos.addItem(""+posto.getNome());
		}
    	
		TelaMenu.getContentPane().add(cbPostos);
		
		JComboBox<String> cbPaciente = new JComboBox<String>();
		cbPaciente.setBounds(29, 118, 157, 21);
		List<Paciente> pacientes = pacienteDAO.list(Paciente.class);
    	for (Paciente paciente : pacientes) {
    		cbPaciente.addItem(""+paciente.getNome());
		}
    	
		TelaMenu.getContentPane().add(cbPaciente);
		
		JComboBox<String> cbVacina = new JComboBox<String>();
		cbVacina.setBounds(29, 236, 157, 21);
		List<Vacina> vacinas = vacinaDAO.list(Vacina.class);
    	for (Vacina vacina : vacinas) {
    		cbVacina.addItem(""+vacina.getNome());
		}
		TelaMenu.getContentPane().add(cbVacina);
		
		JComboBox<String> cbVacinador = new JComboBox<String>();
		List<Vacinador> vacinadores = vacinadorDAO.list(Vacinador.class);
		Random gerador = new Random();
		cbVacinador.addItem(""+vacinadores.get(gerador.nextInt(vacinadores.size())).getNome());
		cbVacinador.setEnabled(false);
		cbVacinador.setBounds(29, 293, 157, 21);
		TelaMenu.getContentPane().add(cbVacinador);
		
		JComboBox<Integer> cbDose = new JComboBox<Integer>();
		cbDose.setBounds(196, 236, 51, 21);
		cbDose.addItem(1);
		cbDose.addItem(2);
		TelaMenu.getContentPane().add(cbDose);
		
		JComboBox<Integer> cbDia = new JComboBox<Integer>();
		cbDia.setBounds(29, 352, 41, 21);
		for (int i = 1; i <= 31; i++) {
			cbDia.addItem(i);
		}
		TelaMenu.getContentPane().add(cbDia);
		
		JComboBox<Integer> cbMes = new JComboBox<Integer>();
		cbMes.setBounds(80, 352, 38, 21);
		for (int i = 1; i <= 12; i++) {
			cbMes.addItem(i);
		}
		TelaMenu.getContentPane().add(cbMes);
		
		JComboBox<Integer> cbAno = new JComboBox<Integer>();
		cbAno.setBounds(128, 352, 58, 21);
		for (int i = 1980; i <= 2030; i++) {
			cbAno.addItem(i);
		}
		TelaMenu.getContentPane().add(cbAno);
		
		JButton btnSend = new JButton("Inserir");
		btnSend.setBounds(62, 409, 85, 21);
		TelaMenu.getContentPane().add(btnSend);
		
		JButton btnListagem = new JButton("Listagem");
		btnListagem.setBounds(62, 440, 85, 21);
		TelaMenu.getContentPane().add(btnListagem);
		
		JLabel lblNewLabel = new JLabel("Paciente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(29, 95, 92, 13);
		TelaMenu.getContentPane().add(lblNewLabel);
		
		JLabel lblPosto = new JLabel("Posto");
		lblPosto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPosto.setBounds(29, 157, 92, 13);
		TelaMenu.getContentPane().add(lblPosto);
		
		JLabel lblVacina = new JLabel("Vacina");
		lblVacina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVacina.setBounds(29, 213, 92, 13);
		TelaMenu.getContentPane().add(lblVacina);
		
		JLabel lblVacinador = new JLabel("Vacinador");
		lblVacinador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVacinador.setBounds(29, 270, 92, 13);
		TelaMenu.getContentPane().add(lblVacinador);
		
		JLabel lblData = new JLabel("Data  (Dia/Mes/Ano)");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(29, 329, 157, 13);
		TelaMenu.getContentPane().add(lblData);
		
		JLabel lblDose = new JLabel("Dose");
		lblDose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDose.setBounds(196, 215, 92, 13);
		TelaMenu.getContentPane().add(lblDose);
		
		JLabel panel = new JLabel();
		panel.setBounds(407, 138, 255, 259);
		
		panel.setIcon(new ImageIcon("src\\main\\java\\images\\vacina.png"));
		TelaMenu.getContentPane().add(panel);
		
		TelaMenu.setVisible(true);

		TelaAplicacaoVacina aplicacaoVacina = new TelaAplicacaoVacina();
		btnSend.addActionListener(new ActionListener() { //Botao paciente
			public void actionPerformed(ActionEvent e) {
				aplicacaoVacina.inserir(cbVacinador.getSelectedItem().toString(), 
						cbVacina.getSelectedItem().toString(), 
						cbPaciente.getSelectedItem().toString(),
						cbPostos.getSelectedItem().toString(), 
						cbDose.getSelectedIndex(), 
						cbDia.getSelectedIndex(), 
						cbMes.getSelectedIndex(), 
						cbAno.getSelectedIndex()
					);
			}
		});
		btnListagem.addActionListener(new ActionListener() { //Botao paciente
			public void actionPerformed(ActionEvent e) {
				aplicacaoVacina.listar();
			}
		});
		
	}
	
	
	
}
