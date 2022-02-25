package com.keafmd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keafmd.entity.User;
import com.keafmd.mapper.UserMapper;
import com.keafmd.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 * 实现分页查询和模糊查找
 * @author 雷振
 * @since 2022-02-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Page pageList(Page page, User user) {
        if (page == null){
            page = new Page();
        }

        QueryWrapper wrapper = new QueryWrapper();
        if (user != null && StringUtils.isNotEmpty(user.getUserName())){
            //根据user_name字段模糊查找
            wrapper.like("user_name",user.getUserName());
        }

        return super.page(page,wrapper);
    }
}
