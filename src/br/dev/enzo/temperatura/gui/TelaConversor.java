package br.dev.enzo.temperatura.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.dev.enzo.temperatura.model.Temperatura;

public class TelaConversor {

	private JTextField textCelsius;
	private JLabel labelCelsius;
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
	
	
	public void criarTelaConversor() {
		
		JFrame tela = new JFrame();
		tela.setTitle("Conversor de Temperatura");
		tela.setSize(500, 300);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		
		Container container = tela.getContentPane();
		
		labelCelsius = new JLabel();
		labelCelsius.setBounds(20, 20, 200, 30);
		labelCelsius.setText("Temperatura em graus celsius: ");
		
		textCelsius = new JTextField();
		textCelsius.setBounds(20, 50, 450, 30);
		
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("Fahreinheit");
		buttonFahreinheit.setBounds(20, 90, 220, 30);
		
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(250, 90, 220, 30);
		
		labelResultado = new JLabel();
		labelResultado.setBounds(150, 130, 230, 40);
		//criando a fonte
		Font fonteResultado = labelResultado.getFont();
		//definindo a estilização e tamanho da fonte
		Font fonteNegrito = new Font(fonteResultado.getFontName(), Font.BOLD, 25);
		//atribuindo a fonte ao label resultado
		labelResultado.setFont(fonteNegrito);
		
		labelMensagemErro = new JLabel();
		labelMensagemErro.setBounds(170, 190, 200, 40);
		labelMensagemErro.setText("Tipo de entrada inválida");
		labelMensagemErro.setVisible(false);
		labelMensagemErro.setForeground(Color.red);
		

		container.add(textCelsius);
		container.add(labelCelsius);
		container.add(buttonFahreinheit);
		container.add(buttonKelvin);
		container.add(labelResultado);
		container.add(labelMensagemErro);
		
		buttonFahreinheit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//caso a casa decimal seja separada por "," será substituido por "."
					String grausCelsius = textCelsius.getText().replace("," , ".");
					
					Double CelsiusDouble = Double.parseDouble(grausCelsius);
					
					Temperatura temperatura = new Temperatura();
					temperatura.setCelsius(CelsiusDouble);
					
					Double resultado = temperatura.converterParaFahreinheit();
					
					labelResultado.setText(resultado + "Fahreinheit");
					
					labelMensagemErro.setVisible(false);
					
					//pegando a exceção que será mandada quando não for possível converter o valor da String grausCelsius para um valor numérico - CelsiusDouble.
				}catch(NumberFormatException exceção){
					
					labelMensagemErro.setVisible(true);
				}
				
				
				
				buttonKelvin.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							
							String grausCelsius = textCelsius.getText().replace("," , ".");
							
							Double CelsiusDouble = Double.parseDouble(grausCelsius);
							
							Temperatura temperatura = new Temperatura();
							temperatura.setCelsius(CelsiusDouble);
							
							Double resultado = temperatura.converterParaKelvin();
							
							labelResultado.setText(resultado + "Kelvin");
							
							labelMensagemErro.setVisible(false);
							
							
						}catch(NumberFormatException exceção){
							
							labelMensagemErro.setVisible(true);
						}
						
						
					}
				});
					
				
			}
		});
		
		tela.setVisible(true);
		
	}
	
}
