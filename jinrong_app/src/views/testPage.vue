<template>
    <h2>????</h2>


    <div id ="app">
        <ul>
            <li v-for="(img,index) in list">

                <img style="width: 800px;height: 500px;" v-lazy="{src: img.src}" :key="'img'+index ">

            </li>

        </ul>

    </div>
</template>

<script>
import data from '../data.json';

    export default {
        name: "testPage",
        data(){
            return{
            name:'',
            age:'',
             submitStatus: null,
            }
        },mounted() {
            alert(data.urlMark);
           // axios.post(data.urlMark+'??Controller',{})
        },methods:{

        },
         computed: {
            list:function(){
                var list1=[];
                var num=0;
                var num1=120;
                for(var i=0;i<=num1;i++){

                    if(num>=4){
                        num=0;

                    }
                    num++;

                    var map={src:require('../assets/img/'+num+".jpg")};

                    list1.push(map);
                }
                return list1;
            }

        }


    }
     </script>

<style scoped  >

</style>