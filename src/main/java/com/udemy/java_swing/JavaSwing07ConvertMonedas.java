package com.udemy.java_swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JavaSwing07ConvertMonedas extends JFrame {
	
	private static final String MONEDA_DOLAR = "Dolar";
	private static final String MONEDA_EURO = "Euro";
	private JTextField txtMonto = new JTextField(10);
	
	private Container contenedor = getContentPane();
	
	public static void main(String[] args) {
		new JavaSwing07ConvertMonedas();
	}
	
	private JavaSwing07ConvertMonedas( ) throws HeadlessException {
		setTitle("Ejemplo convertidor de monedas.");
		

		JButton btnEuro = new JButton(MONEDA_EURO);
		JButton btnDolar = new JButton(MONEDA_DOLAR);
		JButton btnReset =  new JButton("Resetear");
		
		btnEuro.addActionListener(new BtnClickListener());
		btnDolar.addActionListener(new BtnClickListener());
		btnReset.addActionListener(new BtnClickListener());
		txtMonto.setText("0");
		txtMonto.setHorizontalAlignment(JTextField.CENTER);
		
		contenedor.add(txtMonto);
		contenedor.add(btnEuro);
		contenedor.add(btnDolar);
		contenedor.add(btnReset);
		contenedor.setLayout(new FlowLayout());
		contenedor.setBackground(Color.GRAY);
		
		repaint();
		setLocationRelativeTo(null);
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class BtnClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (txtMonto.getText() == null || txtMonto.getText().trim().isEmpty()) {
				    return;
				}
				
				float monto = Float.parseFloat(txtMonto.getText());
				String tipoBoton = e.getActionCommand();
				
				switch (tipoBoton) {
					case MONEDA_EURO:
						monto = (monto/1.29f);
						contenedor.setBackground(Color.BLUE);
						break;
					case MONEDA_DOLAR:
						monto = (monto/1.29f);
						contenedor.setBackground(Color.GREEN);
						break;
					default:
						monto = 0;
						contenedor.setBackground(Color.GRAY);
						break;
				}
				
				txtMonto.setText(String.valueOf(monto));
				repaint();
			} catch (NumberFormatException ex) {
	            System.out.println("El valor ingresado no es un número válido.");
	            return;
	        } catch (Exception ex) {
	        	System.out.println("Se produjo un eror desconocido. Comuníquese con sistemas.");
	            return;
	        }
		}	
	}
}
