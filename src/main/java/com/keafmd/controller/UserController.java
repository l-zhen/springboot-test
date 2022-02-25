package com.keafmd.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keafmd.common.CommonResult;
import com.keafmd.entity.User;
import com.keafmd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 雷振
 * @since 2022-02-22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查找
     * @param modelMap
     * @param page
     * @param user
     * @return
     */
    @RequestMapping("/list")
    CommonResult list(ModelMap modelMap, Page page, @ModelAttribute("user") User user){
        page = userService.pageList(page,user);
        modelMap.addAttribute("page",page);
        return CommonResult.success(page);
    }
    @RequestMapping("/save")
    CommonResult save(User user){
        return CommonResult.success(userService.saveOrUpdate(user));
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @RequestMapping("/getById")
    CommonResult getById(Integer id){
        return CommonResult.success(userService.getById(id));
    }

    /**
     * 删除，逻辑删除
     * @param id
     * @return
     */
    @RequestMapping("/del")
    CommonResult del(Integer id){
        User user = userService.getById(id);
        user.setUserState("0");
        return CommonResult.success(userService.updateById(user));
    }

    /**
     * 批量删除
     * @param id
     * @return
     */
    @RequestMapping("/delByIds")
    CommonResult delByIds(Integer[] id){
        return CommonResult.success(userService.removeByIds(Arrays.asList(id)));
    }
}
