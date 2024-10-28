package com.farmland.intel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.farmland.intel.controller.dto.UserPasswordDTO;
import com.farmland.intel.entity.User;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author
 * @since 2022-01-26
 */
public interface UserMapper extends BaseMapper<User> {

    @Update("update sys_user set password = #{newPassword} where username = #{username} and password = #{password}")
    int updatePassword(UserPasswordDTO userPasswordDTO);

}
