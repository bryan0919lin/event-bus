package idv.bryan0919lin.eventbus;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EventBusFactoryTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        EventBusConfig.setEventBus(new EventBusImpl());
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testGetEventBus() {
        EventBus r = EventBusFactory.getEventBus();
        assertTrue(r instanceof EventBusImpl);
    }

    @Test
    public void testGetAsyncEventBus() {
        EventBusConfig.setEventBus(new AsyncEventBus(Executors.newCachedThreadPool()));
        EventBus r = EventBusFactory.getEventBus();
        assertTrue(r instanceof AsyncEventBus);
    }
}
