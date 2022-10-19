package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiLivro {
    private JPanel jPanel;
    private JList lstLivros;
    private JTextField txtTitulo;
    private JButton btnSalvar;
    private JComboBox cboAutor;
    private JButton btnAutor;
    private JTextField txtCodigo;

    public JPanel getjPanel() {
        return jPanel;
    }

    public GuiLivro() {

        lstLivros.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Livro livro = (Livro) lstLivros.getSelectedValue();

                if (!(livro == null)) {
                    txtCodigo.setText(livro.getCodigo().toString());
                    txtTitulo.setText(livro.getTitulo());
                    cboAutor.setSelectedItem(livro.getAutor());
                }
            }
        });

        btnAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAutor().abrirTela();
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Livro livro = new Livro(
                            txtTitulo.getText(),
                            (Autor) cboAutor.getSelectedItem()
                    );
                    new DaoLivro().save(livro);
                    preencherLista();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    private void preencherLista() {
        try {
            lstLivros.setListData(new DaoLivro().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void preencherListaAutor() {
        try {
            List<Autor> autores = new DaoAutor().getAll();
            cboAutor.removeAllItems();
            for(Autor autor: autores){
                cboAutor.addItem(autor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTela() {
        GuiLivro gui = new GuiLivro();
        JFrame frame = new JFrame("Cadastro de Livro");
        gui.preencherLista();
        gui.preencherListaAutor();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
