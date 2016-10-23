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
public class Pessoas extends ObjectsBD{
    private int _id;
    private String nome;
    
    private Logradouro mLogradouro;
    private Bairro mBairro;
    private Cidade mCidade;
    private Estado mEstado;
    private Pais mPais;

    @Override
    public int getId() {
        return _id;
    }

    @Override
    public void setId(int _id) {
        this._id = _id;
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Logradouro getLogradouro() {
        return mLogradouro;
    }

    public void setLogradouro(Logradouro mLogradouro) {
        this.mLogradouro = mLogradouro;
    }

    public Bairro getBairro() {
        return mBairro;
    }

    public void setBairro(Bairro mBairro) {
        this.mBairro = mBairro;
    }

    public Cidade getCidade() {
        return mCidade;
    }

    public void setCidade(Cidade mCidade) {
        this.mCidade = mCidade;
    }

    public Estado getEstado() {
        return mEstado;
    }

    public void setEstado(Estado mEstado) {
        this.mEstado = mEstado;
    }

    public Pais getPais() {
        return mPais;
    }

    public void setPais(Pais mPais) {
        this.mPais = mPais;
    }
}
