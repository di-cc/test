import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TestMongoDB {
    private static CountDownLatch latch = new CountDownLatch(1);


    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        JsonObject config = new JsonObject();
        config.put("connection_string","mongodb://127.0.0.1:27017/test");
        MongoClient mongoClient = MongoClient.createShared(vertx, config);

       /* JsonObject document = new JsonObject()
                .put("title", "The Hobbit");
        mongoClient.save("c_test", document, res -> {
            if (res.succeeded()) {
                String id = res.result();
                System.out.println("Saved book with id " + id);
            } else {
                res.cause().printStackTrace();
            }
        });*/

        /*JsonObject document = new JsonObject()
                .put("title", "The Hobbits")
                .put("_id", "123244");
        mongoClient.save("books", document, res -> {
            if (res.succeeded()) {
                String id = res.result();
                System.out.println("Saved book with id " + id);
            } else {
                res.cause().printStackTrace();
            }
        });*/

        /*JsonObject document = new JsonObject()
                .put("title", "The Hobbit")
                .put("_id", "123244");
        mongoClient.insert("books", document, res -> {
            if (res.succeeded()) {
                //...
            } else {
                System.out.println("Will fail if the book with that id already exists.");
            }
        });*/

       /* JsonObject query = new JsonObject();
        mongoClient.find("inventory", query, res -> {
            if (res.succeeded()) {
                for (JsonObject json : res.result()) {
                    System.out.println(json.encodePrettily());
                }
            } else {
                res.cause().printStackTrace();
            }
        });*/

        mongoClient.getCollections(res -> {
            if (res.succeeded()) {
                List<String> collections = res.result();
                collections.forEach(System.out::println);
            } else {
                res.cause().printStackTrace();
            }
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
