package com.poc.learnvertex.resources;

import com.poc.learnvertex.services.PessoaService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class PessoaResource extends AbstractVerticle {

  private PessoaService pessoaService = new PessoaService();

  public PessoaResource(){
  }
/*

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new PessoaResource());
  }
*/

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    Router router = Router.router(vertx);
    router.get("/pessoas").handler(pessoaService::obterTodos);
    router.get("/pessoas/:id").handler(pessoaService::obterById);
    router.delete("/pessoas/:id").handler(pessoaService::deletar);
    router.post("/pessoas").handler(BodyHandler.create()).handler(pessoaService::criar);
    router.put("/pessoas/:id").handler(BodyHandler.create()).handler(pessoaService::editar);

    vertx.createHttpServer().requestHandler(router).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }

}
