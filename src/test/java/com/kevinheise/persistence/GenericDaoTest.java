package com.kevinheise.persistence;

import com.kevinheise.entity.Role;
import com.kevinheise.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericDaoTest {

    GenericDao userDao;
    GenericDao roleDao;

    @BeforeEach
    void setUp() {
        userDao = new GenericDao(User.class);
        roleDao = new GenericDao(Role.class);
    }

    @Test
    void getAllSuccess() {
        List<User> users = userDao.getAll();
        List<Role> roles = roleDao.getAll();
        assertEquals(3, users.size());
        assertEquals(3, roles.size());
    }

}