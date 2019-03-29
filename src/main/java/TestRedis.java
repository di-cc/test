import io.vertx.core.Vertx;
import io.vertx.redis.RedisClient;
import io.vertx.redis.RedisOptions;

public class TestRedis {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        RedisOptions config = new RedisOptions().setHost("127.0.0.1");
        RedisClient redis = RedisClient.create(vertx, config);
        redis.get("config:airports", res -> {
            if (res.succeeded()) {
                System.out.println(res.result());
                // so something...
            }
        });
        //just for test
    }
}
