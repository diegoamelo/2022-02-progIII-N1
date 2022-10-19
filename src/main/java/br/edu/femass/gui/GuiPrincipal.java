package br.edu.femass.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPrincipal {

    private JPanel jPanel;
    private JButton btnCadastrarAutor;
    private JButton btnCadastrarLivro;
    private JButton btnCadastrarExemplar;
    private JButton btnCadastrarAluno;
    private JButton btnCadastrarProfessor;
    private JButton btnRealizarEmprestimo;
    private JButton btnDevolverExemplar;
    private JButton btnListagemLeitoresAtraso;

    public GuiPrincipal() {

        btnCadastrarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAutor().abrirTela();
            }
        });

        btnCadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiLivro().abrirTela();
            }
        });

        btnCadastrarExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiExemplar().abrirTela();
            }
        });

        btnCadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAluno().abrirTela();
            }
        });

        btnCadastrarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiProfessor().abrirTela();
            }
        });

        btnRealizarEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiEmprestimo().abrirTela();
            }
        });

        btnDevolverExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiDevolucao().abrirTela();
            }
        });

        btnListagemLeitoresAtraso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        GuiPrincipal guiPrincipal = new GuiPrincipal();
        JFrame jFrame = new JFrame("Tela Principal");
        jFrame.setContentPane(guiPrincipal.jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
