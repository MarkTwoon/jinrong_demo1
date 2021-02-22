package com.chinasoft.jinrong_api.service;

import java.util.List;
import java.util.Map;

public interface IAdminService {
    public List<Map<String,Object>> selectUserPageWhere(Map<String,Object> map);
}
