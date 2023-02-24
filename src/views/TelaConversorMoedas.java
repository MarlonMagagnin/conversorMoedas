package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ConsumirAPI;
import controller.Moedas;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JSeparator;


public class TelaConversorMoedas {

	private JFrame frame;

	private static JTextField textFieldValorReal;
	private static double valorAConverter;
	private static double valorConvertido;
	private static JTextField textFieldValorConvertido;
	private static JTextField textFieldValorAtualCotacao;

	/**
	 * Launch the application.
	 */
	public static void ConversorMoedas() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConversorMoedas window = new TelaConversorMoedas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaConversorMoedas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Tela Conversor");
		frame.setBounds(400, 150, 550, 275);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 12, 550, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblValorEmReais = new JLabel("Digite o valor que deseja converter:");
		lblValorEmReais.setBounds(20, 10, 300, 20);
		panel.add(lblValorEmReais);
		textFieldValorReal = new JTextField();
		textFieldValorReal.setBounds(330, 10, 80, 20);
		textFieldValorReal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				textFieldValorReal.setText(textFieldValorReal.getText().replaceAll("[^0-9 | ^.]", ""));
			}
		});

		panel.add(textFieldValorReal);
		textFieldValorReal.setColumns(10);

		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(330, 40, 200, 20);
		comboBox.addItem("ESCOLHA ABAIXO");
		comboBox.addItem("REAL -> DOLAR");
		comboBox.addItem("REAL -> EURO");
		comboBox.addItem("REAL -> LIBRAS ESTERLINAS");
		comboBox.addItem("REAL -> PESO ARGENTINO");
		comboBox.addItem("REAL -> PESO CHILENO");
		comboBox.addItem("DOLAR -> REAL");
		comboBox.addItem("EURO -> REAL");
		comboBox.addItem("LIBRAS ESTERLINAS -> REAL");
		comboBox.addItem("PESO ARGENTINO -> REAL");
		comboBox.addItem("PESO CHILENO -> REAL");
		
		panel.add(comboBox);

		JButton btnConverter = new JButton("Converter");
		btnConverter.setBounds(200, 70, 150, 20);
		panel.add(btnConverter);

		JLabel lblConverter = new JLabel("Digite para qual moeda deseja converter:");
		lblConverter.setBounds(20, 40, 300, 20);
		panel.add(lblConverter);

		JLabel lblValorvalorConvertido = new JLabel("Valor valorConvertido:");
		lblValorvalorConvertido.setBounds(20, 175, 200, 20);
		panel.add(lblValorvalorConvertido);

		textFieldValorConvertido = new JTextField();
		textFieldValorConvertido.setBounds(200, 175, 150, 20);
		panel.add(textFieldValorConvertido);
		textFieldValorConvertido.setColumns(10);
		textFieldValorConvertido.setEditable(false);
		
		JLabel lblValorAtualCotacao = new JLabel("Valor atual da cotação:");
		lblValorAtualCotacao.setBounds(20, 140, 200, 20);
		panel.add(lblValorAtualCotacao);
		
		textFieldValorAtualCotacao = new JTextField();
		textFieldValorAtualCotacao.setBounds(200, 140, 150, 20);
		panel.add(textFieldValorAtualCotacao);
		textFieldValorAtualCotacao.setColumns(10);
		textFieldValorAtualCotacao.setEditable(false);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 120, 490, 5);
		panel.add(separator);
		
		JLabel informacao = new JLabel("Valores para conversão obtidos através da API externa AwesomeAPI");
		informacao.setBounds(25, 100, 500, 20);
		panel.add(informacao);
		
		JButton btnSair = new JButton("Voltar");
		btnSair.setBounds(400, 175, 100, 20);
		panel.add(btnSair);
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		

		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (textFieldValorReal.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "O campo está vazio");
					} else {
						ConsumirAPI.cotacao();
						if (comboBox.getSelectedItem().equals("REAL -> DOLAR")) {
							realDolar();
						}
						if (comboBox.getSelectedItem().equals("REAL -> EURO")) {
							realEuro();
						}
						if (comboBox.getSelectedItem().equals("REAL -> LIBRAS ESTERLINAS")) {
							realLibrasEsterlinas();
						}
						if (comboBox.getSelectedItem().equals("REAL -> PESO ARGENTINO")) {
							realPesoArgentino();
						}
						if (comboBox.getSelectedItem().equals("REAL -> PESO CHILENO")) {
							realPesoChileno();
						}
						if (comboBox.getSelectedItem().equals("DOLAR -> REAL")) {
							dolarReal();
						}
						if (comboBox.getSelectedItem().equals("EURO -> REAL")) {
							euroReal();
						}
						if (comboBox.getSelectedItem().equals("LIBRAS ESTERLINAS -> REAL")) {
							librasEsterlinasReal();
						}
						if (comboBox.getSelectedItem().equals("PESO ARGENTINO -> REAL")) {
							pesoArgentinoReal();
						}
						if (comboBox.getSelectedItem().equals("PESO CHILENO -> REAL")) {
							pesoChilenoReal();
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
		});
	}
	//convertendo tipo string para tipo double
	public static void converterTipo() {
		String valor = textFieldValorReal.getText();
		valorAConverter = Double.parseDouble(valor);
	}
	//métodos para a conversão dos valores das moedas.
	public static void realDolar() {
		converterTipo();
		valorConvertido = valorAConverter / Moedas.getDolar();
		textFieldValorConvertido.setText(String.valueOf(new DecimalFormat("$ 0.###").format(valorConvertido)));
		textFieldValorAtualCotacao.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getDolar())));
	}
	
	public static void dolarReal() {
		converterTipo();
		valorConvertido = valorAConverter * Moedas.getDolar();
		textFieldValorConvertido.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(valorConvertido)));
		textFieldValorAtualCotacao.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getDolar())));
	}

	public static void realEuro() {
		converterTipo();
		valorConvertido = valorAConverter / Moedas.getEuro();
		textFieldValorConvertido.setText(String.valueOf(new DecimalFormat("€ 0.###").format(valorConvertido)));
		textFieldValorAtualCotacao.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getEuro())));
	}
	
	public static void euroReal() {
		converterTipo();
		valorConvertido = valorAConverter * Moedas.getEuro();
		textFieldValorConvertido.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(valorConvertido)));
		textFieldValorAtualCotacao.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getEuro())));
	}

	public static void realLibrasEsterlinas() {
		converterTipo();
		valorConvertido = valorAConverter / Moedas.getLibrasEsterlinas();
		textFieldValorConvertido.setText(String.valueOf(new DecimalFormat("£ 0.###").format(valorConvertido)));
		textFieldValorAtualCotacao.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getLibrasEsterlinas())));
	}
	
	public static void librasEsterlinasReal() {
		converterTipo();
		valorConvertido = valorAConverter * Moedas.getLibrasEsterlinas();
		textFieldValorConvertido.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(valorConvertido)));
		textFieldValorAtualCotacao.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getLibrasEsterlinas())));
	}

	public static void realPesoArgentino() {
		converterTipo();
		valorConvertido = valorAConverter / Moedas.getPesoArgentino();
		textFieldValorConvertido.setText(String.valueOf(new DecimalFormat("$ 0.###").format(valorConvertido)));
		textFieldValorAtualCotacao.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getPesoArgentino())));
	}
	
	public static void pesoArgentinoReal() {
		converterTipo();
		valorConvertido = valorAConverter * Moedas.getPesoArgentino();
		textFieldValorConvertido.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(valorConvertido)));
		textFieldValorAtualCotacao.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getPesoArgentino())));
	}

	public static void realPesoChileno() {
		converterTipo();
		valorConvertido = valorAConverter / Moedas.getPesoChileno();
		textFieldValorConvertido.setText(String.valueOf(new DecimalFormat("$ 0.###").format(valorConvertido)));
		textFieldValorAtualCotacao.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getPesoArgentino())));
	}
	
	public static void pesoChilenoReal() {
		converterTipo();
		valorConvertido = valorAConverter * Moedas.getPesoChileno();
		textFieldValorConvertido.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(valorConvertido)));
		textFieldValorAtualCotacao.setText(String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getPesoArgentino())));
	}
	//metodo voltar para tela inicial.
	public void sair() {
		if (JOptionPane.showConfirmDialog(null, "Voltar a tela inicial?", "Atenção", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Voltando a tela innicial", "Informação", 
					JOptionPane.INFORMATION_MESSAGE
					);
			frame.dispose();
		}
	}
}
