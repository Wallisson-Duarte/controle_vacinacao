package com.mycompany.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MenuAdmin {

		public static void main(String[] args) {
			TelaPaciente telaPaciente = new TelaPaciente();
			TelaVacinador telaVacinador = new TelaVacinador();
			TelaVacina telaVacina = new TelaVacina();
			TelaPosto telaPosto = new TelaPosto();
			JFrame TelaMenu = new JFrame(); //Assigned the JFrame name
			
			TelaMenu.setTitle("Posto de Vacina");
			
			TelaMenu.setSize(800, 600);
			
			TelaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Asigned the close operator
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Posto de vacina\u00E7\u00E3o", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
			TelaMenu.getContentPane().add(tabbedPane, BorderLayout.CENTER);
			
			JPanel Menu = new JPanel();
			tabbedPane.addTab("Menu", null, Menu, null);
			Menu.setLayout(null);
			JButton btnPaciente = new JButton("Paciente");
			btnPaciente.setBounds(290, 167, 127, 21);
			
			Menu.add(btnPaciente);
			
			JLabel lblTextTitle = new JLabel("Menu Controle");
			lblTextTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblTextTitle.setBounds(269, 74, 261, 52);
			Menu.add(lblTextTitle);
			
			JButton btnVacinador = new JButton("Vacinador");
			btnVacinador.setBounds(290, 198, 127, 21);
			Menu.add(btnVacinador);
			
			JButton btnVacina = new JButton("Vacina");
			btnVacina.setBounds(290, 229, 127, 21);
			Menu.add(btnVacina);
			
			JButton btnVacinacao = new JButton("Posto");
			btnVacinacao.setBounds(290, 260, 127, 21);
			Menu.add(btnVacinacao);
			
			JButton btnSair = new JButton("Sair");
			btnSair.setBounds(290, 291, 127, 21);
			Menu.add(btnSair);
			
			//Botoes
			btnPaciente.addActionListener(new ActionListener() { //Botao paciente
				public void actionPerformed(ActionEvent e) {
					tabbedPane.setSelectedIndex(1);
				}
			});
			btnVacinador.addActionListener(new ActionListener() { //Botao paciente
				public void actionPerformed(ActionEvent e) {
					tabbedPane.setSelectedIndex(2);
				}
			});
			btnVacina.addActionListener(new ActionListener() { //Botao paciente
				public void actionPerformed(ActionEvent e) {
					tabbedPane.setSelectedIndex(3);
				}
			});
			btnVacinacao.addActionListener(new ActionListener() { //Botao paciente
				public void actionPerformed(ActionEvent e) {
					tabbedPane.setSelectedIndex(4);
				}
			});
			btnSair.addActionListener(new ActionListener() { //Botao Sair
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			JPanel pPaciente = new JPanel();
			pPaciente.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			tabbedPane.addTab("Paciente", null, pPaciente, null);
			pPaciente.setLayout(null);
			
			JButton btnPacienteCreate = new JButton("Adicionar Paciente");
			btnPacienteCreate.setBounds(290, 167, 127, 21);
			pPaciente.add(btnPacienteCreate);
			
			JButton btnPacienteRead = new JButton("Listar Paciente");
			btnPacienteRead.setBounds(290, 198, 127, 21);
			pPaciente.add(btnPacienteRead);
			
			JButton btnPacienteDelete = new JButton("Deletar Paciente");
			btnPacienteDelete.setBounds(290, 229, 127, 21);
			pPaciente.add(btnPacienteDelete);
			
			JButton btnPacienteUpdate = new JButton("Atualizar Paciente");
			btnPacienteUpdate.setBounds(290, 260, 127, 21);
			pPaciente.add(btnPacienteUpdate);
			
			JLabel lblControle = new JLabel("Controle Paciente");
			lblControle.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblControle.setBounds(242, 75, 261, 52);
			pPaciente.add(lblControle);
			btnPacienteCreate.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaPaciente.cadastrarPaciente();
				}
			});
			btnPacienteUpdate.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaPaciente.alterarPaciente();
				}
			});		
			btnPacienteDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaPaciente.excluirPaciente();
				}
			});			
			btnPacienteRead.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaPaciente.listarPacientes();
				}
			});
			
			JPanel pVacinador = new JPanel();
			tabbedPane.addTab("Vacinador", null, pVacinador, null);
			pVacinador.setLayout(null);
			
			JButton btnVacinadorCreate = new JButton("Adicionar Vacinador");
			btnVacinadorCreate.setBounds(290, 167, 127, 21);
			pVacinador.add(btnVacinadorCreate);
			
			JButton btnVacinadorRead = new JButton("Listar Vacinador");
			btnVacinadorRead.setBounds(290, 198, 127, 21);
			pVacinador.add(btnVacinadorRead);
			
			JButton btnVacinadorDelete = new JButton("Deletar Vacinador");
			btnVacinadorDelete.setBounds(290, 229, 127, 21);
			pVacinador.add(btnVacinadorDelete);
			
			JButton btnAtualizarVacinador = new JButton("Atualizar Vacinador");
			btnAtualizarVacinador.setBounds(290, 260, 127, 21);
			pVacinador.add(btnAtualizarVacinador);
			
			JLabel lblControleVacinador = new JLabel("Controle Vacinador");
			lblControleVacinador.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblControleVacinador.setBounds(225, 80, 261, 52);
			pVacinador.add(lblControleVacinador);
			
			btnVacinadorCreate.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaVacinador.cadastrarVacinador();
				}
			});
			btnVacinadorRead.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaVacinador.listarVacinadors();
				}
			});		
			btnVacinadorDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaVacinador.excluirVacinador();
				}
			});			
			btnAtualizarVacinador.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaVacinador.alterarVacinador();
				}
			});
			
			JPanel pVacina = new JPanel();
			tabbedPane.addTab("Vacina", null, pVacina, null);
			pVacina.setLayout(null);
			
			JButton btnVacinaCreate = new JButton("Adicionar Vacina");
			btnVacinaCreate.setBounds(290, 167, 127, 21);
			pVacina.add(btnVacinaCreate);
			
			JButton btnVacinaRead = new JButton("Listar Vacina");
			btnVacinaRead.setBounds(290, 198, 127, 21);
			pVacina.add(btnVacinaRead);
			
			JButton btnVacinaDelete = new JButton("Deletar Vacina");
			btnVacinaDelete.setBounds(290, 229, 127, 21);
			pVacina.add(btnVacinaDelete);
			
			JButton btnVacinaUpdate = new JButton("Atualizar Vacina");
			btnVacinaUpdate.setBounds(290, 260, 127, 21);
			pVacina.add(btnVacinaUpdate);
			
			JLabel lblControleVacina = new JLabel("Controle Vacina");
			lblControleVacina.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblControleVacina.setBounds(239, 74, 261, 52);
			pVacina.add(lblControleVacina);
			
			btnVacinaCreate.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaVacina.cadastrarVacina();
				}
			});
			btnVacinaRead.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaVacina.listarVacinas();
				}
			});	
			btnVacinaDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaVacina.excluirVacina();
				}
			});			
			btnVacinaUpdate.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaVacina.alterarVacina();
				}
			});
			
			JPanel pPosto = new JPanel();
			tabbedPane.addTab("Posto", null, pPosto, null);
			pPosto.setLayout(null);
			
			JButton btnPostoCreate = new JButton("Adicionar Posto");
			btnPostoCreate.setBounds(290, 167, 127, 21);
			pPosto.add(btnPostoCreate);
			
			JButton btnPostoRead = new JButton("Listar Posto");
			btnPostoRead.setBounds(290, 198, 127, 21);
			pPosto.add(btnPostoRead);
			
			JButton btnPostoDelete = new JButton("Deletar Posto");
			btnPostoDelete.setBounds(290, 229, 127, 21);
			pPosto.add(btnPostoDelete);
			
			JButton btnPostoUpdate = new JButton("Atualizar Posto");
			btnPostoUpdate.setBounds(290, 260, 127, 21);
			pPosto.add(btnPostoUpdate);
			
			JLabel lblControle_1 = new JLabel("Controle Paciente");
			lblControle_1.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblControle_1.setBounds(238, 69, 261, 52);
			pPosto.add(lblControle_1);
			
			btnPostoCreate.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaPosto.cadastrarPosto();
				}
			});
			btnPostoRead.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaPosto.listarPostos();
				}
			});		
			btnPostoDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaPosto.excluirPosto();
				}
			});			
			btnPostoUpdate.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					telaPosto.alterarPosto();
				}
			});
			
			TelaMenu.setVisible(true); //set the user to see the gui

		}
	}

