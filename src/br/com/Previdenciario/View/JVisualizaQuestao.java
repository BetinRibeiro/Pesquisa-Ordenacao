package br.com.Previdenciario.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import br.com.Persistencia.Banco;
import br.com.Previdenciario.Bin.Estudo;
import br.com.Previdenciario.Bin.Questao;
import br.com.Previdenciario.Model.ModelEstudo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import org.postgresql.jdbc2.EscapedFunctions;

import java.awt.Color;

public class JVisualizaQuestao extends JFrame {

	private JPanel contentPane;
	private JTextField txtFonte;
	private ArrayList<Questao> listaQuest=new ArrayList<Questao>();
	private Banco banco = new Banco();
	private JTextArea txtConteudo;
	private Integer posicao = 0;
	private JLabel lblIndicando;
	private JTable table;
	private ModelEstudo model = new ModelEstudo();
	private JButton btnAlterar;
	private JButton btnSalvar;
	private JButton btnAnterior;
	private JButton btnPosterior;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JVisualizaQuestao frame = new JVisualizaQuestao();
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
	public JVisualizaQuestao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1380, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 67, 956, 582);
		contentPane.add(scrollPane);
		
		txtConteudo = new JTextArea();
		txtConteudo.setDisabledTextColor(new Color(0, 128, 128));
		txtConteudo.setEnabled(false);
		scrollPane.setViewportView(txtConteudo);
		
		txtFonte = new JTextField();
		txtFonte.setDisabledTextColor(new Color(0, 0, 0));
		txtFonte.setEnabled(false);
		txtFonte.setBounds(81, 36, 209, 20);
		contentPane.add(txtFonte);
		txtFonte.setColumns(10);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(25, 39, 46, 14);
		contentPane.add(lblLocal);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Questao q = listaQuest.get(posicao);
					q.setEnunciado(txtConteudo.getText());
					q.setFonte((Integer) table.getValueAt(table.getSelectedRow(), 0));
					
					banco.salvarOuAtualizarObjeto(q);
					btnAlterar.setEnabled(true);
					btnSalvar.setEnabled(false);
					txtConteudo.setEnabled(false);
					btnAnterior.setEnabled(true);
					btnPosterior.setEnabled(true);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione um item para mapeamento");
				}
				
				
				
			}
		});
		btnSalvar.setBounds(598, 35, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(795, 35, 89, 23);
		contentPane.add(btnSair);
		txtConteudo.setLineWrap(true);
		txtConteudo.setWrapStyleWord(true);
		
		 btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posicao>0) {
					posicao=posicao-1;
					insereQuestao();
				}
			}
		});
		btnAnterior.setBounds(300, 35, 89, 23);
		contentPane.add(btnAnterior);
		
		 btnPosterior = new JButton("Posterior");
		btnPosterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(posicao);
				if (posicao<listaQuest.size()) {
					System.out.println("Entrou posterior");
					posicao=posicao+1;
					insereQuestao();
				}
				
			}
			
		});
		btnPosterior.setBounds(498, 35, 89, 23);
		contentPane.add(btnPosterior);
		
		lblIndicando = new JLabel("indicando");
		lblIndicando.setBounds(739, 39, 123, 14);
		contentPane.add(lblIndicando);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(991, 72, 363, 577);
		contentPane.add(scrollPane_1);
		
		table = new JTable(model);
		scrollPane_1.setViewportView(table);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAlterar.setEnabled(false);
				btnSalvar.setEnabled(true);
				txtConteudo.setEnabled(true);
				btnAnterior.setEnabled(false);
				btnPosterior.setEnabled(false);
			}
		});
		btnAlterar.setBounds(399, 35, 89, 23);
		contentPane.add(btnAlterar);
		
		retornaListaQuetoes();
		
		insereQuestao();
		atualiza();
		
	}

	private void atualiza() {
		model.removeTudo();

		List<?> lista = banco.listarObjetosAsc(Estudo.class, "titulo");

		for (int i = 0; i < lista.size(); i++) {
			Estudo palavra = (Estudo) lista.get(i);
			model.addRow(palavra);

		}
		
	}

	private void insereQuestao() {
		txtConteudo.setText("");
		txtConteudo.setText(listaQuest.get(posicao).getEnunciado());
		System.out.println("inseriu questao");
		lblIndicando.setText((posicao+1)+"/"+listaQuest.size());
		if ( listaQuest.get(posicao).getFonte()>0) {
			Estudo e = (Estudo) banco.buscarPorId(Estudo.class, listaQuest.get(posicao).getFonte());
			txtFonte.setText(String.valueOf(e.getTitulo()));
		}else {
			txtFonte.setText("NADA");
		}
		
		
	}

	private void retornaListaQuetoes() {
		List<?> li = banco.listarObjetosAsc(Questao.class,
				"numeroOcorrencia");

		for (int i = 0; i < li.size(); i++) {
			Questao quest = (Questao) li.get(i);
			
			listaQuest.add(quest);
//			quest.setFonte(-1);
//			banco.salvarOuAtualizarObjeto(quest);
			
		}
		
	}
}
