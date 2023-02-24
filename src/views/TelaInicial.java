package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TelaInicial {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
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
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Tela Inicial");
		frame.setBounds(400, 150, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 40, 430, 180);
		frame.getContentPane().add(panel);

		panel.setLayout(null);

		JLabel lblTitulo = new JLabel("SISTEMA DE CONVERSÃO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(75, 20, 300, 20);

		panel.add(lblTitulo);

		JLabel lblInfo1 = new JLabel("Funcionalidades disponiveis no menu acima.");

		lblInfo1.setBounds(25, 50, 350, 20);
		panel.add(lblInfo1);

		JPanel panelInterno = new JPanel();
		panelInterno.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelInterno.setBounds(20, 80, 260, 90);
		panel.add(panelInterno);
		panelInterno.setLayout(null);

		JLabel lblInfo3 = new JLabel("-> Conversor de moedas");
		lblInfo3.setBounds(10, 20, 250, 20);
		panelInterno.add(lblInfo3);

		JLabel lblInfo2 = new JLabel("-> Conversor de temperatura");
		lblInfo2.setBounds(10, 50, 250, 20);
		panelInterno.add(lblInfo2);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setSize(450, 20);
		menuBar.setLocation(0, 0);
		frame.getContentPane().add(menuBar);

		JMenu opcaoMenu = new JMenu("Opções");
		JMenu sobreMenu = new JMenu("Sobre");
		menuBar.add(opcaoMenu);
		menuBar.add(sobreMenu);
		JMenuItem telaConversorMoedaAction = new JMenuItem("CONVERSOR MOEDA");
		JMenuItem telaConversorTemperaturaAction = new JMenuItem("CONVERSOR TEMPERATURA");
		JMenuItem sairAction = new JMenuItem("Sair");

		JMenuItem ajudaAction = new JMenuItem("Informações");

		opcaoMenu.add(telaConversorMoedaAction);
		opcaoMenu.add(telaConversorTemperaturaAction);
		opcaoMenu.addSeparator();
		opcaoMenu.add(sairAction);

		sobreMenu.add(ajudaAction);

		JPanel panelRodape = new JPanel();
		panelRodape.setBounds(10, 225, 430, 30);
		frame.getContentPane().add(panelRodape);
		panelRodape.setLayout(null);

		JLabel lblRodaPe = new JLabel("© Marlon Magagnin - 2023");
		lblRodaPe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRodaPe.setBounds(10, 10, 184, 15);
		panelRodape.add(lblRodaPe);

		JLabel lblHora = new JLabel("");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setBounds(240, 10, 70, 15);
		panelRodape.add(lblHora);
		
		//pegando a hora do sistema 
		class hora implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar now = Calendar.getInstance();
				lblHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
			}
		};

		JLabel lblData = new JLabel("");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(320, 10, 100, 15);
		panelRodape.add(lblData);
		//pegando a data do sistema
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				Date dataSistema = new Date();
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				lblData.setText(formato.format(dataSistema));

				Timer timer = new Timer(1000, new hora());
				timer.start();

			}
		});

		telaConversorMoedaAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConversorMoedas tcm = new TelaConversorMoedas();
				tcm.ConversorMoedas();
			}
		});
		telaConversorTemperaturaAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConversorTemperatura tct = new TelaConversorTemperatura();
				tct.conversorTemperatura();
			}
		});

		ajudaAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sistema feito para atender os requisitos do desafio proposto \n "
						+ "para continuidade dos aprendizados e por em prática os mesmos. \n "
						+ "As informações dos valores de cotação são obtidas através de uma API disponivel \n"
						+ "gratuitamente. API Awesome dispõem dos dados atualizados a cada 30 segundos. \n "
						+ "Agradecimentos Oracle Next Education em parceria com alura.", "Informação", 0);
			}
		});

		sairAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
	}

	public static void sair() {
		if (JOptionPane.showConfirmDialog(null, "Deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "SAINDO DO SISTEMA!", "Informação", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

}
