package com.fastdelivery.model;

import com.fastdelivery.interfaces.Custo;

public abstract class EntregadorAbstrato implements Custo
{
    protected String nomeFuncionario;
    protected String cpfFuncionario;

    public EntregadorAbstrato(String nomeFuncionario, String cpfFuncionario)
    {
        this.nomeFuncionario = nomeFuncionario;
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getNomeFuncionario() {
        return this.nomeFuncionario;
    }

    public String getCpfFuncionario() {
        return this.cpfFuncionario;
    }
}
