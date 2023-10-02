package jp.ac.jec.characterView;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jp.ac.jec.characterView.entity.po.User;
import jp.ac.jec.characterView.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class DBTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Page<User> userPage = userMapper.selectPage(new Page<>(1, 2), wrapper);
        Assert.isTrue(2 == userPage.getSize(), "");
        userPage.getRecords().forEach(System.out::println);
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }
}
