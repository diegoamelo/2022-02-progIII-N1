package br.edu.femass.gui;

import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Professor;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiProfessor {

    private JPanel jPanel;
    private JList lstProfessores;
    private JTextField txtCodigo;
    private JTextField txtNome;
    private JTextField txtRua;
    private JTextField txtNumero;
    private JTextField txtComplemento;
    private JTextField txtBairro;
    private JTextField txtCidade;
    private JTextField txtUf;
    private JTextField txtPais;
    private JTextField txtCep;
    private JTextField txtTelefone;
    private JTextField txtPrazoMaximoDevolucao;
    private JTextField txtDisciplina;
    private JButton btnSalvar;

    public JPanel getjPanel() {
        return jPanel;
    }

    public GuiProfessor() {
        lstProfessores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Professor professor = (Professor) lstProfessores.getSelectedValue();
                if (!(professor == null)) {
                    txtCodigo.setText(professor.getCodigo().toString());
                    txtNome.setText(professor.getNome());
                    txtRua.setText(professor.getRua());
                    txtNumero.setText(professor.getNumero().toString());
                    txtComplemento.setText(professor.getComplemento());
                    txtBairro.setText(professor.getBairro());
                    txtCidade.setText(professor.getCidade());
                    txtUf.setText(professor.getUf());
                    txtPais.setText(professor.getPais());
                    txtCep.setText(professor.getCep());
                    txtTelefone.setText(professor.getTelefone());
                    txtPrazoMaximoDevolucao.setText(professor.getPrazoMaximoDevolucao().toString());
                    txtDisciplina.setText(professor.getDisciplina());
                }
            }
        });
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Professor professor = new Professor(
                            txtNome.getText(),
                            txtRua.getText(),
                            Integer.parseInt(txtNumero.getText()),
                            txtComplemento.getText(),
                            txtBairro.getText(),
                            txtCidade.getText(),
                            txtUf.getText(),
                            txtPais.getText(),
                            txtCep.getText(),
                            txtTelefone.getText(),
                            txtDisciplina.getText()
                    );
                    new DaoProfessor().save(professor);
                    preencherLista();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    private void preencherLista() {
        try {
            lstProfessores.setListData(new DaoProfessor().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /*private void preencherListaUf() {
        try {
            cboUf.removeAllItems();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void preencherListaPais() {
        try {
            cboPais.removeAllItems();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }*/

    public void abrirTela() {
        GuiProfessor gui = new GuiProfessor();
        JFrame frame = new JFrame("Cadastro de Aluno");
        gui.preencherLista();
        //gui.preencherListaUf();
        //gui.preencherListaPais();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
