/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.bean;

import java.util.Date;

/**
 *create table contato (
    id int not null auto_increment primary key,
    nome varchar(40),
    idade int,
    dataCadastro date
);
 * @author aluno
 */
public class Contato {
    private int id;
    private String nome;
    private int idade;
    private Date dataCadastro;

    public Contato() {
    }    
    
    public Contato(int id, String nome, int idade, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
