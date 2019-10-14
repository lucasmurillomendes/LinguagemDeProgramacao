/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr;

/**
 *
 * @author aluno
 */
public class Teste<T, E> {
    
    public void setAlgumaCoisa(T v) {
        System.out.println("Qualquer coisa");
    }
    
    public void setOutraCoisa(T t, E e) {
        e.toString();
        t.toString();
    }
}
