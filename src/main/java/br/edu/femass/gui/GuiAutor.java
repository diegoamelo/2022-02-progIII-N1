package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAutor {

    private JPanel jPanel;
    private JList lstAutores;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtNacionalidade;
    private JButton btnSalvar;

    public JPanel getjPanel() {
        return jPanel;
    }

    public GuiAutor() {
        lstAutores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Autor autor = (Autor) lstAutores.getSelectedValue();

                if (!(autor == null)) {
                    txtNome.setText(autor.getNome());
                    txtSobrenome.setText(autor.getSobrenome());
                    txtNacionalidade.setText(autor.getNacionalidade());
                }
            }
        });
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Autor autor = new Autor(
                            txtNome.getText(),
                            txtSobrenome.getText(),
                            txtNacionalidade.getText()
                    );
                    new DaoAutor().save(autor);
                    preencherLista();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    private void preencherLista() {
        try {
            lstAutores.setListData(new DaoAutor().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTela() {
        GuiAutor gui = new GuiAutor();
        JFrame frame = new JFrame("Cadastro de Autor");
        gui.preencherLista();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
