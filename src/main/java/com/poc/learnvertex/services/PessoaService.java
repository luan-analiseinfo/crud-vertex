package com.poc.learnvertex.services;

import com.poc.learnvertex.communs.HttpStatusCode;
import com.poc.learnvertex.database.BancoDeDados;
import com.poc.learnvertex.database.CrudBancoDados;
import com.poc.learnvertex.entities.Pessoa;

import static com.poc.learnvertex.communs.HeadersConstants.*;

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class PessoaService {

  private CrudBancoDados<Pessoa> db;


  public PessoaService() {
    init();
  }


  private void init() {
    db = new BancoDeDados<>();
    db.insert(new Pessoa(1, "Luan lucas"));
    db.insert(new Pessoa(2, "Matheus Henrique"));
    db.insert(new Pessoa(3, "Gabriel Carvalho"));
  }


  public void editar(RoutingContext routingContext) {
    final String id = routingContext.request().getParam("id");
    JsonObject json = routingContext.getBodyAsJson();
    if (id == null || json == null) {
      routingContext.response().setStatusCode(HttpStatusCode.BAD_REQUEST).end();
    } else {
      final Integer idAsInteger = Integer.valueOf(id);
      Pessoa pessoa = db.findById(idAsInteger);
      if (pessoa == null) {
        routingContext.response().setStatusCode(HttpStatusCode.NOT_FOUND).end();
      } else {
        pessoa = Json.decodeValue(json.encodePrettily(), Pessoa.class);
        db.update(pessoa);
        routingContext.response()
          .putHeader(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8)
          .end(Json.encodePrettily(pessoa));
      }
    }
  }

  public void criar(RoutingContext routingContext) {
    final Pessoa pessoa = Json.decodeValue(routingContext.getBodyAsString(), Pessoa.class);
    db.insert(pessoa);

    routingContext.response()
      .setStatusCode(201)
      .putHeader(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8)
      .end(Json.encodePrettily(pessoa));
  }

  public void deletar(RoutingContext routingContext) {
    String id = routingContext.request().getParam("id");
    if (id == null) {
      routingContext.response().setStatusCode(HttpStatusCode.BAD_REQUEST).end();
    } else {
      Integer idAsInteger = Integer.valueOf(id);
      db.remove(idAsInteger);
    }
    routingContext.response().setStatusCode(204).end();
  }


  public void obterById(RoutingContext routingContext) {
    final String id = routingContext.request().getParam("id");
    if (id == null) {
      routingContext.response().setStatusCode(HttpStatusCode.BAD_REQUEST).end();
    } else {
      final Integer idAsInteger = Integer.valueOf(id);
      Pessoa pessoa = db.findById(idAsInteger);
      if (pessoa == null) {
        routingContext.response().setStatusCode(404).end();
      } else {
        routingContext.response()
          .putHeader(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8)
          .end(Json.encodePrettily(pessoa));
      }
    }
  }

  public void obterTodos(RoutingContext routingContext) {
    routingContext.response()
      .putHeader(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8)
      .end(Json.encodePrettily(db.findAll()));
  }
}
