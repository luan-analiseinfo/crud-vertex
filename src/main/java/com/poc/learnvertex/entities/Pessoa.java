package com.poc.learnvertex.entities;

public class Pessoa implements Entity {

  private Integer id;
  private String nome;

  public Pessoa(){}

  public Pessoa(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public Integer getId() {
    return id;
  }

}
