package com.chinasoft.jinrong_api.controller;

import com.chinasoft.jinrong_api.exception.MyException;
import com.chinasoft.jinrong_api.util.ReturnData;
import com.chinasoft.jinrong_api.exception.StatusCode;
import com.chinasoft.jinrong_api.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {
   @Resource
   private IUserService userService;

  @RequestMapping("/test")
   public Object test(@RequestParam Map<String,Object> map){
System.out.println(map);
     System.out.println(map);
     return  new ReturnData(StatusCode.REQUEST_SUCCESS,
             userService.selectGoodsAll(map.get("goodsId")+""),"后端数据交互正常！");
  }

    @RequestMapping(value = "/getCityData",method = RequestMethod.POST)
    public Object getCityData(@RequestParam Map<String,Object> map){
       /* System.out.println(map);  IOC调用ORM 数据持久化 json信息传输 略
        System.out.println(map);*/
       List<Map<String,Object>> list=userService.selectCityMainByWhere(map);
        if(list.size()>0){
            return  new ReturnData(StatusCode.REQUEST_SUCCESS,
                    list,"查询城市数据交互正常！");
        }else{
            throw new MyException(StatusCode.DATA_NULL,"抱歉，暂无城市数据选择！");
        }
      /*  return  new ReturnData(StatusCode.REQUEST_SUCCESS,
                "后端数据API返回数据正常","后端数据交互正常！");*/
    }


}
