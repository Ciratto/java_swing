package com.udemy.java_swing;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JavaSwing05CopyText extends JFrame {
	
	private JTextField fieldValue = new JTextField(5); 
	private JTextField result = new JTextField(10);

	//Comienza a construir la pantalla.
	public JavaSwing05CopyText() throws HeadlessException {
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Valor: ");
		JButton botonCopiar = new JButton("Copiar");

		//Listeners
		botonCopiar.addActionListener(new CopyTextActionListener());
		
		panel.setLayout(new FlowLayout());
		panel.add(label);
		panel.add(fieldValue);
		panel.add(botonCopiar);
		panel.add(result);
		setContentPane(panel);		
	
		setTitle("Ejemplo copy text");
		setSize(400,100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class CopyTextActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String texto = fieldValue.getText();
			result.setText(texto);
		}
	}

	//Dispara la ventana.
	public static void main(String[] args) {
		JFrame frame = new JavaSwing05CopyText();
	}
}
