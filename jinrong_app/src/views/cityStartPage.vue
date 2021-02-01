<template>
    <div id="header" class="header_main">城市选择<a href="javascript:history.back();"  class="back"></a><a class="cd-popup-trigger button2"></a></div>
    <div class="h60"></div>



    <div class="container" >
        <div class="hotcity"  id="hotcity">
            <span>热门城市</span>

            <template  v-for="city in cityList">
            <a data-id='420100'  :href="'#/indexPage?cityId='+city.cityId">{{city.cityName}}</a>
            </template>
        </div>

        <div class="letter">
            <ul  id="ul0">

            </ul>
        </div>
    </div>
</template>

<script>
    import axios from 'axios/dist/axios.min.js';
    import qs from 'qs/dist/qs.js';
    import '../assets/js/zepto.js';
    export default {
        name: "cityStartPage",
        data(){
          return{
              cityList:[],
          }
        },
        mounted() {
            const _this=this;
            axios.post('/api/getCityData',{}).then(function (response) {
                const data=response.data;
                console.log(data.data);
                _this.cityList=data.data;
            });
        }
    }
</script>
<style scoped src="../assets/css/style.css">

</style>
<style scoped>

</style>