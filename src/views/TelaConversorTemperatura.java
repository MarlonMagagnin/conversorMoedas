package views;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class TelaConversorTemperatura {

	private JFrame frame;
	private static JTextField textFieldTemperauraEntrada;
	private static JTextField textFieldTemperaturaConvertida;
	private static double temperaturaConvertida;
	private static double celsius;
	private static double fahrenheit;
	private static double kelvin;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void conversorTemperatura() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConversorTemperatura window = new TelaConversorTemperatura();
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
	public TelaConversorTemperatura() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Conversor de temperatura");
		frame.setBounds(400, 150, 450, 350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 20, 430, 120);
		frame.getContentPane().add(panel);

		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(10, 50, 250, 24);
		comboBox.addItem("ESCOLHA ABAIXO");
		comboBox.addItem("Celsius -> Fahrenheit");
		comboBox.addItem("Celsius -> Kelvin");
		comboBox.addItem("Fahrenheit -> Celsius");
		comboBox.addItem("Fahrenheit -> Kelvin");
		comboBox.addItem("Kelvin -> Fahrenheit");
		comboBox.addItem("Kelvin -> Celsius");
		panel.setLayout(null);
		panel.add(comboBox);

		JLabel lblTemperaturaEntrada = new JLabel("Digite a temperatura:");
		lblTemperaturaEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperaturaEntrada.setBounds(12, 15, 160, 20);
		panel.add(lblTemperaturaEntrada);

		textFieldTemperauraEntrada = new JTextField();
		textFieldTemperauraEntrada.setBounds(200, 15, 100, 20);
		panel.add(textFieldTemperauraEntrada);
		textFieldTemperauraEntrada.setColumns(10);

		JLabel lblTemperaturaConverter = new JLabel("Temperatura convertida");
		lblTemperaturaConverter.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemperaturaConverter.setBounds(12, 88, 180, 20);
		panel.add(lblTemperaturaConverter);

		textFieldTemperaturaConvertida = new JTextField();
		textFieldTemperaturaConvertida.setBounds(200, 88, 100, 20);
		panel.add(textFieldTemperaturaConvertida);
		textFieldTemperaturaConvertida.setColumns(10);
		textFieldTemperaturaConvertida.setEditable(false);

		JButton btnConverter = new JButton("Converter");
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldTemperauraEntrada.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo temperatura vazio.");
				} else {
					if (comboBox.getSelectedItem().equals("Celsius -> Fahrenheit")) {
						converterTipo();
						celsiusFahrenheit();
					}
					if (comboBox.getSelectedItem().equals("Celsius -> Kelvin")) {
						converterTipo();
						celsiusKelvin();
					}
					if (comboBox.getSelectedItem().equals("Fahrenheit -> Celsius")) {
						converterTipo();
						fahrenheitCelsius();
					}
					if (comboBox.getSelectedItem().equals("Fahrenheit -> Kelvin")) {
						converterTipo();
						fahrenheitKelvin();
					}
					if (comboBox.getSelectedItem().equals("Kelvin -> Celsius")) {
						converterTipo();
						kelvinCelcius();
					}
					if (comboBox.getSelectedItem().equals("Kelvin -> Fahrenheit")) {
						converterTipo();
						kelvinFahrenheit();
					}
				}
			}
		});
		btnConverter.setBounds(280, 50, 117, 25);
		panel.add(btnConverter);
		
		JPanel panelTabela = new JPanel();
		panelTabela.setLayout(new GridLayout(1,1));
		panelTabela.setBounds(10, 170, 430, 120);
		frame.getContentPane().add(panelTabela);
	
		
		String[] colunas = {"DE -> PARA ", "FÓRMULA"};
		Object[][] dados =  {
				{"Kelvin -> Celsius", "C = K - 273" },
				{"Kelvin -> Fahrenheit", "F = (K-273) x 1.8 + 32"},
				{"Celsius -> Kelvin", "K = C + 273"},
				{"Celsius -> Fahrenheit","F = C x 1.8 + 32"},
				{"Fahrenheit -> Celsius", "C = (F-32) / 1.8"},
				{"Fahrenheit -> Kelvin", "K = (F-32) x 5/9 + 273"}
				};
		JTable table = new JTable(dados,colunas);
		
		JScrollPane barra = new JScrollPane(table);
		panelTabela.add(barra);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 145, 430, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblinfo = new JLabel("Fórmulas usadas para a conversão das temperaturas");
		lblinfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblinfo.setBounds(12, 150, 400, 15);
		frame.getContentPane().add(lblinfo);
		
	}

	// convertendo tipo string para tipo double
	public static void converterTipo() {
		String valor = textFieldTemperauraEntrada.getText();
		temperaturaConvertida = Double.parseDouble(valor);
	}

	public static void celsiusFahrenheit() {
		fahrenheit = ((temperaturaConvertida * 1.8) + 32);
		textFieldTemperaturaConvertida.setText(String.valueOf(new DecimalFormat("0.### (F)").format(fahrenheit)));
	}
	
	public static void celsiusKelvin() {
		kelvin = temperaturaConvertida + 273;
		textFieldTemperaturaConvertida.setText(String.valueOf(new DecimalFormat("0.### (K)").format(kelvin)));
	}
	
	private static void fahrenheitCelsius() {
		celsius = ((temperaturaConvertida - 32) / 1.8);
		textFieldTemperaturaConvertida.setText(String.valueOf(new DecimalFormat("0.### (C)").format(celsius)));
	}
	
	private static void fahrenheitKelvin() {
		kelvin = ((temperaturaConvertida - 32) * 5/9 + 273);
		textFieldTemperaturaConvertida.setText(String.valueOf(new DecimalFormat("0.### (K)").format(kelvin)));
	}
	
	public static void kelvinCelcius() {
		celsius = temperaturaConvertida - 273;
		textFieldTemperaturaConvertida.setText(String.valueOf(new DecimalFormat("0.### (C)").format(celsius)));
	}
	
	public static void kelvinFahrenheit() {
		fahrenheit = ((temperaturaConvertida - 273) * 1.8 + 32);
		textFieldTemperaturaConvertida.setText(String.valueOf(new DecimalFormat("0.### (F)").format(fahrenheit)));
	}
}
