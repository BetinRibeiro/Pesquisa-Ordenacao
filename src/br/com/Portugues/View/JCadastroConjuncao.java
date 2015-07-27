package br.com.Portugues.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import br.com.Persistencia.Banco;
import br.com.Portugues.Bin.Conjuncao;
import br.com.Portugues.Model.ModelConjuncao;

import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.DropMode;

public class JCadastroConjuncao extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JTable tablePalavras;
	private JTextField txtNome;

	private Banco banco = new Banco();
	private JComboBox boxClassificacao;
	private ModelConjuncao model = new ModelConjuncao();

	private JButton btnAlterar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastroConjuncao frame = new JCadastroConjuncao();
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
	public JCadastroConjuncao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 800, 500);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel painel = new JPanel();
		painel.setBorder(new LineBorder(new Color(0, 0, 0)));
		painel.setBounds(10, 20, 300, 176);
		panelPrincipal.add(painel);
		painel.setLayout(null);

		JLabel lblCadastroDeConjuncaos = new JLabel("Cadastro de Conjuncaos");
		lblCadastroDeConjuncaos.setBounds(10, 10, 256, 20);
		painel.add(lblCadastroDeConjuncaos);

		txtNome = new JTextField();
		txtNome.setBounds(10, 60, 280, 20);
		painel.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 40, 100, 20);
		painel.add(lblNome);

		String[] lista = { "Coordenativa Aditiva", "Coordenativa Adversativa",
				"Coordenativa Alternativa", "Coordenativa Explicativa",
				"Coordenativa Conclusiva", "Subordinativa Temporal",
				"Subordinativa Casual", "Subordinativa Condicional",
				"Subordinativa Proporcional", "Subordinativa Final",
				"Subordinativa Consecutiva", "Subordinativa Concessiva",
				"Subordinativa Comparativa", "Subordinativa Conformidade",
				"Subordinativa Integrante" };

		boxClassificacao = new JComboBox(lista);
		boxClassificacao.setBounds(10, 110, 280, 20);
		painel.add(boxClassificacao);

		atualizarTabela("id");

		JLabel lblClassificao = new JLabel("Classifica\u00E7\u00E3o");
		lblClassificao.setBounds(10, 90, 100, 20);
		painel.add(lblClassificao);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 140, 89, 23);
		painel.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(109, 140, 89, 23);
		painel.add(btnCancelar);

		JPanel painelTabela = new JPanel();
		painelTabela.setBorder(new LineBorder(new Color(0, 0, 0)));
		painelTabela.setBounds(320, 20, 460, 400);
		panelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 460, 400);
		painelTabela.add(scrollPane);

		tablePalavras = new JTable(model);
		scrollPane.setViewportView(tablePalavras);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(320, 430, 89, 23);
		panelPrincipal.add(btnDeletar);

		JPanel panelExtra = new JPanel();
		panelExtra.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelExtra.setBounds(10, 210, 300, 210);
		panelPrincipal.add(panelExtra);
		panelExtra.setLayout(null);

		JTextArea txtrAsConjunesMais = new JTextArea();
		txtrAsConjunesMais.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrAsConjunesMais.setEditable(false);
		txtrAsConjunesMais.setLineWrap(true);
		txtrAsConjunesMais.setBackground(new Color(230, 230, 250));
		txtrAsConjunesMais.setForeground(Color.BLACK);
		txtrAsConjunesMais.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrAsConjunesMais
				.setText("As Conjun\u00E7\u00F5es mais importantes\r\n\r\nCoordenativas: aditivas, \r\nadversativas, explicativas \r\ne conclusivas.\r\n\r\nSubordinativa: Consecutiva");
		txtrAsConjunesMais.setBounds(0, 0, 300, 210);
		panelExtra.add(txtrAsConjunesMais);

		JButton btnClasse = new JButton("Classe");
		btnClasse.setBounds(691, 430, 89, 23);
		panelPrincipal.add(btnClasse);

		JButton btnAlfabetica = new JButton("Ordem");
		btnAlfabetica.setBounds(592, 430, 89, 23);
		panelPrincipal.add(btnAlfabetica);

		JButton btnIdentificador = new JButton("ID");
		btnIdentificador.setBounds(518, 430, 64, 23);
		panelPrincipal.add(btnIdentificador);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(419, 431, 89, 23);
		panelPrincipal.add(btnAlterar);

		btnCancelar.addActionListener(this);
		btnDeletar.addActionListener(this);
		btnSalvar.addActionListener(this);
		btnClasse.addActionListener(this);
		btnIdentificador.addActionListener(this);
		btnAlfabetica.addActionListener(this);
		btnAlterar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		// System.out.println(acao);

		switch (acao) {
		case "Cancelar":
			cancelar();
			break;

		case "Deletar":
			deletar();
			break;
		case "Salvar":
			salvar();
			break;
		case "ID":
			atualizarTabela("id");
			break;
		case "Ordem":
			atualizarTabela("nome");
			break;
		case "Classe":
			atualizarTabela("classificacao");
			break;
		case "Alterar":
			alterar();
			break;
		default:
			break;
		}
	}

	private void alterar() {
		try {
			Integer id = (Integer) tablePalavras.getValueAt(
					tablePalavras.getSelectedRow(), 0);

			Conjuncao pala = (Conjuncao) banco.buscarPorId(Conjuncao.class, id);
			
			String nome = (JOptionPane.showInputDialog( "Complemente ou altere o nome da palavra: ", pala.getNome()));
			System.out.println(nome);
			pala.setNome(nome);
			if (nome!=null) {
				banco.salvarOuAtualizarObjeto(pala);
			}
			

			atualizarTabela("nome");
		} catch (Exception ea) {
			JOptionPane.showMessageDialog(null, "ERRO - " + ea
					+ ".(Selecione uma palavra para Alterar!!) ");
		}
		
	}

	private void salvar() {
		Conjuncao ad = new Conjuncao();

		ad.setNome(txtNome.getText());
		ad.setClassificacao((String) boxClassificacao.getSelectedItem());
		banco.salvarObjeto(ad);
		cancelar();
		atualizarTabela("nome");

	}

	private void atualizarTabela(String a) {
		model.removeTudo();

		List<?> lista = banco.listarObjetosAsc(Conjuncao.class, a);

		for (int i = 0; i < lista.size(); i++) {
			Conjuncao palavra = (Conjuncao) lista.get(i);
			model.addRow(palavra);

		}

	}

	private void deletar() {
		try {
			Integer id = (Integer) tablePalavras.getValueAt(
					tablePalavras.getSelectedRow(), 0);

			Conjuncao pala = (Conjuncao) banco.buscarPorId(Conjuncao.class, id);
			banco.deletarObjeto(pala);

			atualizarTabela("nome");
		} catch (Exception ea) {
			JOptionPane.showMessageDialog(null, "ERRO - " + ea
					+ ".(Selecione uma palavra para deletar!!) ");
		}

	}

	private void cancelar() {
		txtNome.setText("");
	}
}
