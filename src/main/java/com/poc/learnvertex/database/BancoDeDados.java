package com.poc.learnvertex.database;

import com.poc.learnvertex.entities.Entity;

import java.util.*;

public class BancoDeDados<T extends Entity> implements CrudBancoDados<T> {

  private Map<Integer, T> dados = new LinkedHashMap<>();

  @Override
  public void insert(T obj){
    dados.put(obj.getId(),obj);
  }


  @Override
  public void update(T obj){
    dados.put(obj.getId(),obj);
  }

  @Override
  public T findById(Integer id){
    return dados.get(id);
  }


  @Override
  public Set<T> findAll(){
    return new HashSet<>(dados.values());
  }

  @Override
  public void remove(Integer id){
    dados.remove(id);
  }

}
