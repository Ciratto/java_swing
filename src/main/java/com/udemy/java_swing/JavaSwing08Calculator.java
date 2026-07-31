package com.udemy.java_swing;

//Abstract Window Toolkit, antiguo componentes pesados dependientes del Sistema operativo.
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Swing mas moderno, componentes livianos dibujados por java.
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JavaSwing08Calculator extends JFrame{
	JTextField numeroA;
	JTextField numeroB;
	JTextField result;
	
	private static final String SUMA = "Suma";
	private static final String RESTA = "Resta";
	private static final String DIVIDE = "División";
	private static final String MUTIPLI = "Multiplicación";
	private static final String EXIT = "Salir";
	
	//Contruyo ventana.
	private JavaSwing08Calculator() {
		super("Ejemplo Calculadora");
		
		//Construyo menu
		JMenuBar menuBar = new JMenuBar();	 
		JMenu menuOperaciones = new JMenu("Operaciones");
		JMenu menuExit = new JMenu("Exit");
		JMenuItem itemAdd = new JMenuItem(SUMA);
		JMenuItem itemSub = new JMenuItem(RESTA);
		JMenuItem itemDiv = new JMenuItem(DIVIDE);
		JMenuItem itemMulti = new JMenuItem(MUTIPLI);
		JMenuItem itemClose = new JMenuItem(EXIT);

		menuBar.add(menuOperaciones);
		menuBar.add(menuExit);
		
		menuOperaciones.add(itemAdd);
		menuOperaciones.add(itemSub);
		menuOperaciones.add(itemDiv);
		menuOperaciones.add(itemMulti);
		menuOperaciones.add(itemClose);
		menuExit.add(itemClose);
		
		//Panel Centro------------------------------
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new FlowLayout()); //Que los componentes interiores esten alineados uno al lado del otro
		panelCentro.add(new JLabel("Numero 1"));
		panelCentro.add(numeroA = new JTextField(3));
		panelCentro.add(new JLabel("Numero 2"));
		panelCentro.add(numeroB = new JTextField(3));
		panelCentro.add(new JLabel("Resultado"));
		panelCentro.add(result = new JTextField(20));
		
		//Contenedor principal.------------------------
		Container container = getContentPane(); 	
		container.setLayout(new BorderLayout()); //Que los componente sinteriores se sectoricen por norte, sur, este, oeste, y centro
		container.add(panelCentro, BorderLayout.CENTER); //Que el panel central justamente este en el centro.

		//Listeners
		itemAdd.addActionListener(new btnClickActionListener());
		itemSub.addActionListener(new btnClickActionListener());
		itemDiv.addActionListener(new btnClickActionListener());
		itemMulti.addActionListener(new btnClickActionListener());
		itemClose.addActionListener(new btnClickActionListener());
		
		numeroA.setHorizontalAlignment(JTextField.CENTER);
		numeroB.setHorizontalAlignment(JTextField.CENTER);
		result.setHorizontalAlignment(JTextField.CENTER);
		result.setEditable(false);
		
		setJMenuBar(menuBar);
		setLocationRelativeTo(null);
		setSize(600,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	};
	
	private class btnClickActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String operacion = e.getActionCommand();
				if (operacion.equals(EXIT)){
					dispose();
				}
				
				Double numA = Double.parseDouble(numeroA.getText().trim());
				Double numB = Double.parseDouble(numeroB.getText().trim());
				
				switch (operacion) {
					case SUMA:
						result.setText(String.valueOf(numA + numB));
						break;
					case RESTA:
						result.setText(String.valueOf(numA - numB));
						break;
					case DIVIDE:
						result.setText(String.valueOf(numA / numB));
						break;
					case MUTIPLI:
						result.setText(String.valueOf(numA * numB));
						break;						
					default:
						result.setText("0");
						break;	
				}			
			} catch(NumberFormatException nex) {
				result.setText("Err Format Number");
			} catch(ArithmeticException aex) {
				result.setText("Err Operación");
			} catch(Exception ex) {
				result.setText("Err");
			}
		}
	}
	
	//Abro pantalla
	public static void main(String[] args) {
		new JavaSwing08Calculator();
	}
}
