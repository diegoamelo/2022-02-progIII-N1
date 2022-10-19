package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAluno {
    private JPanel jPanel;
    private JList lstAlunos;
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
    private JTextField txtMatricula;
    private JButton btnSalvar;

    public JPanel getjPanel() {
        return jPanel;
    }

    public GuiAluno() {
        lstAlunos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Aluno aluno = (Aluno) lstAlunos.getSelectedValue();
                if (!(aluno == null)) {
                    txtCodigo.setText(aluno.getCodigo().toString());
                    txtNome.setText(aluno.getNome());
                    txtRua.setText(aluno.getRua());
                    txtNumero.setText(aluno.getNumero().toString());
                    txtComplemento.setText(aluno.getComplemento());
                    txtBairro.setText(aluno.getBairro());
                    txtCidade.setText(aluno.getCidade());
                    txtUf.setText(aluno.getUf());
                    txtPais.setText(aluno.getPais());
                    txtCep.setText(aluno.getCep());
                    txtTelefone.setText(aluno.getTelefone());
                    txtPrazoMaximoDevolucao.setText(aluno.getPrazoMaximoDevolucao().toString());
                    txtMatricula.setText(aluno.getMatricula());
                }
            }
        });
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Aluno aluno = new Aluno(
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
                            txtMatricula.getText()
                    );
                    new DaoAluno().save(aluno);
                    preencherLista();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    private void preencherLista() {
        try {
            lstAlunos.setListData(new DaoAluno().getAll().toArray());
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
        GuiAluno gui = new GuiAluno();
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
