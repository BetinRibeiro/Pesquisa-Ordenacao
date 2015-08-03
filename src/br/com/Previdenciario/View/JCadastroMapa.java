package br.com.Previdenciario.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

import org.postgresql.jdbc2.EscapedFunctions;

import br.com.Persistencia.Banco;
import br.com.Previdenciario.Bin.Estudo;
import br.com.Previdenciario.Model.ModelEstudo;

import javax.swing.JLabel;

public class JCadastroMapa extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTable table;
	private JButton btnCriar;
	private JButton btnCarregar;
	private JButton btnDeletar;
	private JButton btnLiberar;
	private JButton btnSalvar;
	private ModelEstudo model = new ModelEstudo();
	private Banco banco = new Banco();
	private JTextArea txtConteudo;
	private Estudo estudoAtual;
	private JLabel tamanhoString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastroMapa frame = new JCadastroMapa();
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
	public JCadastroMapa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1380, 750);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 500, 45);
		contentPane.add(panel);
		panel.setLayout(null);

		btnCriar = new JButton("Criar");
		btnCriar.setBounds(8, 10, 90, 23);
		panel.add(btnCriar);

		btnCarregar = new JButton("Carregar");
		btnCarregar.setBounds(106, 10, 90, 23);
		panel.add(btnCarregar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(206, 10, 89, 23);
		panel.add(btnDeletar);

		tamanhoString = new JLabel("0");
		tamanhoString.setBounds(345, 14, 46, 14);
		panel.add(tamanhoString);

		JPanel paineTabela = new JPanel();
		paineTabela.setBorder(new LineBorder(new Color(0, 0, 0)));
		paineTabela.setBounds(10, 65, 500, 615);
		contentPane.add(paineTabela);
		paineTabela.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 480, 593);
		paineTabela.add(scrollPane_1);

		table = new JTable(model);
		// tabela com colunas fixasv
		table.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
		table.getColumn("TITULO").setPreferredWidth(550);
		// seleciona apenas uma linha
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table);
		// table.getColumn("TITULO").setPreferredWidth(100);

		JPanel painelConteudo = new JPanel();
		painelConteudo.setBorder(new LineBorder(new Color(0, 0, 0)));
		painelConteudo.setBounds(520, 10, 834, 670);
		contentPane.add(painelConteudo);
		painelConteudo.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 814, 614);
		painelConteudo.add(scrollPane);

		txtConteudo = new JTextArea();
		txtConteudo.setDisabledTextColor(new Color(148, 0, 211));
		txtConteudo.setSelectionColor(new Color(204, 255, 204));
		scrollPane.setViewportView(txtConteudo);
		txtConteudo.setLineWrap(true);
		txtConteudo.setWrapStyleWord(true);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 10, 614, 23);
		painelConteudo.add(txtTitulo);
		txtTitulo.setColumns(10);

		btnLiberar = new JButton("Liberar");
		btnLiberar.setBounds(634, 11, 89, 23);
		painelConteudo.add(btnLiberar);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(735, 11, 89, 23);
		painelConteudo.add(btnSalvar);

		btnSalvar.addActionListener(this);
		btnCarregar.addActionListener(this);
		btnCriar.addActionListener(this);
		btnDeletar.addActionListener(this);
		btnLiberar.addActionListener(this);

		atualiza();

		btnSalvar.setEnabled(false);
		btnLiberar.setEnabled(false);

		txtTitulo.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		System.out.println(acao);

		switch (acao) {
		case "Criar":
			criar();
			break;
		case "Carregar":
			alterar();
			break;
		case "Deletar":
			String a = JOptionPane.showInputDialog("Senha:");
			if (a.equalsIgnoreCase("ok")) {
				deletar();
			} else {
				JOptionPane.showMessageDialog(null, "Erro!");
			}
			break;
		case "Liberar":
			liberar();
			break;
		case "Salvar":
			salvar();
			break;

		default:
			break;
		}
	}

	private void atualiza() {
		model.removeTudo();

		List<?> lista = banco.listarObjetosAsc(Estudo.class, "titulo");

		for (int i = 0; i < lista.size(); i++) {
			Estudo palavra = (Estudo) lista.get(i);
			model.addRow(palavra);

		}

		tamanhoString.setText(String.valueOf(txtConteudo.getText().length()));
		
	}

	private void salvar() {
		txtConteudo.setEnabled(false);
		txtTitulo.setEnabled(false);

		btnCarregar.setEnabled(true);
		btnCriar.setEnabled(true);
		btnDeletar.setEnabled(true);
		btnSalvar.setEnabled(false);
		btnLiberar.setEnabled(true);

		table.setEnabled(true);

		estudoAtual.setConteudo(txtConteudo.getText());
		estudoAtual.setTitulo(txtTitulo.getText().toUpperCase());

		banco.salvarOuAtualizarObjeto(estudoAtual);
		//JOptionPane.showMessageDialog(null, "Mapeamento Salvo!");
		atualiza();

	}

	private void liberar() {
		table.setEnabled(false);
		txtConteudo.setEnabled(true);
		txtTitulo.setEnabled(true);
		btnSalvar.setEnabled(true);
		btnLiberar.setEnabled(false);
		btnCarregar.setEnabled(false);
		btnCriar.setEnabled(false);
		btnDeletar.setEnabled(false);
		btnSalvar.setEnabled(true);

		// txtTitulo.setVisible(false);

	}

	private void deletar() {
		try {
			Integer id = (Integer) table.getValueAt(table.getSelectedRow(), 0);

			Estudo pala = (Estudo) banco.buscarPorId(Estudo.class, id);
			banco.deletarObjeto(pala);
			atualiza();
		} catch (Exception ea) {
			JOptionPane.showMessageDialog(null, "ERRO - " + ea
					+ ".(Selecione um titulo para deletar!!) ");
		}

	}

	private void alterar() {
		try {
			Integer id = (Integer) table.getValueAt(table.getSelectedRow(), 0);

			estudoAtual = (Estudo) banco.buscarPorId(Estudo.class, id);

			txtTitulo.setText(estudoAtual.getTitulo());
			txtConteudo.setText(estudoAtual.getConteudo());

			btnLiberar.setEnabled(true);

			txtConteudo.setEnabled(false);
			atualiza();

		} catch (Exception ea) {
			JOptionPane.showMessageDialog(null, "ERRO - " + ea
					+ ".(Selecione um titulo para Carregar!!) ");
		}
	}

	private void criar() {
		try {

			String titulo = JOptionPane
					.showInputDialog("Digite o nome do titulo.").toUpperCase();
			Estudo e = new Estudo();
			e.setTitulo(titulo);
			e.setConteudo("");
			banco.salvarObjeto(e);
			atualiza();
		} catch (Exception e) {
			System.out.println("erro - " + e);
		}
	}
}
