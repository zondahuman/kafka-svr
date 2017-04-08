package com.abin.lee.kafka.consumer.test;

import com.abin.lee.kafka.common.util.JsonUtil;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by abin on 2017/4/8 2017/4/8.
 * kafka-svr
 * com.abin.lee.kafka.consumer.test
 */
@Getter
@Setter
public class ListTransferTest {

    public static void main(String[] args) {
        List<User> userList = Lists.newArrayList();
        for(int i=0;i<5;i++){
            User user = new User();
            user.setAddress("beijing"+i);
            user.setAge(i+20);
            user.setId("id-"+i);
            user.setName("abin"+i);
            userList.add(user);
        }
        System.out.println("userList="+ JsonUtil.toJson(userList));
        List<UserVo> userVoList = Lists.newArrayList();
        for(User user:userList){
            userVoList.forEach(item-> {item.setIds(user.getId());item.setUserAddress(user.getAddress());item.setUserAge(user.getAge());item.setUserName(user.getName());});
        }
        System.out.println("userVoList="+ JsonUtil.toJson(userVoList));
        System.out.println("-------------------------------------------------------------");
        userList.stream().forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println("user----="+JsonUtil.toJson(user));
            }
        });
        System.out.println("-------------------------------------------------------------");
        userList.forEach(item -> System.out.println(item.getAddress()+"," + item.getAge()+"," + item.getId()+"," + item.getName()));
        System.out.println("-------------------------------------------------------------");
        List<UserVo> userVoList1 = Lists.newArrayList();
        userList.forEach(item -> transfer(item,userVoList1));
        System.out.println("userVoList1="+ JsonUtil.toJson(userVoList1));
        System.out.println("-------------------------------------------------------------");

    }

    public static void transfer(User user, List<UserVo> response){
        response.forEach(item -> {item.setUserName(user.getName());item.setUserAge(user.getAge());item.setUserAddress(user.getAddress());item.setIds(user.getId());});
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
