package br.com.Previdenciario.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.Persistencia.Banco;
import br.com.Previdenciario.Bin.Mapeamento;
import br.com.Previdenciario.Bin.Questao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JMapeamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtfonte;
	private JTextField txtlocal;
	private JTextArea txtObservacao;
	private JTextArea txtTextoLei;
	private JTextArea txtrQuest;
	
	private Integer iD;

	
	public JMapeamento(String questao, Integer id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iD = id;
		setBounds(0, 0, 1635, 760);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 437, 700);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 417, 678);
		panel.add(scrollPane);
		
		txtrQuest = new JTextArea();
		txtrQuest.setEditable(false);
		txtrQuest.setText(questao);
		scrollPane.setViewportView(txtrQuest);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(457, 11, 903, 700);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 100, 883, 240);
		panel_1.add(scrollPane_1);
		
		 txtTextoLei = new JTextArea();
		 txtTextoLei.setEnabled(false);
		scrollPane_1.setViewportView(txtTextoLei);
		
		JLabel lblFonte = new JLabel("Fonte");
		lblFonte.setBounds(10, 20, 86, 20);
		panel_1.add(lblFonte);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(439, 20, 86, 20);
		panel_1.add(lblLocal);
		
		txtfonte = new JTextField();
		txtfonte.setBounds(85, 20, 326, 20);
		panel_1.add(txtfonte);
		txtfonte.setColumns(10);
		
		txtlocal = new JTextField();
		txtlocal.setColumns(10);
		txtlocal.setBounds(514, 20, 379, 20);
		panel_1.add(txtlocal);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 400, 883, 240);
		panel_1.add(scrollPane_2);
		
		txtObservacao = new JTextArea();
		txtObservacao.setEnabled(false);
		scrollPane_2.setViewportView(txtObservacao);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mapeamento mp = new Mapeamento();
				
				mp.setFonte(txtfonte.getText());
				mp.setLocal(txtlocal.getText());
				mp.setObservacao(txtObservacao.getText());
				mp.setTexto(txtTextoLei.getText());
				
				Banco banco = new Banco();
				Questao ques = (Questao) banco.buscarPorId(Questao.class, iD);
				
				ques.setFonte(txtfonte.getText()+" - "+txtlocal.getText());
				
				banco.salvarOuAtualizarObjeto(ques);
				
				banco.salvarObjeto(mp);
				dispose();
			}
		});
		btnSalvar.setBounds(804, 666, 89, 23);
		panel_1.add(btnSalvar);
		
		JButton btnLiberar = new JButton("Liberar");
		btnLiberar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTextoLei.setEnabled(true);
				txtObservacao.setEnabled(true);
				txtfonte.setEnabled(true);
				txtlocal.setEnabled(true);
			}
		});
		btnLiberar.setBounds(606, 666, 89, 23);
		panel_1.add(btnLiberar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(705, 666, 89, 23);
		panel_1.add(btnSair);
		
		JLabel lblTextoDeLei = new JLabel("Texto de Lei / Conteudo Copiado na Integra");
		lblTextoDeLei.setBounds(10, 68, 557, 20);
		panel_1.add(lblTextoDeLei);
		
		JLabel lblObservaoFeitaPor = new JLabel("Observa\u00E7\u00E3o feita por voc\u00EA/ Dicas e macetes");
		lblObservaoFeitaPor.setBounds(10, 375, 557, 20);
		panel_1.add(lblObservaoFeitaPor);
		
		txtObservacao.setLineWrap(true);
		txtrQuest.setLineWrap(true);
		txtTextoLei.setLineWrap(true);
	}
}
