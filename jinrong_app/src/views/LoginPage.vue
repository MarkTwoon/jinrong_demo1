<template>
    <div id="header" class="header_main re">报名信息
        <a onclick="history.go(-1)" class="back"></a>
    </div>
    <div class="h60"></div>

    <div class="enrol re" style="height: 600px;">
        <img src="../assets/images/sign-in-bg.jpg"
             style="max-width: 750px;width: 100%;">
        <div class="sign-in"  id="registerDiv"  v-if="display ==='registerDiv'">
            <form  method="get" name="form1" id="form1" action="">
                <div class="input1" style="margin-bottom: 4px;">
                    <div class="tabCity">确认优惠城市：<span id="tabCity">{{cityName}}</span> <a class="tab"  href="/">[切换城市]</a>
                    </div>
                    <!--手机-->
                   <!-- <span style="color:red; margin-left:100px;" id="spancheck">${check0}</span>
                    <input type="hidden" name="cityId" value="${cityId}">
                    <input type="hidden" name="couponId" value="${couponId}">
                    <input type="hidden" name="page" value="4">-->
                    <div class="input1" style="margin-bottom: 4px;">
                        <span class="col1">手机：</span>
                        <input type="text" name="userRegisterPhone" id="userRegisterPhone" onblur="loginCheck('userRegisterPhone','input','registerDiv');"/>
                        <span class="text-red">* 必填</span>
                    </div>
                    <div class="input1" style="line-height: 15px;height: 15px">
                        <span class="col1" style="visibility: hidden">隐藏：</span>
                        <span class="text-red" style="font-size: 13px;">注:手机号即用户名</span>
                    </div>
                    <!--密码-->
                    <div class="input1">
                        <span class="col1">密码：</span>
                        <input type="text" id="userRegisterPassWord0"  name="userRegisterPassWord0"    onblur="loginCheck('userRegisterPassWord','input','registerDiv');"/>
                        <span class="span-must-input text-red">* 必填</span>
                    </div>
                    <!--确认密码-->
                    <div class="input1">
                        <span class="col1" style="line-height: 20px;">确认<br/>密码：</span>
                        <input type="text" id="userRegisterPassWord" name="userRegisterPassWord" onblur="loginCheck('userRegisterPassWord','input','registerDiv');"/>
                        <span class="text-red">* 必填</span>
                    </div>
                    <!--姓名-->
                    <div class="input1">
                        <span class="col1">姓名：</span>
                        <input type="text" name="userRegisterName" id="userRegisterName"  onblur="loginCheck('userRegisterName','input','registerDiv');"/>
                        <span class="text-red">* 必填</span>
                    </div>
                    <!--邮箱-->
                    <!--  <%--<div class="input1">--%>
                         <%--<span class="col1">邮箱：</span>--%>
                         <input type="hidden" name="userEmail" id="userEmail" value="0"/>
                          <%--<span class="text-red"></span>--%>
                     <%--</div>--%> -->
                </div>
            </form>
            <div class="submit-btn" style="width:40%;margin-top:0px; margin-left:37px;">
                <a onclick="loginCheck('PassWordName','submit','registerDiv');">立即提交</a>
                <!--  &nbsp;&nbsp;&nbsp;&nbsp;<a style="color:gray;float:right;" onclick="insertUser();">已有账户？</a>-->
                <!-- <a style="color:gray;float:right;" onclick="history.go(-1)">返回</a>-->
            </div>
            <div class="submit-btn"    style="margin-right:10px;margin-top:-39px; width:30%;float:right;">
                <a   @click="goToDiv('loginDiv')">已有账户</a>
            </div>

            <p style="text-align: center; line-height: 32px; font-size: 14px; color:#585858;margin-left:40px;margin-top:13px;"> 查看当前 <a style="text-decoration: underline; color:#585858;" href="selectCityActivitiesById.action?cityId=${cityId}">城市优惠券</a>信息</p>
            <p style="text-align: center;">友情提示：请牢记用户名和密码。</p>

            <!--   <p style="text-align: center; line-height: 32px; font-size: 14px; color:#585858;">注册所属城市：<a style="text-decoration: underline; color:#585858;" href="selectCityByInsertUser.action?cityId=${cityId}">${map1.cityName}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点击查看当前所属 ${map1.cityName}<a style="text-decoration: underline; color:#585858;" href="selectCityActivitiesById.action?cityId=${cityId}">城市优惠券</a> 信息</p> -->

        </div>



        <!-- 登录用  form表单 div区域 -->

        <div class="sign-in"  id="loginDiv"   v-else>
            <form method="get" name="form1" id="form2" action="" >
                <!--手机-->

                <!--<span style="color:red; margin-left:100px;" >${check0}</span>
                <input type="hidden" name="cityId" id="cityId"  value="${map0.cityId}">
                <input type="hidden" name="page" value="4">-->
                <div class="input1" style="margin-bottom: 4px;">
                    <span class="col1">手机：</span>                                       <!-- id编号, 检查参数类型，登录或注册类型  -->
                    <input type="text" name="userLoginPhone" value="" onblur="loginCheck('userLoginPhone','input','loginDiv');"   id="userLoginPhone"/>
                    <span class="text-red">* 必填</span>
                </div>
                <div class="input1" style="line-height: 15px;height: 15px">
                    <span class="col1" style="visibility: hidden">隐藏：</span>
                    <span class="text-red" style="font-size: 13px;">注:手机号即用户名</span>
                </div>
                <!--密码-->
                <div class="input1">
                    <span class="col1">密码：</span>
                    <input type="password" name="userPassWord" id="userLoginPassWord" value=""  onblur="loginCheck('userLoginPassWord','input','loginDiv');"/>
                    <span class="span-must-input text-red">* 必填</span>
                </div>

            </form>
            <div class="submit-btn"  style="width:40%;margin-top:0px; margin-left:60px;">
                <a onclick="loginCheck('PassWord','submit','loginDiv');">立即提交</a>

            </div>
            <div class="submit-btn"    style="margin-right:6px;margin-top:-39px; width:30%;float:right;">
                <a   @click="goToDiv('registerDiv')">注册</a>
            </div>
        </div>


    </div>
</template>

<script>
    export default {
        name: "LoginPage",
        data(){
            return{
                display:this.$route.query.display,
                cityName:this.$route.query.cityName,
            }
        },methods:{
            goToDiv:function(display){
                this.display=display;
            }
        }
    }
</script>
<style scoped src="../assets/css/style7.css"></style>
<style scoped>
    .sign-in {  height: 68%;}
</style>