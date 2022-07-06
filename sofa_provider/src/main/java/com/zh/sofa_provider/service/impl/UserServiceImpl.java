package com.zh.sofa_provider.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.zh.sofa_provider.pojo.User;
import com.zh.sofa_provider.mapper.UserMapper;
import com.zh.sofa_provider.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaohang
 * @since 2022-07-06
 */
@Service
@SofaService(bindings = { @SofaServiceBinding(bindingType = "bolt") })
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
