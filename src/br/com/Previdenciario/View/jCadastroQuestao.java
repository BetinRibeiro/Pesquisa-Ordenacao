package br.com.Previdenciario.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.com.Persistencia.Banco;
import br.com.Previdenciario.Bin.Classificacao;
import br.com.Previdenciario.Bin.Opcao;
import br.com.Previdenciario.Bin.Questao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.Color;

import javax.swing.border.LineBorder;

public class jCadastroQuestao extends JFrame {

	private JPanel contentPane;
	private Banco banco = new Banco();
	private JComboBox boxTipo;

	private JPanel panelPrincipal;
	private JTextArea txtCorreta;
	private JTextArea txtIncorreta01;
	private JTextArea txtIncorreta02;
	private JTextArea txtIncorreta03;
	private JTextArea txtIncorreta04;
	private JTextArea txtEnunciado;
	private JLabel lblQuest;
	private JLabel lblOpcao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jCadastroQuestao frame = new jCadastroQuestao();
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
	public jCadastroQuestao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, (2 * 583), 730);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPrincipal.setBounds(100, 15, (2 * 583), 680);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblTipo = new JLabel("TIPO");
		lblTipo.setBounds(10, 25, 46, 14);
		panelPrincipal.add(lblTipo);

		boxTipo = new JComboBox(listaClassificacao());
		boxTipo.setBounds(87, 22, 337, 20);
		panelPrincipal.add(boxTipo);

		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descricao = JOptionPane
						.showInputDialog("Digite o titulo e subtitulo daquestão:");
				if (descricao != null) {
					Classificacao clas = new Classificacao();
					clas.setDescricao(descricao);
					banco.salvarObjeto(clas);

				}
				atualizaBox();
			}
		});

		btnCadastrar.setBounds(434, 21, 123, 23);
		panelPrincipal.add(btnCadastrar);

		JLabel lblEnunciado = new JLabel("ENUNCIADO");
		lblEnunciado.setBounds(10, 50, 95, 14);
		panelPrincipal.add(lblEnunciado);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 547, 102);
		panelPrincipal.add(scrollPane);

		txtEnunciado = new JTextArea();
		txtEnunciado.setBackground(new Color(240, 255, 255));
		scrollPane.setViewportView(txtEnunciado);

		JLabel lblCorreta = new JLabel("CORRETA");
		lblCorreta.setBounds(10, 190, 95, 14);
		panelPrincipal.add(lblCorreta);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 220, 547, 102);
		panelPrincipal.add(scrollPane_1);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}

		});
		txtCorreta = new JTextArea();
		txtCorreta.setBackground(new Color(224, 255, 255));
		scrollPane_1.setViewportView(txtCorreta);

		btnSalvar.setBounds(10, 623, 89, 23);
		panelPrincipal.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(122, 623, 89, 23);
		panelPrincipal.add(btnCancelar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(236, 623, 89, 23);
		panelPrincipal.add(btnVoltar);

		JLabel lblIncorreta_5 = new JLabel("INCORRETA");
		lblIncorreta_5.setBounds(580, 50, 95, 14);
		panelPrincipal.add(lblIncorreta_5);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(580, 80, 547, 102);
		panelPrincipal.add(scrollPane_4);

		txtIncorreta01 = new JTextArea();
		txtIncorreta01.setBackground(new Color(250, 235, 215));
		scrollPane_4.setViewportView(txtIncorreta01);

		JLabel lblIncorreta_2 = new JLabel("INCORRETA");
		lblIncorreta_2.setBounds(580, 190, 95, 14);
		panelPrincipal.add(lblIncorreta_2);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(580, 220, 547, 102);
		panelPrincipal.add(scrollPane_5);

		txtIncorreta02 = new JTextArea();
		txtIncorreta02.setBackground(new Color(250, 235, 215));
		scrollPane_5.setViewportView(txtIncorreta02);

		JLabel lblIncorreta_3 = new JLabel("INCORRETA");
		lblIncorreta_3.setBounds(580, 333, 95, 14);
		panelPrincipal.add(lblIncorreta_3);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(580, 363, 547, 102);
		panelPrincipal.add(scrollPane_6);

		txtIncorreta03 = new JTextArea();
		txtIncorreta03.setBackground(new Color(250, 235, 215));
		scrollPane_6.setViewportView(txtIncorreta03);

		JLabel lblIncorreta_4 = new JLabel("INCORRETA");
		lblIncorreta_4.setBounds(580, 480, 95, 14);
		panelPrincipal.add(lblIncorreta_4);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(580, 510, 547, 102);
		panelPrincipal.add(scrollPane_7);

		txtIncorreta04 = new JTextArea();
		txtIncorreta04.setBackground(new Color(250, 235, 215));
		scrollPane_7.setViewportView(txtIncorreta04);

		txtCorreta.setLineWrap(true);
		txtEnunciado.setLineWrap(true);
		txtIncorreta01.setLineWrap(true);
		txtIncorreta02.setLineWrap(true);
		txtIncorreta03.setLineWrap(true);
		txtIncorreta04.setLineWrap(true);
		
		 lblQuest = new JLabel("QUEST");
		lblQuest.setBounds(10, 32, 46, 14);
		contentPane.add(lblQuest);
		
		 lblOpcao = new JLabel("OPCAO");
		lblOpcao.setBounds(10, 70, 46, 14);
		contentPane.add(lblOpcao);

		atualizaQuest();
	}

	private void atualizaQuest() {
		float quantQuest = banco.listarObjetosAsc(Questao.class, "id").size();
		float quantOpcao = banco.listarObjetosAsc(Opcao.class, "id").size();
		lblOpcao.setText(String.valueOf(quantOpcao));
		
		lblQuest.setText(String.valueOf(quantQuest));
	}

	private String[] listaClassificacao() {
		@SuppressWarnings("unchecked")
		List<Object> listaObj = (List<Object>) banco.listarObjetosAsc(
				Classificacao.class, "descricao");
		String[] lista = new String[listaObj.size()];
		for (int i = 0; i < listaObj.size(); i++) {
			Classificacao inst = (Classificacao) listaObj.get(i);
			lista[i] = inst.getDescricao();

		}
		return lista;

	}

	private void atualizaBox() {

		panelPrincipal.remove(boxTipo);

		txtCorreta.setText("");
		txtIncorreta01.setText("");
		txtIncorreta02.setText("");
		txtIncorreta03.setText("");
		txtIncorreta04.setText("");
		txtEnunciado.setText("");

		boxTipo = new JComboBox(listaClassificacao());
		boxTipo.setBounds(87, 22, 337, 20);
		panelPrincipal.add(boxTipo);

		invalidate();
		validate();
		repaint();
		atualizaQuest();

	}

	private void salvar() {
		try {
			String breakLine = System.getProperty("line.separator");  
		
		Questao quest = new Questao();
		quest.setNumeroOcorrencia(0);
		quest.setTitulo((String) boxTipo.getSelectedItem());
		quest.setEnunciado(txtEnunciado.getText().replaceAll(breakLine, ""));
		quest.setFonte(-1);
		banco.salvarObjeto(quest);

		Opcao op1 = new Opcao();
		Opcao op2 = new Opcao();
		Opcao op3 = new Opcao();
		Opcao op4 = new Opcao();
		Opcao op5 = new Opcao();

		op1.setDificuldade(1);
		op2.setDificuldade(1);
		op3.setDificuldade(1);
		op4.setDificuldade(1);
		op5.setDificuldade(1);

		op1.setIdQuestao(quest.getId());
		op2.setIdQuestao(quest.getId());
		op3.setIdQuestao(quest.getId());
		op4.setIdQuestao(quest.getId());
		op5.setIdQuestao(quest.getId());

		op1.setVerdadeira(true);
		op2.setVerdadeira(false);
		op3.setVerdadeira(false);
		op4.setVerdadeira(false);
		op5.setVerdadeira(false);
		
		op1.setVerdadeira(true);
		op2.setVerdadeira(false);
		op3.setVerdadeira(false);
		op4.setVerdadeira(false);
		op5.setVerdadeira(false);

		op1.setDescricao(txtCorreta.getText().replaceAll(breakLine, ""));
		op2.setDescricao(txtIncorreta01.getText().replaceAll(breakLine, ""));
		op3.setDescricao(txtIncorreta02.getText().replaceAll(breakLine, ""));
		op4.setDescricao(txtIncorreta03.getText().replaceAll(breakLine, ""));
		op5.setDescricao(txtIncorreta04.getText().replaceAll(breakLine, ""));
		

		

		txtCorreta.setText("");
		txtEnunciado.setText("");
		txtIncorreta01.setText("");
		txtIncorreta02.setText("");
		txtIncorreta03.setText("");
		txtIncorreta04.setText("");
		
		banco.salvarObjeto(op1);
		banco.salvarObjeto(op2);
		banco.salvarObjeto(op3);
		banco.salvarObjeto(op4);
		banco.salvarObjeto(op5);
		
		JOptionPane.showMessageDialog(null, "Questão salva com sucesso.");
		atualizaQuest();
		} catch (Exception e) {
			System.out.println("erro -"+e);
		}

	}
}
