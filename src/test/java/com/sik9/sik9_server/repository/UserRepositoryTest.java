package com.sik9.sik9_server.repository;

import com.sik9.sik9_server.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void CRUD() {
        Users user = new Users("qwer@naver.com", "1234", "John", "seoul");
        userRepository.save(user);

        Users find = userRepository.findByEmail("qwer@naver.com").get();

        assertThat(find.getEmail()).isEqualTo(user.getEmail());
        assertThat(find.getPassword()).isEqualTo(user.getPassword());
        assertThat(find.getName()).isEqualTo(user.getName());
        assertThat(find.getAddress()).isEqualTo(user.getAddress());
    }
}