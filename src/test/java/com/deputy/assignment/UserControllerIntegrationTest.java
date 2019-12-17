package com.deputy.assignment;

import com.deputy.assignment.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerIntegrationTest {

    private UserController classUnderTest;

    @BeforeEach
    void setUp() {
        ApplicationInitializer applicationInitializer = new ApplicationInitializer("userdata.json","roledata.json");
        applicationInitializer.init();
        classUnderTest = applicationInitializer.getUserController();
    }

    @Test
    void should_find_2_subordinates_for_user_id_3() {
        List<User> subordinates = classUnderTest.getSubOrdinates(3);
        assertNotNull(subordinates);
        assertEquals(2, subordinates.size());
        assertEquals("Emily Employee", subordinates.get(0).getName());
        assertEquals("Steve Trainer", subordinates.get(1).getName());
    }

    @Test
    void should_find_4_subordinates_for_user_id_1() {
        List<User> subordinates = classUnderTest.getSubOrdinates(1);
        assertNotNull(subordinates);
        assertEquals(4, subordinates.size());

    }

    @Test
    void should_find_no_subordinates_for_user_id_2() {
        List<User> subordinates = classUnderTest.getSubOrdinates(2);
        assertNull(subordinates);

    }

    @Test
    void should_find_no_subordinates_for_unknown_user() {
        List<User> subordinates = classUnderTest.getSubOrdinates(20001);
        assertNull(subordinates);

    }
}