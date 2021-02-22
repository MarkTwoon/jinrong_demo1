package com.chinasoft.jinrong_api.service.impl;

import com.chinasoft.jinrong_api.dao.IAdminDao;
import com.chinasoft.jinrong_api.dao.IUserDao;
import com.chinasoft.jinrong_api.service.IAdminService;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements IAdminService {
    @Resource
    private IAdminDao adminDao;

    @Override
    public List<Map<String, Object>> selectUserPageWhere(Map<String, Object> map) {
        /*在Service的Impl之中  进行后端 持久层  插件执行调用*/
        PageHelper.startPage(Integer.parseInt(map.get("page")+"")
                ,Integer.parseInt(map.get("limit")+"")," userId desc");
        return adminDao.selectUserPageWhere(map);
    }
}
