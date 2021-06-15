package com.mycompany.view;

import javax.swing.JOptionPane;

public class View {

	public static void exibirMensagem(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public static String inserirString(String titulo, String msg) {
		String retorno = JOptionPane.showInputDialog(null, msg, titulo, JOptionPane.DEFAULT_OPTION);
		if (retorno != null)
			return retorno;
		else
			throw new IllegalArgumentException("Nao cancele, saia/volte!");
	}

	public static Integer inserirInt(String titulo, String msg) {
		String retorno = JOptionPane.showInputDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
		if(retorno.isEmpty()) {
			throw new IllegalArgumentException("Nao cancele, saia/volte!");
		}else {
			return Integer.parseInt(retorno);
		}
	}

	public static double inserirDouble(String titulo, String msg) {
		String retorno = JOptionPane.showInputDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
		return Double.parseDouble(retorno);
	}

	public static void exibirError(String titulo, String msg) {
		JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.ERROR_MESSAGE);
	}

	public static int confirmacao(String titulo, String msg) {
		return JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_OPTION);
	}
	
	public static String menu(String op1, String op2, String titulo, String msg) {
		Object[] itens = { op1, op2 };
		Object selectedValue = JOptionPane.showInputDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE, null,
				itens, itens[0]);
		if (selectedValue == null)
			throw new IllegalArgumentException("Saindoo...");
		else
			return selectedValue.toString();
	}
}
