package com.demo;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class ServiceTest {

    private final UserMapper userMapper;

    @Test
    void testSelect() {
        log.warn(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        assertThat(userList)
                .hasSize(5)
                .isNotEmpty();
        userList.forEach(user -> log.info(user.toString()));
    }
}
