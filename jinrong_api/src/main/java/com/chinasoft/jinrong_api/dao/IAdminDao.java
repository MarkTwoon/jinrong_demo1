package com.chinasoft.jinrong_api.dao;

import java.util.List;
import java.util.Map;

public interface IAdminDao {
    public List<Map<String,Object>> selectUserPageWhere(Map<String,Object> map);

}
