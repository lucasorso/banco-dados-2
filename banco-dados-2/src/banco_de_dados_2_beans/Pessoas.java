/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco_de_dados_2_beans;

/**
 *
 * @author Lucas
 */
public class Pessoas {
    
    private int _id;
    private String nome;
    
    private Logradouro mLogradouro;
    private Bairro mBairro;
    private Cidade mCidade;
    private Estado mEstado;
    private Pais mPais;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Logradouro getmLogradouro() {
        return mLogradouro;
    }

    public void setmLogradouro(Logradouro mLogradouro) {
        this.mLogradouro = mLogradouro;
    }

    public Bairro getmBairro() {
        return mBairro;
    }

    public void setmBairro(Bairro mBairro) {
        this.mBairro = mBairro;
    }

    public Cidade getmCidade() {
        return mCidade;
    }

    public void setmCidade(Cidade mCidade) {
        this.mCidade = mCidade;
    }

    public Estado getmEstado() {
        return mEstado;
    }

    public void setmEstado(Estado mEstado) {
        this.mEstado = mEstado;
    }

    public Pais getmPais() {
        return mPais;
    }

    public void setmPais(Pais mPais) {
        this.mPais = mPais;
    }
    
}
