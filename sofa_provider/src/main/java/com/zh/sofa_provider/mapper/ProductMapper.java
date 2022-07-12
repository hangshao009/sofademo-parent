package com.zh.sofa_provider.mapper;

import com.zh.sofa_provider.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaohang
 * @since 2022-07-12
 */
@Mapper
@Repository
@Component
public interface ProductMapper extends BaseMapper<Product> {

}
