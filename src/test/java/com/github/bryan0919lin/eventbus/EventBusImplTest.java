package com.github.bryan0919lin.eventbus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.github.bryan0919lin.eventbus.EventBusImpl;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EventBusImplTest {

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
    public void testPublish() {
        EventBusImpl eventBus = new EventBusImpl();

        Map<String, String> r = new HashMap<>();
        eventBus.subscribe("Test", d -> {
            r.put("Test", (String) d);
        });

        eventBus.publish("Test", "QQ");

        assertNotNull(r.get("Test"));
        assertEquals("QQ", r.get("Test"));
    }
}
