package com.zh.sofa_provider.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zh.sofa_comm.pojo.Product;
import com.zh.sofa_comm.service.providerService;
import com.zh.sofa_provider.mapper.ProductMapper;
import com.zh.sofa_provider.mapper.UserMapper;
import com.zh.sofa_provider.pojo.User;
import com.zh.sofa_provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Component
@SofaService(interfaceType = providerService.class,
        bindings = { @SofaServiceBinding(bindingType = "bolt") })
public class providerServiceImpl implements providerService{
    @Autowired
    UserService userService;

    @Resource
    UserMapper userMapper;
    @Resource
    ProductMapper productMapper;
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
    @DS("master")
    public boolean InsertUser(@PathVariable("name") String name, @PathVariable("age") int age, @PathVariable("email") String email) {
            User user = new User();
            user.setEmail(email);
            user.setAge(age);
            user.setName(name);
            userMapper.insert(user);
            return true;
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

    @Override
    @DS("slave1")
    public Product getProductInfo(Long id) {
        return productMapper.selectById(id);
    }

    @Override
    @Transactional
    public void updateProduct(int price) {

        Product product = productMapper.selectById(1);
        product.setPrice(product.getPrice()-10);
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",product.getId());
        productMapper.update(product,updateWrapper);
    }
}
