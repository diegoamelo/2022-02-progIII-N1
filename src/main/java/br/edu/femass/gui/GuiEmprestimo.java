package br.edu.femass.gui;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.model.Leitor;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

public class GuiEmprestimo {
    private JPanel jPanel;
    private JList lstEmprestimo;
    private JComboBox cboExemplar;
    private JComboBox cboLeitor;
    private JFormattedTextField jftfDataEmprestimo;
    private JFormattedTextField jftfDataPrevistaDevolucao;
    private JButton btnSalvar;

    public JPanel getjPanel() {
        return jPanel;
    }

    public GuiEmprestimo() {

        lstEmprestimo.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Emprestimo emprestimo = (Emprestimo) lstEmprestimo.getSelectedValue();

                if (!(emprestimo == null) && (emprestimo.getDataDevolucao() == null)) {
                    cboExemplar.setSelectedItem(emprestimo.getExemplar());
                    cboLeitor.setSelectedItem(emprestimo.getLeitor());
                    jftfDataEmprestimo.setText(emprestimo.getDataEmprestimo().toString());
                    jftfDataPrevistaDevolucao.setText(emprestimo.getDataPrevistaDevolucao().toString());
                }
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Emprestimo emprestimo = new Emprestimo(
                            (Exemplar) cboExemplar.getSelectedItem(),
                            (Leitor) cboLeitor.getSelectedItem(),
                            LocalDateTime.now(), /********************************************/
                            LocalDateTime.now() /********************************************/
                    );
                    new DaoEmprestimo().save(emprestimo);
                    preencherLista();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
    private void preencherLista() {
        try {
            lstEmprestimo.setListData(new DaoExemplar().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void preencherCboExemplar() {
        try {
            List<Exemplar> exemplares = new DaoExemplar().getAll();
            cboExemplar.removeAllItems();
            for(Exemplar exemplar: exemplares) {
                cboExemplar.addItem(exemplar);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void preencherCboLeitor() {
        try {
            List<Leitor> leitores = new DaoLeitor().getAll();
            cboLeitor.removeAllItems();
            for(Leitor leitor: leitores) {
                cboLeitor.addItem(leitor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTela() {
        GuiEmprestimo gui = new GuiEmprestimo();
        JFrame frame = new JFrame("Realizar Emprestimo");
        gui.preencherLista();
        gui.preencherCboExemplar();
        gui.preencherCboLeitor();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        //Define a m??scara
        MaskFormatter mascaraData = null;
        try{
            mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
        }
        catch(ParseException excp) {
            System.err.println("Erro na formata????o: " + excp.getMessage());
            System.exit(-1);
        }
        //Seta a m??scara no objeto JFormattedTextField
        jftfDataEmprestimo = new JFormattedTextField(mascaraData);
        jftfDataPrevistaDevolucao = new JFormattedTextField(mascaraData);
    }
}
