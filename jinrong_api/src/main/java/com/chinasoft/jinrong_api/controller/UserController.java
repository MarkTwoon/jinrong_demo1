package com.chinasoft.jinrong_api.controller;

import com.chinasoft.jinrong_api.exception.MyException;
import com.chinasoft.jinrong_api.util.FinalMsg;
import com.chinasoft.jinrong_api.util.ReturnData;
import com.chinasoft.jinrong_api.exception.StatusCode;
import com.chinasoft.jinrong_api.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    @RequestMapping(value = "/indexPageMainData",method = RequestMethod.POST)
    public Object indexPageMainData(HttpServletRequest request,
                                    @RequestParam Map<String,Object> map){
      /*根据城市ID编号 获取对应的城市活动页面 默认主信息并返回*/
        Map<String,Object> data=new HashMap<String,Object>();
        List<Map<String,Object>> indexData1=userService.selectIndexPageHeadNumber(map);
        List<Map<String,Object>> indexData2=userService.selectCityCouponByCityId(map);
        if(indexData1.size()>0&&indexData2.size()>0){
            data.put("indexData1",indexData1.get(0));
            data.put("indexData2",indexData2.get(0));
        }else{
        throw  new MyException(StatusCode.DATA_NULL,"该城市暂未开放商家活动");
        }
        /*data.put("indexData1",userService.selectIndexPageHeadNumber(map).get(0));
        data.put("indexData2",userService.selectCityCouponByCityId(map).get(0));*/
        /*打开主页面 则进行异步交互 判断是否已登录。
        * 若未登录 则session之中健值数据为null 返回前端页面  要求登录或注册*/
        data.put("userData",
                request.getSession().getAttribute(FinalMsg.SESSION_USERDATA));
      return  new ReturnData(StatusCode.REQUEST_SUCCESS,data,"检索城市活动数据信息正常！");
    }

    @RequestMapping(value = "/winUserData",method = RequestMethod.POST)
        public Object winUserData(@RequestParam Map<String,Object> map){
        List<Map<String,Object>> list=userService.selectSuccessUserList(map);
        if(list.size()<=0){
            throw  new MyException(StatusCode.DATA_NULL,"暂无参与用户获奖");
        }
    return  new ReturnData(StatusCode.REQUEST_SUCCESS,list,"查询获奖用户 数据成功！");
    }

    @RequestMapping(value = "/businessTypeAndGoodsData",method = RequestMethod.POST)
    public Object businessTypeAndGoodsData(@RequestParam Map<String,Object> map){
        /*执行ORM过程 返回查询结果集的list*/
    Map<String,Object> data=new HashMap<String,Object>();
    if(Integer.parseInt(map.get("markId")+"")==1){
        /*markId是axios的后端执行次数
        只需要在第一次axios中返回商家类型数据即可 后面均不执行该冗余 SQL指令 注意异步执行效率*/
  List<Map<String,Object>>  businessTypeList=userService.selectBusinessTypeList();
  data.put("businessTypeList",businessTypeList.size()<=0?"暂无商家类型数据":businessTypeList);
    }

   List<Map<String,Object>>  goodsList=userService.ActivitiesCouponListToIndex(map);
      data.put("goodsList",goodsList.size()<=0?"暂无优惠券信息数据":goodsList);
      return new ReturnData(StatusCode.REQUEST_SUCCESS,data,"查询商家类型 及优惠券数据成功");
    }

    @RequestMapping(value = "/checkUserMain",method = RequestMethod.POST,params = {"userPhone"})
    public Object checkUserMain(HttpServletRequest request,
                                @RequestParam Map<String,Object> map){
        List<Map<String,Object>> list=userService.selectUserNameAndPassWord(map);
          /*登录又分2块 表单验证与提交登录*/
        boolean msg=false;
        if(list.size()>0) {
            /*如果是提交登录的情况下 有结果集 session记录 登录用户*/
            if (map.containsKey("userPassWord")) {
                request.getSession().setAttribute(FinalMsg.SESSION_USERDATA,list.get(0));
            }
            msg=true;
        }else{
            msg=false;
        }
    return new ReturnData(StatusCode.REQUEST_SUCCESS,msg,"查询用户个人信息成功");
    }
}
