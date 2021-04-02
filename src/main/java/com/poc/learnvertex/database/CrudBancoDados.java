package com.poc.learnvertex.database;

import com.poc.learnvertex.entities.Entity;

import java.util.Set;

public interface CrudBancoDados<T extends Entity> {
  void insert(T obj);

  void update(T obj);

  T findById(Integer id);

  Set<T> findAll();

  void remove(Integer id);
}
