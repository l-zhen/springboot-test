package com.keafmd.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keafmd.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 * 分页查询代码
 * @author 雷振
 * @since 2022-02-22
 */
public interface UserService extends IService<User> {

    Page pageList(Page page,User user);

}
