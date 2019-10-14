/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author aluno
 */
public class JanelaTeste extends JFrame{

    public JanelaTeste() throws HeadlessException {
        
        inicializaCompenentes();
    }

    private void inicializaCompenentes() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
        JButton bt = new JButton("Sair");
        add(bt);
        JTextField tfTexto = new JTextField(15);
        add(tfTexto);
        //Finaliza action = new Finaliza();
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               tfTexto.setText("Texto aqui");
            }
          }
        );
        
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        JanelaTeste janela = new JanelaTeste();
    }
    
    
}
