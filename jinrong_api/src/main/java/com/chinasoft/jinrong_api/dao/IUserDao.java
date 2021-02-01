package com.chinasoft.jinrong_api.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IUserDao {                       /*传String参数的 形式参数注解
                                                             String其参数值 无须强制转换 容错率更高*/
public List<Map<String,Object>> selectGoodsAll(@Param(value="goodsId") String goodsId);
public List<Map<String,Object>> selectCityMainByWhere(Map<String,Object> map);
public List<Map<String,Object>>  selectIndexPageHeadNumber(Map<String,Object> map);
public List<Map<String,Object>> selectCityCouponByCityId(Map<String,Object> map);
}
