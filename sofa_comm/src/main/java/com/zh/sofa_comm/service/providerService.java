package com.zh.sofa_comm.service;

import com.zh.sofa_comm.pojo.User;

public interface providerService {
    public String UpdateUserInfo(Long id);

    public boolean InsertUser(String name,int age,String email);
    public boolean DeleteUserInfo(Long id);
    public Object getUserInfo(Long id);

    public Object getProductInfo(Long id);
}
