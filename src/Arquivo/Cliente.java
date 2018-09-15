/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivo;

import java.io.Serializable;

/**
 *
 * @author marcos
 */
public class Cliente implements Serializable{
    
    private long codigo;
    private String nome;
    private byte idade;
    private boolean sexo;
    private int profissao;

    public Cliente() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte getIdade() {
        return idade;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public int getProfissao() {
        return profissao;
    }

    public void setProfissao(int profissao) {
        this.profissao = profissao;
    }

    
    
}
