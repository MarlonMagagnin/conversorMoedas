package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ConsumirAPI;
import controller.Moedas;
import controller.MoedasController;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class TelaConversorMoedas {

	private JFrame frame;

	private static JTextField textFieldValorReal;
	private static double valorAConverter;
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
		comboBox.setBounds(180, 40, 150, 20);
		comboBox.addItem("ESCOLHA ABAIXO");
		comboBox.addItem("REAL");
		comboBox.addItem("DOLAR");
		comboBox.addItem("EURO");
		comboBox.addItem("LIBRAS ESTERLINAS");
		comboBox.addItem("PESO ARGENTINO");
		comboBox.addItem("PESO CHILENO");

		JComboBox<String> comboBox2 = new JComboBox<>();
		comboBox2.setBounds(370, 40, 150, 20);
		comboBox2.addItem("ESCOLHA ABAIXO");
		comboBox2.addItem("REAL");
		comboBox2.addItem("DOLAR");
		comboBox2.addItem("EURO");
		comboBox2.addItem("LIBRAS ESTERLINAS");
		comboBox2.addItem("PESO ARGENTINO");
		comboBox2.addItem("PESO CHILENO");

		panel.add(comboBox);
		panel.add(comboBox2);
		
		JButton btnConverter = new JButton("Converter");
		btnConverter.setBounds(275, 70, 150, 20);
		panel.add(btnConverter);

		JLabel lblConverter = new JLabel("Escolha a conversão:");
		lblConverter.setBounds(20, 40, 150, 20);
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

		JLabel lblTroca = new JLabel("--->");
		lblTroca.setHorizontalAlignment(SwingConstants.CENTER);
		lblTroca.setBounds(335, 40, 30, 20);
		panel.add(lblTroca);
		
		JLabel lblInfomais = new JLabel("* O cálculo efetuado tem caráter informativo!");
		lblInfomais.setBounds(20, 200, 350, 20);
		panel.add(lblInfomais);

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
						converterTipo();
						if (comboBox.getSelectedItem().equals("REAL") && comboBox2.getSelectedItem().equals("DOLAR")) {
							MoedasController.realDolar();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("REAL") && comboBox2.getSelectedItem().equals("EURO")) {
							MoedasController.realEuro();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("REAL")
								&& comboBox2.getSelectedItem().equals("LIBRAS ESTERLINAS")) {
							MoedasController.realLibrasEsterlinas();
							exibirCotação();
							exibirResultado();

						}
						if (comboBox.getSelectedItem().equals("REAL")
								&& comboBox2.getSelectedItem().equals("PESO ARGENTINO")) {
							MoedasController.realPesoArgentino();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("REAL")
								&& comboBox2.getSelectedItem().equals("PESO CHILENO")) {
							MoedasController.realPesoChileno();
							exibirCotação();
							exibirResultado();
						}

						if (comboBox.getSelectedItem().equals("DOLAR") && comboBox2.getSelectedItem().equals("REAL")) {
							MoedasController.dolarReal();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("DOLAR")
								&& comboBox2.getSelectedItem().equals("LIBRAS ESTERLINAS")) {
							MoedasController.dolarLibrasEsterlinas();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("DOLAR") && comboBox2.getSelectedItem().equals("EURO")) {
							MoedasController.dolarEuro();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("DOLAR")
								&& comboBox2.getSelectedItem().equals("PESO ARGETNINO")) {
							MoedasController.dolarPesoArgentino();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("DOLAR")
								&& comboBox2.getSelectedItem().equals("PESO CHILENO")) {
							MoedasController.dolarPesoChileno();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("EURO") && comboBox2.getSelectedItem().equals("REAL")) {
							MoedasController.euroReal();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("EURO") && comboBox2.getSelectedItem().equals("DOLAR")) {
							MoedasController.euroDolar();
							exibirCotação();
							exibirResultado();

						}
						if (comboBox.getSelectedItem().equals("EURO")
								&& comboBox2.getSelectedItem().equals("LIBRAS ESTERLINAS")) {
							MoedasController.euroLibrasEsterlinas();
							exibirCotação();
							exibirResultado();

						}
						if (comboBox.getSelectedItem().equals("EURO")
								&& comboBox2.getSelectedItem().equals("PESO ARGENTINO")) {
							MoedasController.euroPesoArgentino();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("EURO")
								&& comboBox2.getSelectedItem().equals("PESO CHILENO")) {
							MoedasController.euroPesoChileno();
							exibirCotação();
							exibirResultado();

						}
						if (comboBox.getSelectedItem().equals("LIBRAS ESTERLINAS")
								&& comboBox2.getSelectedItem().equals("REAL")) {
							MoedasController.librasEsterlinasReal();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("LIBRAS ESTERLINAS")
								&& comboBox2.getSelectedItem().equals("DOLAR")) {
							MoedasController.librasEsterlinasDolar();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("LIBRAS ESTERLINAS")
								&& comboBox2.getSelectedItem().equals("EURO")) {
							MoedasController.librasEsterlinasEuro();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("LIBRAS ESTERLINAS")
								&& comboBox2.getSelectedItem().equals("PESO ARGENTINO")) {
							MoedasController.librasEsterlinasPesoArgentino();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("LIBRAS ESTERLINAS")
								&& comboBox2.getSelectedItem().equals("PESO CHILENO")) {
							MoedasController.librasEsterlinasPesoChileno();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("PESO ARGENTINO")
								&& comboBox2.getSelectedItem().equals("REAL")) {
							MoedasController.pesoArgentinoReal();
							exibirCotação();
							exibirResultado();

						}
						if (comboBox.getSelectedItem().equals("PESO ARGENTINO")
								&& comboBox2.getSelectedItem().equals("DOLAR")) {
							MoedasController.pesoArgentinoDolar();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("PESO ARGENTINO")
								&& comboBox2.getSelectedItem().equals("EURO")) {
							MoedasController.pesoArgentinoEuro();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("PESO ARGENTINO")
								&& comboBox2.getSelectedItem().equals("LIBRAS ESTERLINAS")) {
							MoedasController.pesoArgentinolibrasEsterlinas();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("PESO ARGENTINO")
								&& comboBox2.getSelectedItem().equals("PESO CHILENO")) {
							MoedasController.pesoArgentinoPesoChileno();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("PESO CHILENO")
								&& comboBox2.getSelectedItem().equals("REAL")) {
							MoedasController.pesoChilenoReal();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("PESO CHILENO")
								&& comboBox2.getSelectedItem().equals("DOLAR")) {
							MoedasController.pesoChilenoDolar();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("PESO CHILENO")
								&& comboBox2.getSelectedItem().equals("EURO")) {
							MoedasController.pesoChilenoEuro();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("PESO CHILENO")
								&& comboBox2.getSelectedItem().equals("LIBRAS ESTERLINAS")) {
							MoedasController.pesoChilenolibrasEsterlinas();
							exibirCotação();
							exibirResultado();
						}
						if (comboBox.getSelectedItem().equals("PESO CHILENO")
								&& comboBox2.getSelectedItem().equals("PESO ARGENTINO")) {
							MoedasController.pesoChilenoPesoArgentino();
							exibirCotação();
							exibirResultado();
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

	// convertendo tipo string para tipo double
	public static void converterTipo() {
		String valor = textFieldValorReal.getText();
		valorAConverter = Double.parseDouble(valor);
	}

	// metodo voltar para tela inicial.
	public void sair() {
			frame.dispose();
	}

	public static void exibirCotação() {
		textFieldValorAtualCotacao.setText(MoedasController.getCotacaoResultado());
	}

	public static void exibirResultado() {
		textFieldValorConvertido.setText(MoedasController.getResultado());

	}

	public static void setValorAConverter(double valorAConverter) {
		TelaConversorMoedas.valorAConverter = valorAConverter;
	}

	public static double getValorAConverter() {
		return valorAConverter;
	}
}
