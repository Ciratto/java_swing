package com.udemy.java_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JavaSwing09CalculatorPlus extends JFrame{
	JTextField txtVisorAuxiliar = new JTextField("");
	JTextField txtVisorTotal = new JTextField("");
	
	String operacion = "";
	Double auxiliar1= 0D;
	Double auxiliar2= 0D;
	Double total = 0D;
	

	//Disparador de pantalla
	public static void main(String[] args) {
		new JavaSwing09CalculatorPlus();
	}
	
	//Constructor de la ventana.
	private JavaSwing09CalculatorPlus() {
		super("Calcu.");
		Container container = getContentPane();
		container.setLayout(new BorderLayout(5,5)); //Que los componente sinteriores se sectoricen por norte, sur, este, oeste, y centro
		
		//Visores de pantalla
		txtVisorAuxiliar.setHorizontalAlignment(JTextField.CENTER);
		txtVisorAuxiliar.setEnabled(false);
		txtVisorTotal.setHorizontalAlignment(JTextField.CENTER);
		txtVisorTotal.setEnabled(false);
		txtVisorTotal.setFont(new Font("Serif",Font.BOLD,16));
		
		//Botones
		
		JButton botonAC = new JButton("AC");
		JButton boton0 = new JButton("0");
		JButton boton1 = new JButton("1");
		JButton boton2 = new JButton("2");
		JButton boton3 = new JButton("3");
		JButton boton4 = new JButton("4");
		JButton boton5 = new JButton("5");
		JButton boton6 = new JButton("6");
		JButton boton7 = new JButton("7");
		JButton boton8 = new JButton("8");
		JButton boton9 = new JButton("9");
		JButton botonSuma = new JButton("+");
		JButton botonResta = new JButton("-");
		JButton botonDivision = new JButton("/");
		JButton botonMultiplica = new JButton("*");
		JButton botonIgualdad = new JButton("=");
		
		//Listeners
		boton0.addActionListener(e->BtnNumeroClick(e));
		boton1.addActionListener(e->BtnNumeroClick(e));
		boton2.addActionListener(e->BtnNumeroClick(e));
		boton3.addActionListener(e->BtnNumeroClick(e));
		boton4.addActionListener(e->BtnNumeroClick(e));
		boton5.addActionListener(e->BtnNumeroClick(e));
		boton6.addActionListener(e->BtnNumeroClick(e));
		boton7.addActionListener(e->BtnNumeroClick(e));
		boton8.addActionListener(e->BtnNumeroClick(e));
		boton9.addActionListener(e->BtnNumeroClick(e));
		
		botonSuma.addActionListener(e->BtnOperacionClick(e));
		botonResta.addActionListener(e->BtnOperacionClick(e));
		botonDivision.addActionListener(e->BtnOperacionClick(e));
		botonMultiplica.addActionListener(e->BtnOperacionClick(e));
		botonIgualdad.addActionListener(e->BtnOperacionClick(e));

		botonAC.addActionListener(e-> BotonACLimpiar());
		
		//Paneles.
		JPanel panelTop = new JPanel(new GridLayout(2,2,5,5));
		JPanel panelCenter = new JPanel(new GridLayout(5,3,5,5));
		JPanel panelRight = new JPanel(new GridLayout(5,1,5,5));
		
		panelTop.add(txtVisorAuxiliar);
		panelTop.add(txtVisorTotal);
		panelTop.setBorder(new EmptyBorder(10,10,10,10));
		
		panelCenter.add(botonAC);
		panelCenter.add(new JLabel());
		panelCenter.add(new JLabel());
		panelCenter.add(boton7);
		panelCenter.add(boton8);
		panelCenter.add(boton9);
		panelCenter.add(boton4);
		panelCenter.add(boton5);
		panelCenter.add(boton6);
		panelCenter.add(boton1);
		panelCenter.add(boton2);
		panelCenter.add(boton3);
		panelCenter.add(boton0);
		panelCenter.setBorder(new EmptyBorder(0,10,10,0));
		
		panelRight.add(botonSuma);
		panelRight.add(botonResta);
		panelRight.add(botonDivision);
		panelRight.add(botonMultiplica);
		panelRight.add(botonIgualdad);
		panelRight.setBorder(new EmptyBorder(0,0,10,10));

		container.add(panelTop, BorderLayout.NORTH);
		container.add(panelCenter,BorderLayout.CENTER);
		container.add(panelRight,BorderLayout.EAST);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void BotonACLimpiar() {
		txtVisorAuxiliar.setText("");
		txtVisorAuxiliar.requestFocusInWindow();
		txtVisorTotal.setText("");
		auxiliar1 = 0D; 
		auxiliar2 = 0D;
		total = 0D;
		operacion = "";
	}
	
	private void BtnNumeroClick(ActionEvent e) {
		String valor = txtVisorAuxiliar.getText();
		valor += e.getActionCommand();
		txtVisorAuxiliar.setText(valor);
	}
	
	private void BtnOperacionClick(ActionEvent e) {
		try {
			txtVisorTotal.setText("");
			
			String accion = e.getActionCommand(); 
			switch (accion) {
				case "+":
					operacion = "+";
					auxiliar1 = Double.parseDouble(txtVisorAuxiliar.getText());
					txtVisorAuxiliar.setText("");
					break;
				case "-":
					operacion = "-";
					auxiliar1 = Double.parseDouble(txtVisorAuxiliar.getText());
					txtVisorAuxiliar.setText("");
					break;					
				case "/":
					operacion = "/";
					auxiliar1 = Double.parseDouble(txtVisorAuxiliar.getText());
					txtVisorAuxiliar.setText("");
					break;
				case "*":
					operacion = "*";
					auxiliar1 = Double.parseDouble(txtVisorAuxiliar.getText());
					txtVisorAuxiliar.setText("");
					break;					
				case "=":
					auxiliar2 = Double.parseDouble(txtVisorAuxiliar.getText());
					
					if (operacion.equals("+")) {
						total = auxiliar1 + auxiliar2;
					} else if (operacion.equals("-")) {
						total = auxiliar1 - auxiliar2;
					} else if (operacion.equals("/")) {
						total = auxiliar1 / auxiliar2;
					} else if (operacion.equals("*")) {
						total = auxiliar1 * auxiliar2;
					} else {
						total = 0D;
					}
					
					txtVisorAuxiliar.setText(auxiliar1.toString() + " " + operacion + " " + auxiliar2.toString());
					txtVisorTotal.setText(total.toString());
					total = 0D;
					operacion = "";
					break;
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Operación no admitida.", "Error", JOptionPane.ERROR_MESSAGE);
			BotonACLimpiar();
		}			
	}
}
 