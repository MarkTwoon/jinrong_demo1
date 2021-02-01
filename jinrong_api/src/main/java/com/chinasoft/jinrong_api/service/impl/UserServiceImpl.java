package com.chinasoft.jinrong_api.service.impl;

import com.chinasoft.jinrong_api.dao.IUserDao;
import com.chinasoft.jinrong_api.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
@Resource
    private IUserDao userDao;

    @Override
    public Object selectGoodsAll(String goodsId) {
        return userDao.selectGoodsAll(goodsId);
    }

    @Override
    public List<Map<String, Object>> selectCityMainByWhere(Map<String, Object> map) {
        return userDao.selectCityMainByWhere(map);
    }
}
