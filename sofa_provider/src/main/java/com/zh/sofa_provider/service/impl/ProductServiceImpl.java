package com.zh.sofa_provider.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.zh.sofa_provider.pojo.Product;
import com.zh.sofa_provider.mapper.ProductMapper;
import com.zh.sofa_provider.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaohang
 * @since 2022-07-12
 */
@Service
@DS("slave1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
