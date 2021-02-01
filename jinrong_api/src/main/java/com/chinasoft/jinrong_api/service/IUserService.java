package com.chinasoft.jinrong_api.service;

import java.util.List;
import java.util.Map;

public interface IUserService {
    public Object selectGoodsAll(String goodsId);
    public List<Map<String,Object>> selectCityMainByWhere(Map<String,Object> map);
    public List<Map<String,Object>>  selectIndexPageHeadNumber(Map<String,Object> map);
    public List<Map<String,Object>> selectCityCouponByCityId(Map<String,Object> map);
}
