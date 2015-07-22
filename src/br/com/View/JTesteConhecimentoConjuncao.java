package br.com.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.swing.SwingConstants;

import br.com.Bin.Conjuncao;
import br.com.Bin.Desempenho;
import br.com.Persistencia.Banco;

import javax.swing.JRadioButton;

public class JTesteConhecimentoConjuncao extends JFrame implements
		ActionListener {

	private JPanel contentPane;
	private JTextField txtPalavra;
	private JButton btnPular;
	private JButton btnResponder;
	private JButton btnIniciar;
	private JButton btnVoltar;
	private int tempo;
	private JLabel lblTempo;
	private ArrayList<Conjuncao> listaConjuncaos = new ArrayList<Conjuncao>();
	private Banco banco = new Banco();
	private ButtonGroup grupoBotoes;
	private int posicaoAtual = 0;
	private JProgressBar progressBar;
	private JRadioButton radioCoordenativaAditiva;
	private JRadioButton radioCoordenativaAdversativa;
	private JRadioButton radioCoordenativaAlternativa;
	private JRadioButton radioCoordenativaExplicativa;
	private JRadioButton radioCoordenativaConclusiva;
	private JRadioButton radioSubordinativaTemporal;
	private JRadioButton radioSubordinativaCasual;
	private JRadioButton radioSubordinativaCondicional;
	private JRadioButton radioSubordinativaProporcional;
	private JRadioButton radioSubordinativaFinal;
	private JRadioButton radioSubordinativaConsecutiva;
	private JRadioButton radioSubordinativaConcessiva;
	private JRadioButton radioSubordinativaComparativa;
	private JRadioButton radioSubordinativaConformidade;
	private JRadioButton radioSubordinativaIntegrante;
	
	private int ponto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTesteConhecimentoConjuncao frame = new JTesteConhecimentoConjuncao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JTesteConhecimentoConjuncao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 500);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panelTime = new JPanel();
		panelTime.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTime.setBounds(10, 10, 760, 55);
		panel.add(panelTime);
		panelTime.setLayout(null);

		JLabel lblTesteDeConhecimento = new JLabel("Teste de conhecimento");
		lblTesteDeConhecimento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTesteDeConhecimento.setBounds(15, 15, 300, 25);
		panelTime.add(lblTesteDeConhecimento);

		lblTempo = new JLabel("0");
		lblTempo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTempo.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
		lblTempo.setBounds(589, 15, 161, 25);
		panelTime.add(lblTempo);

		JPanel panelProgressao = new JPanel();
		panelProgressao.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelProgressao.setBounds(10, 75, 760, 80);
		panel.add(panelProgressao);
		panelProgressao.setLayout(null);

		JLabel lblIdentificarEClassificar = new JLabel(
				"Identificar e Classificar");
		lblIdentificarEClassificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdentificarEClassificar.setBounds(10, 10, 245, 25);
		panelProgressao.add(lblIdentificarEClassificar);

		txtPalavra = new JTextField();
		txtPalavra.setForeground(new Color(47, 79, 79));
		txtPalavra.setEditable(false);
		txtPalavra
				.setText("Aqui ira aparecer as senten\u00E7as em que voc\u00EA ira julgar de acordo com as op\u00E7\u00F5es abaixo!");
		txtPalavra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPalavra.setHorizontalAlignment(SwingConstants.CENTER);
		txtPalavra.setBounds(10, 40, 741, 30);
		panelProgressao.add(txtPalavra);
		txtPalavra.setColumns(10);

		progressBar = new JProgressBar();
		progressBar.setBounds(238, 12, 513, 23);
		progressBar.setValue(0);
		panelProgressao.add(progressBar);

		JPanel panelResposta = new JPanel();
		panelResposta.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelResposta.setBounds(10, 165, 760, 220);

		panel.add(panelResposta);
		panelResposta.setLayout(null);

//		JLabel lblAlternativasPodemSer = new JLabel(
//				"Alternativas podem ser multipla escolha");
//		lblAlternativasPodemSer.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblAlternativasPodemSer.setBounds(10, 10, 335, 25);
//		panelResposta.add(lblAlternativasPodemSer);
		
		grupoBotoes = new ButtonGroup();
		//panelResposta.add(grupoBotoes);

		radioCoordenativaAditiva = new JRadioButton("Coordenativa Aditiva");
		radioCoordenativaAditiva.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioCoordenativaAditiva.setBounds(5, 50, 185, 25);
		panelResposta.add(radioCoordenativaAditiva);
		

		radioCoordenativaAdversativa = new JRadioButton(
				"Coordenativa Adversativa");
		radioCoordenativaAdversativa
				.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioCoordenativaAdversativa.setBounds(5, 90, 185, 25);
		panelResposta.add(radioCoordenativaAdversativa);

		radioCoordenativaAlternativa = new JRadioButton(
				"Coordenativa Alternativa ");
		radioCoordenativaAlternativa.setBounds(5, 130, 185, 25);
		panelResposta.add(radioCoordenativaAlternativa);

		radioCoordenativaExplicativa = new JRadioButton(
				"Coordenativa Explicativa");
		radioCoordenativaExplicativa
				.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioCoordenativaExplicativa.setBounds(5, 165, 185, 25);
		panelResposta.add(radioCoordenativaExplicativa);

		radioCoordenativaConclusiva = new JRadioButton("Coordenativa Conclusiva");
		radioCoordenativaConclusiva.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioCoordenativaConclusiva.setBounds(190, 50, 185, 25);
		panelResposta.add(radioCoordenativaConclusiva);

		radioSubordinativaTemporal = new JRadioButton("Subordinativa Temporal");
		radioSubordinativaTemporal.setBounds(190, 90, 185, 25);
		panelResposta.add(radioSubordinativaTemporal);

		radioSubordinativaCasual = new JRadioButton("Subordinativa Casual");
		radioSubordinativaCasual.setBounds(190, 130, 185, 25);
		panelResposta.add(radioSubordinativaCasual);

		radioSubordinativaCondicional = new JRadioButton(
				"Subordinativa Condicional");
		radioSubordinativaCondicional.setBounds(190, 165, 185, 25);
		panelResposta.add(radioSubordinativaCondicional);

		radioSubordinativaProporcional = new JRadioButton(
				"Subordinativa Proporcional");
		radioSubordinativaProporcional.setBounds(380, 50, 185, 25);
		panelResposta.add(radioSubordinativaProporcional);

		radioSubordinativaFinal = new JRadioButton("Subordinativa Final");
		radioSubordinativaFinal.setBounds(380, 90, 185, 25);
		panelResposta.add(radioSubordinativaFinal);

		radioSubordinativaConsecutiva = new JRadioButton(
				"Subordinativa Consecutiva ");
		radioSubordinativaConsecutiva
				.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioSubordinativaConsecutiva.setBounds(380, 130, 185, 25);
		panelResposta.add(radioSubordinativaConsecutiva);

		radioSubordinativaConcessiva = new JRadioButton(
				"Subordinativa Concessiva");
		radioSubordinativaConcessiva.setBounds(380, 165, 185, 25);
		panelResposta.add(radioSubordinativaConcessiva);

		radioSubordinativaComparativa = new JRadioButton(
				"Subordinativa Comparativa ");
		radioSubordinativaComparativa.setBounds(565, 50, 185, 25);
		panelResposta.add(radioSubordinativaComparativa);

		radioSubordinativaConformidade = new JRadioButton(
				"Subordinativa Conformidade");
		radioSubordinativaConformidade.setBounds(565, 90, 185, 25);
		panelResposta.add(radioSubordinativaConformidade);

		radioSubordinativaIntegrante = new JRadioButton(
				"Subordinativa Integrante");
		radioSubordinativaIntegrante.setBounds(565, 130, 185, 25);
		panelResposta.add(radioSubordinativaIntegrante);

		btnPular = new JButton("Pular");
		btnPular.setEnabled(false);
		btnPular.setBounds(583, 396, 89, 23);
		panel.add(btnPular);

		btnResponder = new JButton("Responder");
		btnResponder.setEnabled(false);
		btnResponder.setBounds(682, 396, 89, 23);
		panel.add(btnResponder);

		btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(484, 396, 89, 23);
		panel.add(btnIniciar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(385, 396, 89, 23);
		panel.add(btnVoltar);
		
//		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
//		rdbtnNewRadioButton.setBounds(21, 429, 109, 23);
//		panel.add(rdbtnNewRadioButton);

		btnPular.addActionListener(this);
		btnResponder.addActionListener(this);
		btnIniciar.addActionListener(this);
		btnVoltar.addActionListener(this);

		enableCheque(false);
		
		grupoBotoes.add(radioSubordinativaCasual);
		grupoBotoes.add(radioCoordenativaAdversativa);
		grupoBotoes.add(radioCoordenativaAlternativa);
		grupoBotoes.add(radioCoordenativaConclusiva);
		grupoBotoes.add(radioCoordenativaExplicativa);
		grupoBotoes.add(radioSubordinativaCasual);
		grupoBotoes.add(radioSubordinativaComparativa);
		grupoBotoes.add(radioSubordinativaConcessiva);
		grupoBotoes.add(radioSubordinativaCondicional);
		grupoBotoes.add(radioSubordinativaConformidade);
		grupoBotoes.add(radioSubordinativaConsecutiva);
		grupoBotoes.add(radioSubordinativaFinal);
		grupoBotoes.add(radioSubordinativaIntegrante);
		grupoBotoes.add(radioSubordinativaProporcional);
		grupoBotoes.add(radioSubordinativaTemporal);
		grupoBotoes.add(radioCoordenativaAditiva);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		System.out.println(acao);

		switch (acao) {
		case "Iniciar":
			iniciar();
			break;
		case "Pular":
			pular();
			break;
		case "Responder":
			responder();
			break;
		case "Voltar":
			JOptionPane
			.showMessageDialog(null,
					"Operação não concluida! por isso não foi salvo seus dados no banco!");
			voltar();
			break;

		default:
			break;
		}
	}

	private void voltar() {
		
		dispose();

	}

	private void responder() {
		// TODO Auto-generated method stub
		boolean resposta = verificaResposta();
		
		if (resposta) {
			ponto++;
			System.out.println("adicionou pontuação");
		}
		
		posicaoAtual++;
		System.out.println(posicaoAtual+" esta é a posição atual.");
		System.out.println(listaConjuncaos.size()-1+" esta é o tamnho da lista de conjunções");
		if (posicaoAtual>=listaConjuncaos.size()-1) {
			calculaSalvaResultado();
			btnResponder.setEnabled(false);
			btnPular.setEnabled(false);
			btnResponder.setEnabled(true);
			btnVoltar.setEnabled(true);
			
		}

		progressBar.setValue(posicaoAtual / listaConjuncaos.size() * 100);
		
		enableCheque(true);
		txtPalavra.setText(listaConjuncaos.get(posicaoAtual).getNome());
		

	}

	private void calculaSalvaResultado() {
		Desempenho desemp = new Desempenho();
		
		desemp.setData(new Date());
		
		//desemp.setPercentoAcerto(ponto/listaConjuncaos.size()*100);
		
		
		//
		String tempoString = (lblTempo.getText());
		//System.out.println("se imprimir coletou Strng - "+tempo);
		
		//
		int tempo = Integer.parseInt(tempoString.replace(" ", ""));  
		
		System.out.println(tempo);
		
		desemp.setTempo(tempo);
		//
//		float percentoAcerto = ponto/listaConjuncaos.size()*100;
		float percentoAcerto = (float) (((float)ponto/5.0)*100);
		
		desemp.setPercentoAcerto(percentoAcerto);
		
		float eficiencia = percentoAcerto/tempo;

		
		desemp.setEficiencia(eficiencia);
		
		banco.salvarObjeto(desemp);
		
		JOptionPane.showMessageDialog(null, "Resultado salvo com sucesso, verifique a lista de desempenho.");
		voltar();
		
	}

	private boolean verificaResposta() {
		boolean certo = false;
		
		ArrayList<String> listaResposta = new ArrayList<String>();
		if (radioCoordenativaAditiva.isSelected()) {
			listaResposta.add(radioCoordenativaAditiva.getText());
			radioCoordenativaAditiva.setSelected(false);
		}

		if (radioCoordenativaAdversativa.isSelected()) {
			listaResposta.add(radioCoordenativaAdversativa.getText());
			radioCoordenativaAdversativa.setSelected(false);
		}
		if (radioCoordenativaAlternativa.isSelected()) {
			listaResposta.add(radioCoordenativaAlternativa.getText());
			radioCoordenativaAlternativa.setSelected(false);
		}
		if (radioCoordenativaConclusiva.isSelected()) {
			listaResposta.add(radioCoordenativaConclusiva.getText());
			radioCoordenativaConclusiva.setSelected(false);
		}
		if (radioCoordenativaExplicativa.isSelected()) {
			listaResposta.add(radioCoordenativaExplicativa.getText());
			radioCoordenativaExplicativa.setSelected(false);
		}
		if (radioSubordinativaCasual.isSelected()) {
			listaResposta.add(radioSubordinativaCasual.getText());
			radioSubordinativaCasual.setSelected(false);
		}
		if (radioSubordinativaComparativa.isSelected()) {
			listaResposta.add(radioSubordinativaComparativa.getText());
			radioSubordinativaComparativa.setSelected(false);
		}
		if (radioSubordinativaConcessiva.isSelected()) {
			listaResposta.add(radioSubordinativaConcessiva.getText());
		}
		if (radioSubordinativaCondicional.isSelected()) {
			listaResposta.add(radioSubordinativaCondicional.getText());
			radioSubordinativaCondicional.setSelected(false);
		}
		if (radioSubordinativaConformidade.isSelected()) {
			listaResposta.add(radioSubordinativaConformidade.getText());
			radioSubordinativaConformidade.setSelected(false);
		}
		if (radioSubordinativaConsecutiva.isSelected()) {
			listaResposta.add(radioSubordinativaConsecutiva.getText());
			radioSubordinativaConsecutiva.setSelected(false);
		}
		if (radioSubordinativaFinal.isSelected()) {
			listaResposta.add(radioSubordinativaFinal.getText());
			radioSubordinativaFinal.setSelected(false);
		}
		if (radioSubordinativaIntegrante.isSelected()) {
			listaResposta.add(radioSubordinativaIntegrante.getText());
			radioSubordinativaIntegrante.setSelected(false);
		}
		if (radioSubordinativaProporcional.isSelected()) {
			listaResposta.add(radioSubordinativaProporcional.getText());
			radioSubordinativaProporcional.setSelected(false);
		}
		if (radioSubordinativaTemporal.isSelected()) {
			listaResposta.add(radioSubordinativaTemporal.getText());
			radioSubordinativaTemporal.setSelected(false);
		}

		for (int i = 0; i < listaResposta.size(); i++) {

			for (int j = 0; j < listaConjuncaos.size(); j++) {
				if (listaConjuncaos.get(posicaoAtual).getNome()
						.equalsIgnoreCase(listaConjuncaos.get(j).getNome())
						&& listaResposta.get(i).equalsIgnoreCase(
								listaConjuncaos.get(j).getClassificacao())) {
					System.out.println("Resposta Correta");
					certo=true;

				}if (listaConjuncaos.get(posicaoAtual).getNome()
						.equalsIgnoreCase(listaConjuncaos.get(j).getNome())
						&& !listaResposta.get(i).equalsIgnoreCase(
								listaConjuncaos.get(j).getClassificacao())) {
					System.out.println("resposta "+i+" "+listaResposta.get(i));
					System.out.println("item da lista de conjunção na posição "+j+" "+listaConjuncaos.get(j).getClassificacao());
					System.out.println("são diferentes!");
					System.out.println("resposta incorreta");
					certo = false;
					break;
				}
			}
		}
		return certo;

	}

	private void pular() {
		Conjuncao ad = listaConjuncaos.get(posicaoAtual);
		listaConjuncaos.set(posicaoAtual, null);
		listaConjuncaos.add(ad);

	}

	private void iniciar() {
		try {
			listaConjuncaos = (ArrayList<Conjuncao>) banco.listarObjetosAsc(
					Conjuncao.class, "id");
			posicaoAtual = 0;

			Collections.shuffle(listaConjuncaos);
			JOptionPane
					.showMessageDialog(
							null,
							"Dica: leve o tempo necessario para responder corretamente, o melhoramento é gradativo, seu desempenho ficara gravado. Seu teste ira começar!");
			new contarTempo().start();

			txtPalavra.setText(listaConjuncaos.get(posicaoAtual).getNome());

			enableCheque(true);

			btnResponder.setEnabled(true);
			btnPular.setEnabled(true);
			btnIniciar.setEnabled(false);

		} catch (Exception e) {
			System.out.println("Erro : " + e);
		}

	}

	private void enableCheque(boolean b) {
		radioCoordenativaAditiva.setEnabled(b);
		radioCoordenativaAdversativa.setEnabled(b);
		radioCoordenativaAlternativa.setEnabled(b);
		radioCoordenativaConclusiva.setEnabled(b);
		radioCoordenativaExplicativa.setEnabled(b);
		radioSubordinativaCasual.setEnabled(b);
		radioSubordinativaComparativa.setEnabled(b);
		radioSubordinativaConcessiva.setEnabled(b);
		radioSubordinativaCondicional.setEnabled(b);
		radioSubordinativaConformidade.setEnabled(b);
		radioSubordinativaConsecutiva.setEnabled(b);
		radioSubordinativaFinal.setEnabled(b);
		radioSubordinativaIntegrante.setEnabled(b);
		radioSubordinativaProporcional.setEnabled(b);
		radioSubordinativaTemporal.setEnabled(b);

	}

	public class contarTempo extends Thread {
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println("Erro : " + e);
				}
				tempo++;
				lblTempo.setText(tempo + " ");
			}
		}

	}
}
