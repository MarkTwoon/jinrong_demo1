<template>
    <div id="header" class="header_main re">报名信息
        <a onclick="history.go(-1)" class="back"></a>
    </div>
    <div class="h60"></div>

    <div class="enrol re" style="height: 600px;">
        <img src="../assets/images/sign-in-bg.jpg"
             style="max-width: 750px;width: 100%;">
        <div class="sign-in"  id="registerDiv"  v-if="display ==='registerDiv'">
            <form  method="get" name="form1" id="registerForm" action="">
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
                        <input type="text" name="userRegisterPhone" id="userRegisterPhone" />
                        <span class="text-red">* 必填</span>
                    </div>
                    <div class="input1" style="line-height: 15px;height: 15px">
                        <span class="col1" style="visibility: hidden">隐藏：</span>
                        <span class="text-red" style="font-size: 13px;">注:手机号即用户名</span>
                    </div>
                    <!--密码-->
                    <div class="input1">
                        <span class="col1">密码：</span>
                        <input type="text" id="userRegisterPassWord"  name="userRegisterPassWord"   />
                        <span class="span-must-input text-red">* 必填</span>
                    </div>
                    <!--确认密码-->
                    <div class="input1">
                        <span class="col1" style="line-height: 20px;">确认<br/>密码：</span>
                        <input type="text" id="userRegisterPassWordTwo" name="userRegisterPassWordTwo"/>
                        <span class="text-red">* 必填</span>
                    </div>
                    <!--姓名-->
                    <div class="input1">
                        <span class="col1">姓名：</span>
                        <input type="text" name="userRegisterName" id="userRegisterName" />
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
                <a @click="formSubmit()">立即提交</a>
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
            <form method="get" name="form1" id="loginForm" action="" >
                <!--手机-->

                <!--<span style="color:red; margin-left:100px;" >${check0}</span>
                <input type="hidden" name="cityId" id="cityId"  value="${map0.cityId}">
                <input type="hidden" name="page" value="4">-->
                <div class="input1" style="margin-bottom: 4px;">
                    <span class="col1">手机：</span>                                       <!-- id编号, 检查参数类型，登录或注册类型  -->
                    <input type="text" name="userLoginPhone" value="" placeholder="请输入手机号"    id="userLoginPhone"/>
                    <span class="text-red">* 必填</span>
                </div>
                <div class="input1" style="line-height: 15px;height: 15px">
                    <span class="col1" style="visibility: hidden">隐藏：</span>
                    <span class="text-red" style="font-size: 13px;">注:手机号即用户名</span>
                </div>
                <!--密码-->
                <div class="input1">
                    <span class="col1">密码：</span>
                    <input type="password" name="userLoginPassWord" id="userLoginPassWord" placeholder="请输入登录密码" value=""  />
                    <span class="span-must-input text-red">* 必填</span>
                </div>

            </form>
            <div class="submit-btn"  style="width:40%;margin-top:0px; margin-left:60px;">
                <a @click="formSubmit()">立即提交</a>

            </div>
            <div class="submit-btn"    style="margin-right:6px;margin-top:-39px; width:30%;float:right;">
                <a   @click="goToDiv('registerDiv')">注册</a>
            </div>
        </div>


    </div>
</template>

<script>
  import "../assets/js/inputCheck/jquery.validate.min.js";
  import  "../assets/js/inputCheck/messages_zh.js";
    export default {
        name: "LoginPage",
        data(){
            return{
                display:this.$route.query.display,
                cityName:this.$route.query.cityName,
            }
        },mounted() {
            const _this=this;

            $(function () {
                _this.validFrom(_this.display);
            })

        },methods:{
            goToDiv:function(display){
                this.display=display;
                const _this=this;
                $(function () {
                    _this.validFrom(_this.display);
                })
            },
            formSubmit:function(){
            console.log(this.validFrom(this.display).form());
            },
            validFrom:function (display) {
                /*自定义 验证规范  定义正则演示*/
                $.validator.addMethod("checkUserLoginPhone", function (value, element) {
                    let tel = /^[0-9]{12}$/;
                    /*  return this.optional(element) || (tel.test(value));*/
                    return this.optional(element) || (tel.test(value));
                }, "此用户名手机号不存在");

                $.validator.addMethod("checkUserRegisterPhone", function (value, element) {
                    let tel = /^[0-9]{12}$/;
                    /*  return this.optional(element) || (tel.test(value));*/
                    return this.optional(element) || (tel.test(value));
                }, "此用户名手机号已存在");

                if(display==="loginDiv"){
                return $("#loginForm").validate({
                    /*花样触发验证*/
                    onfocusin: function (element) {
                        $(element).valid();
                    },
                    onfocusout: function (element) {
                        $(element).valid();
                    },
                    onclick: function (element) {
                        $(element).valid();
                    },
                    onkeyup: function (element) {
                        $(element).valid();
                    },
                    rules: {
                        userLoginPhone: {
                            /*表示为必填项*/
                            required: true,
                            /*表示为最小长度 需要达到*/
                            minlength: 11,
                            /*自定义 验证规则*/
                            checkUserLoginPhone: true,
                        },
                        userLoginPassWord: {
                            required: true,
                            minlength: 6,
                        }
                    },  /*提示信息管理*/
                    messages: {
                        userLoginPhone: {
                            required: "请输入登录用户名",
                            minlength: "手机号长度不能小于 11 位",
                        },
                        userLoginPassWord: {
                            required: "请输入登录密码",
                            minlength: "密码长度不能小于 6 位",
                        },
                        //提交表单后，（第一个）未通过验证的表单获得焦点
                        focusInvalid: true,
                        //当未通过验证的元素获得焦点时，移除错误提示
                        focusCleanup: true,
                    },

                });
            }else{

                    return $("#registerForm").validate({
                        /*花样触发验证*/
                        onfocusin: function (element) {
                            $(element).valid();
                        },
                        onfocusout: function (element) {
                            $(element).valid();
                        },
                        onclick: function (element) {
                            $(element).valid();
                        },
                        onkeyup: function (element) {
                            $(element).valid();
                        },
                        rules: {
                            userRegisterPhone: {
                                /*表示为必填项*/
                                required: true,
                                /*表示为最小长度 需要达到*/
                                minlength: 11,
                                /*自定义 验证规则*/
                                checkUserRegisterPhone: true,
                            },
                            userRegisterPassWord: {
                                required: true,
                                minlength: 6,
                            },
                            userRegisterPassWordTwo: {
                                required: true,
                                minlength: 6,
                                equalTo: "#userRegisterPassWord"
                            },
                            userRegisterName:{
                                required: true,
                                rangelength:[2,4],
                            }
                        },  /*提示信息管理*/
                        messages: {
                            userRegisterPhone: {
                                required: "请输入注册用户名",
                                minlength: "手机号长度不能小于 11 位",
                            },
                            userRegisterPassWord: {
                                required: "请输入注册密码",
                                minlength: "密码长度不能小于 6 位",
                            },
                            userRegisterPassWordTwo: {
                                required: "请输入注册确认密码",
                                minlength: "确认密码长度不能小于 6 位",
                                equalTo: "两次密码输入不一致",
                            },
                            userRegisterName:{
                                required: "请输入注册用户姓名",
                                rangelength:"用户姓名在2-4位之间"
                            },
                            //提交表单后，（第一个）未通过验证的表单获得焦点
                            focusInvalid: true,
                            //当未通过验证的元素获得焦点时，移除错误提示
                            focusCleanup: true,
                        },

                    });

                }
            }

        }
    }
</script>
<style scoped src="../assets/css/style7.css"></style>
<style scoped>
    .sign-in {  height: 68%;}
</style>