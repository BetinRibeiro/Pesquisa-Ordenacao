package br.com.Previdenciario.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.Persistencia.Banco2;
import br.com.outroProj.bim.ArtigoLei;
import br.com.outroProj.model.ModelLegislacao;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.transaction.Transactional.TxType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JLegislacao extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ModelLegislacao model = new ModelLegislacao();
	private Banco2 banco = new Banco2();
	private ArrayList<ArtigoLei> listaArt = new ArrayList<ArtigoLei>();
	private JTextArea txtConteudo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLegislacao frame = new JLegislacao();
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
	public JLegislacao() {
		setBounds(0, 0, 1635, 760);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 679, 666);
		contentPane.add(scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(10, 688, 89, 23);
		contentPane.add(btnAtualizar);

		JButton btnUnir = new JButton("Unir");
		btnUnir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer id = (Integer) table.getValueAt(table.getSelectedRow(),
						0);

				ArtigoLei art = (ArtigoLei) banco.buscarPorId(ArtigoLei.class,
						id);
				ArtigoLei artAnterior = new ArtigoLei();
				try {
					 artAnterior = (ArtigoLei) banco.buscarPorId(
							ArtigoLei.class, id - 1);

					System.out.println("artigo anterior " + artAnterior.getId());
					artAnterior.setConteudo(artAnterior.getConteudo() + " "
							+ art.getConteudo());

				} catch (Exception e2) {
					System.out.println("Aqui ô "+e2);
				}
				

				banco.salvarOuAtualizarObjeto(artAnterior);
				banco.deletarObjeto(art);
				atualizarTabela();
			}
		});
		btnUnir.setBounds(109, 688, 89, 23);
		contentPane.add(btnUnir);

		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer id = (Integer) table.getValueAt(table.getSelectedRow(),
						0);

				ArtigoLei pala = (ArtigoLei) banco.buscarPorId(ArtigoLei.class,
						id);
				txtConteudo.setText(pala.getConteudo());
			}
		});
		btnCarregar.setBounds(208, 688, 89, 23);
		contentPane.add(btnCarregar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(699, 11, 661, 700);
		contentPane.add(scrollPane_1);

		txtConteudo = new JTextArea();
		txtConteudo.setEnabled(false);
		scrollPane_1.setViewportView(txtConteudo);

		atualizarTabela();
	}

	private void atualizarTabela() {
		model.removeTudo();

		List<?> lista = banco.listarObjetosAsc(ArtigoLei.class, "id");
		// System.out.println(lista.size());

		for (int i = 0; i < lista.size(); i++) {
			ArtigoLei art = (ArtigoLei) lista.get(i);
			listaArt.add(art);
			model.addRow(art);

		}
	}
}
