package cadastrodealunosnaousado;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import padroesorm.activerecord.AlunoModel;
import padroesorm.rowdatagateway.Aluno;
import padroesorm.tabledatagateway.ManipuladorDeAlunos;

public class TabelaAlunos extends JPanel implements ActionListener { 
	private static final long serialVersionUID = 1L;
	private JTable table;
    private JCheckBox rowCheck;
    private JCheckBox columnCheck;
    private JCheckBox cellCheck;

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
//        String command = event.getActionCommand();
//        //Cell selection is disabled in Multiple Interval Selection
//        //mode. The enabled state of cellCheck is a convenient flag
//        //for this status.
//        if ("Row Selection" == command) {
//            table.setRowSelectionAllowed(rowCheck.isSelected());
//            //In MIS mode, column selection allowed must be the
//            //opposite of row selection allowed.
//            if (!cellCheck.isEnabled()) {
//                table.setColumnSelectionAllowed(!rowCheck.isSelected());
//            }
//        } else if ("Column Selection" == command) {
//            table.setColumnSelectionAllowed(columnCheck.isSelected());
//            //In MIS mode, row selection allowed must be the
//            //opposite of column selection allowed.
//            if (!cellCheck.isEnabled()) {
//                table.setRowSelectionAllowed(!columnCheck.isSelected());
//            }
//        } else if ("Cell Selection" == command) {
//            table.setCellSelectionEnabled(cellCheck.isSelected());
//        } else if ("Multiple Interval Selection" == command) { 
//            table.setSelectionMode(
//                    ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//            //If cell selection is on, turn it off.
//            if (cellCheck.isSelected()) {
//                cellCheck.setSelected(false);
//                table.setCellSelectionEnabled(false);
//            }
//            //And don't let it be turned back on.
//            cellCheck.setEnabled(false);
//        } else if ("Single Interval Selection" == command) {
//            table.setSelectionMode(
//                    ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//            //Cell selection is ok in this mode.
//            cellCheck.setEnabled(true);
//        } else if ("Single Selection" == command) {
//            table.setSelectionMode(
//                    ListSelectionModel.SINGLE_SELECTION);
//            //Cell selection is ok in this mode.
//            cellCheck.setEnabled(true);
//        }
//
//        //Update checkboxes to reflect selection mode side effects.
//        rowCheck.setSelected(table.getRowSelectionAllowed());
//        columnCheck.setSelected(table.getColumnSelectionAllowed());
//        if (cellCheck.isEnabled()) {
//            cellCheck.setSelected(table.getCellSelectionEnabled());
//        }
    }

//    private void outputSelection() {
//        output.append(String.format("Lead: %d, %d. ",
//                    table.getSelectionModel().getLeadSelectionIndex(),
//                    table.getColumnModel().getSelectionModel().
//                        getLeadSelectionIndex()));
//        output.append("Rows:");
//        for (int c : table.getSelectedRows()) {
//            output.append(String.format(" %d", c));
//        }
//        output.append(". Columns:");
//        for (int c : table.getSelectedColumns()) {
//            output.append(String.format(" %d", c));
//        }
//        output.append(".\n");
//    }

    private class RowListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            if (event.getValueIsAdjusting()) {
                return;
            }
            AlunoModel am = null;
            DefaultListSelectionModel src = (DefaultListSelectionModel)event.getSource();
            ListSelectionListener[] escs = src.getListSelectionListeners();
            for (ListSelectionListener lsl : escs) {
				if (lsl instanceof JTable) {
					JTable tab = (JTable) lsl;
					TableModel mtm = tab.getModel();
					int vlr = (Integer) mtm.getValueAt(tab.getSelectedRow(), 0);
					am = new AlunoModel(vlr);
					break;
//					tab.get
				}
			}

            EdicaoAluno ed = new EdicaoAluno();
            ed.setSelecionado(am);
            ed.setVisible(true);
//            output.append("ROW SELECTION EVENT. ");
//            outputSelection();
        }
    }

//    private class ColumnListener implements ListSelectionListener {
//        public void valueChanged(ListSelectionEvent event) {
//            if (event.getValueIsAdjusting()) {
//                return;
//            }
//            output.append("COLUMN SELECTION EVENT. ");
//            outputSelection();
//        }
//    }

    class ModeloTableAluno extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
		private String[] columnNames = {"Matrícula",
                                        "Nome"};
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

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
//        public Class getColumnClass(int c) {
//            return getValueAt(0, c).getClass();
//        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }

    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Disable boldface controls.
        UIManager.put("swing.boldMetal", Boolean.FALSE); 

        //Create and set up the window.
        JFrame frame = new JFrame("TableSelectionDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        TabelaAlunos newContentPane = new TabelaAlunos();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
