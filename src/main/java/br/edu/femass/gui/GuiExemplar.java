package br.edu.femass.gui;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import javafx.scene.input.DataFormat;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

public class GuiExemplar {
    private JPanel jPanel;
    private JList lstExemplar;
    private JTextField txtCodigo;
    private JFormattedTextField jftfDataAquisicao;
    private JComboBox cboLivro;
    private JButton btnLivro;
    private JButton btnSalvar;

    public JPanel getjPanel() {
        return jPanel;
    }

    public GuiExemplar() {

        lstExemplar.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Exemplar exemplar = (Exemplar) lstExemplar.getSelectedValue();

                if (!(exemplar == null)) {
                    txtCodigo.setText(exemplar.getCodigo().toString());
                    jftfDataAquisicao.setText(exemplar.getDataAquisicao().toString());
                    cboLivro.setSelectedItem(exemplar.getLivro());
                }
            }
        });

        btnLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiLivro().abrirTela();
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Exemplar exemplar = new Exemplar(
                            LocalDateTime.now(), /********************************************/
                            (Livro) cboLivro.getSelectedItem()
                    );
                    new DaoExemplar().save(exemplar);
                    preencherLista();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    private void preencherLista() {
        try {
            lstExemplar.setListData(new DaoExemplar().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void preencherCboLivro() {
        try {
            List<Livro> livros = new DaoLivro().getAll();
            cboLivro.removeAllItems();
            for(Livro livro: livros) {
                cboLivro.addItem(livro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTela() {
        GuiExemplar gui = new GuiExemplar();
        JFrame frame = new JFrame("Cadastro de Exemplar");
        gui.preencherLista();
        gui.preencherCboLivro();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        //Define a máscara
        MaskFormatter mascaraData = null;
        try{
            mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
        }
        catch(ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }
        //Seta a máscara no objeto JFormattedTextField
        jftfDataAquisicao = new JFormattedTextField(mascaraData);
    }
}
