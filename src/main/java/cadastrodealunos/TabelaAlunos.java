package cadastrodealunos;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import cadastrodealunos.activerecord.AlunoModel;
import cadastrodealunos.rowdatagateway.Aluno;
import cadastrodealunos.tabledatagateway.ManipuladorDeAlunos;

public class TabelaAlunos extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTable table;

	public TabelaAlunos() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		table = new JTable(new ModeloTableAluno());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		table.getSelectionModel().addListSelectionListener(new RowListener());
		add(new JScrollPane(table));

	}

	public void actionPerformed(ActionEvent event) {

	}

	private class RowListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {
			if (event.getValueIsAdjusting()) {
				return;
			}
			AlunoModel am = null;
			DefaultListSelectionModel src = (DefaultListSelectionModel) event.getSource();
			ListSelectionListener[] escs = src.getListSelectionListeners();
			for (ListSelectionListener lsl : escs) {
				if (lsl instanceof JTable) {
					JTable tab = (JTable) lsl;
					TableModel mtm = tab.getModel();
					int vlr = (Integer) mtm.getValueAt(tab.getSelectedRow(), 0);
					am = new AlunoModel(vlr);
					break;
				}
			}

			EdicaoAluno ed = new EdicaoAluno();
			ed.setSelecionado(am);
			ed.setVisible(true);
		}
	}

	class ModeloTableAluno extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private String[] columnNames = { "Matrícula", "Nome" };
		private Object[][] data = recuperarDados();

		public int getColumnCount() {
			return columnNames.length;
		}

		private Object[][] recuperarDados() {
			ArrayList<Aluno> todos = new ManipuladorDeAlunos().listarTodos();

			Object[][] dados = new Object[todos.size()][2];

			for (int i = 0; i < todos.size(); i++) {
				Aluno aluno = (Aluno) todos.get(i);
				dados[i][0] = aluno.getMatricula();
				dados[i][1] = aluno.getNome();
			}

			return dados;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}
	}
}
