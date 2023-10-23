package 随手test例子;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class TestRedis {

    @Test
    public void connRedis() {
        Jedis jedis = new Jedis("121.5.151.73", 6379);
        jedis.auth("zxc123");
        //jedis.set("k1", "v1");
        System.out.println(jedis.get("k2"));
    }
}
