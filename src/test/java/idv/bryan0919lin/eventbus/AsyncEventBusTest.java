package idv.bryan0919lin.eventbus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AsyncEventBusTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testPublish() throws InterruptedException {
        AsyncEventBus asyncEventBus = new AsyncEventBus(
                Executors.newCachedThreadPool());

        Map<String, String> r = new HashMap<>();
        asyncEventBus.subscribe("Test", (d) -> {
            r.put("Test", (String) d);
        });

        asyncEventBus.publish("Test", "QQ");

        Thread.sleep(500);

        assertNotNull(r.get("Test"));
        assertEquals("QQ", r.get("Test"));
    }
}
