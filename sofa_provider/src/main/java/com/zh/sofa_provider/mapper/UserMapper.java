package com.zh.sofa_provider.mapper;

import com.zh.sofa_provider.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhaohang
 * @since 2022-07-06
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {


}
