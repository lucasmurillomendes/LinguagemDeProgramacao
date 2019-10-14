/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Estado {
    
    private String nome;
    private List<Cidade> cidades;

    public Estado(String nome, List<Cidade> cidades) {
        this.nome = nome;
        this.cidades = cidades;
    }
    
    public Estado(String nome) {
        this.nome = nome;
        this.cidades = new ArrayList<>();
    }

    public void addCidade(Cidade cidade) {
        if (cidades != null) {
            this.cidades.add(cidade);
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public String toString() {
        return nome;
    }

    

}
