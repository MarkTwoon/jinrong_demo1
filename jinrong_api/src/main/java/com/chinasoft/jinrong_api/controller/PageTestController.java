package com.chinasoft.jinrong_api.controller;

import com.chinasoft.jinrong_api.service.IAdminService;
import com.chinasoft.jinrong_api.service.IUserService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("test")
public class PageTestController {
    @Resource
    private IAdminService adminService;

@RequestMapping("page")
public Object getUserPageWhere(@RequestParam Map<String,Object> map){
    /*注意  2个分页的必要参数   page limit*/
    List<Map<String,Object>> list=adminService.selectUserPageWhere(map);
    PageInfo<Map<String,Object>> pageInfo=new PageInfo<Map<String,Object>>(list);
    map.put("list",list);
    /*第三个参数  为查询list的聚合最大值*/
       map.put("total",pageInfo.getTotal());
       return map;
}

}
