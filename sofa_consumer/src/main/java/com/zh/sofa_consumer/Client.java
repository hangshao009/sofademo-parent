package com.zh.sofa_consumer;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.zh.sofa_provider.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zh.sofa_comm.service.*;


@RestController
@ComponentScan(basePackages = {"com.zh.sofa_provider.mapper.UserMapper"})
public class Client {
    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"))
    private providerService providservice;
    @RequestMapping("/update")
    public String update(long id) {
        try {
            User user = new User();
            user.setName("zhaohang");
            user.setId(id);
            providservice.UpdateUserInfo(id);
            return "Finish";
        }catch (Exception e){
            e.printStackTrace();
            return "ERROR";
        }
    }
    @RequestMapping("/delete")
    public String delete(long id) {
        try {
            User user = new User();
            user.setId(id);
            providservice.DeleteUserInfo(id);
            return "Finish";
        }catch (Exception e){
            e.printStackTrace();
            return "ERROR";
        }
    }
    @RequestMapping("/get")
    public Object get(long id) {
        try {
            return providservice.getUserInfo(id);
        }catch (Exception e){
            e.printStackTrace();
            return "ERROR";
        }
    }
    @RequestMapping("/insert")
    public String insert(@Param("name") String name, @Param("age")int age,@Param("email") String email) {
        try {
            providservice.InsertUser(name,age,email);
            return "Finish";
        }catch (Exception e){
            e.printStackTrace();
            return "ERROR";
        }
    }
}
