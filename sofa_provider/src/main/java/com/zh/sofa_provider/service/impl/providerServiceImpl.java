package com.zh.sofa_provider.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.zh.sofa_comm.service.providerService;
import com.zh.sofa_provider.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@SofaService(interfaceType = providerService.class,
        bindings = { @SofaServiceBinding(bindingType = "bolt") })
public class providerServiceImpl implements providerService{
    @Autowired
    UserServiceImpl userService;
    @Override
    public String UpdateUserInfo(@PathVariable("id")Long id) {
        try{
            User user= new User();
            user.setId(id);
            user.setName("zhaohang");
            userService.updateById(user);
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @Override

    public boolean InsertUser(@PathVariable("name") String name, @PathVariable("age") int age, @PathVariable("email") String email) {
        try{
            User user = new User();
            user.setEmail(email);
            user.setAge(age);
            user.setName(name);
            userService.save(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean DeleteUserInfo(@PathVariable("id")Long id) {
        try{
            userService.removeById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserInfo(@PathVariable("id")Long id) {
        return userService.getById(id);
    }
}
