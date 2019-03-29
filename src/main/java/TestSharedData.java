import io.vertx.core.Vertx;
import io.vertx.core.shareddata.LocalMap;

public class TestSharedData {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.sharedData().getLocalMap("test").put("name","hello");
        LocalMap map = vertx.sharedData().getLocalMap("test");
        System.out.println(map.get("name"));
    }
}
