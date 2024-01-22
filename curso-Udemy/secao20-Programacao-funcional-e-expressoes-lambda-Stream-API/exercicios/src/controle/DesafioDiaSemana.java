package controle;

import javax.swing.JOptionPane;

public class DesafioDiaSemana {

	public static void main(String[] args) {
		
		// Domingo -> retorna: 1
		// Quarta -> retorna: 4
		// Terça -> retorna: 3
		
		String valor = JOptionPane.showInputDialog("Informa a semana:");
		
		if(valor.trim().toLowerCase().equals("domingo")) {
			System.out.println(1);
		} else if(valor.trim().toLowerCase().equals("segunda")) {
			System.out.println(2);
		} else if(valor.trim().toLowerCase().equals("terça")) {
			System.out.println(3);
		} else if(valor.trim().toLowerCase().equals("quarta")) {
			System.out.println(4);
		} else if(valor.trim().toLowerCase().equals("quinta")) {
			System.out.println(5);
		} else if(valor.trim().toLowerCase().equals("sexta")) {
			System.out.println(6);
		} else if(valor.trim().toLowerCase().equals("sábado") || valor.trim().toLowerCase().equals("sabado")) {
			System.out.println(7);
		} else {
			System.out.println("Colocar uma semana válida!");
		}
		
		System.out.println("Fim!");
	}
}
