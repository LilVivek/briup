package com.briup.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.briup.mybatisplusdemo.bean.Teacher;
import com.briup.mybatisplusdemo.bean.User;
import com.briup.mybatisplusdemo.mapper.TeacherMapper;
import com.briup.mybatisplusdemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
//        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }

    @Test
    public void test1() {
        User user = User.builder()
                .id(13l)
                .age(13)
                .email("ss")
                .name("a")
                .build();
        userMapper.insert(user);
        testSelect();
    }
    @Test
    public void test2() {
        User user = new User();
        User build = user.builder().age(13).name("20").id(14l).email("2").build();
        System.out.println(build);
//        userMapper.insert(user);
//        testSelect();
    }

    @Test
    public void update() {
        User user = User.builder().id(6l).name("zhangsan").build();
        userMapper.updateById(user);
    }

    @Test
    public void delete() {
        userMapper.deleteById(13);
        testSelect();
    }

    @Test
    public void select2() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        LambdaQueryChainWrapper<User> chainWrapper = new LambdaQueryChainWrapper<>(userMapper);
    }

    @Test
    public void select3() {
        //1.创建条件构造器对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //2.设置条件方法 where and or = != between and in()
//        wrapper.eq("name","jack").eq("age",18);
        wrapper.like(StringUtils.hasText("1"), "name", "zhang");
        //3.进行条件查询
        userMapper.selectList(wrapper);
    }

    @Test
    public void select4() {
        //select age,count(*) from xxx group by age
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.groupBy("age").select("age,count(*)");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void selectLambada(){
        //1.使用lambada条件构造器
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //2.设置条件 2个/3个
        wrapper.eq(User::getAge,18).eq(User::getEmail,"tmo@qq.ocm");
        userMapper.selectList(wrapper);
    }
    @Test
    public void selectChain(){
        LambdaQueryChainWrapper<User> wrapper = new LambdaQueryChainWrapper<>(userMapper);
        List<User> list = wrapper.isNull(User::getEmail).isNotNull(User::getName).list();

    }
    @Test
    public void selectChain2(){
        LambdaQueryChainWrapper<User> wrapper = new LambdaQueryChainWrapper<>(userMapper);
        User one = wrapper.isNull(User::getEmail).isNotNull(User::getName).one();

        new LambdaQueryChainWrapper<User>(userMapper);
    }
    @Test
    public void selectLambda2(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId,1);
        userMapper.selectCount(wrapper);
    }
    @Test
    public void update2(){
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",1).set("name","lisi");
        userMapper.update(null,wrapper);
//        userMapper.updateById()
    }
    @Test
    public void delete1(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName,"jack");
        userMapper.delete(wrapper);
        userMapper.deleteBatchIds(Arrays.asList(new int[]{8,9,10}));


    }
    @Test
    public void select5(){
        Teacher teacher = new Teacher();
        teacher.setName("123").setSalary(23.0);
        teacherMapper.insert(teacher);
        Page page = new Page<>(2, 2);
        Page page1 = teacherMapper.selectPage(page, null);
    }
}