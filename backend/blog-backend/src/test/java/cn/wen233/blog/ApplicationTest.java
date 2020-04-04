package cn.wen233.blog;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author: huu
 * @date: 2020/3/30 16:09
 * @description:
 *
 *      加上@ExtendWith(MockitoExtension.class)才能使用@mock
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ApplicationTest {
}
