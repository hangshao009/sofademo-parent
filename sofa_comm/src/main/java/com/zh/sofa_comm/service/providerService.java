package com.zh.sofa_comm.service;

import com.zh.sofa_comm.pojo.Product;

public interface providerService {
    public String UpdateUserInfo(Long id);

    public boolean InsertUser(String name,int age,String email);
    public boolean DeleteUserInfo(Long id);
    public Object getUserInfo(Long id);

    public Product getProductInfo(Long id);
    public void updateProduct(int id);
}
