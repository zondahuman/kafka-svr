package com.abin.lee.kafka.consumer.test;

import com.abin.lee.kafka.common.util.JsonUtil;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by abin on 2017/4/8 2017/4/8.
 * kafka-svr
 * com.abin.lee.kafka.consumer.test
 */
@Getter
@Setter
public class ListOperatorTest {

    public static void main(String[] args) {
        List<User> userList = Lists.newArrayList();
        for(int i=5;i>=0;i--){
//        for(int i=0;i<5;i++){
            User user = new User();
            user.setAddress("beijing"+i);
            user.setAge(i+20);
            user.setId("id-"+i);
            user.setName("abin"+i);
            userList.add(user);
        }
        System.out.println("userList1="+ JsonUtil.toJson(userList));
        userList.sort((User user1,User user2) -> user1.getAge().compareTo(user2.getAge()));
        System.out.println("userList2="+ JsonUtil.toJson(userList));


    }

    @Getter
    @Setter
    public static class User{
        private String id;
        private String name;
        private String address;
        private Integer age;
    }

    @Getter
    @Setter
    public static class UserVo{
        private String ids;
        private String userName;
        private String userAddress;
        private Integer userAge;
    }

}
