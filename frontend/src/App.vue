<template>
 <div id="app">
     <Header></Header>
         <div>
           <router-view></router-view>
         </div>
         <Footer></Footer>
   </div>
</template>

<script>
import Header from '@/components/common/Header.vue';
import Footer from '@/components/common/Footer.vue';
export default {
  name: 'app',
  components: {
    Header,
      Footer
  },
  mounted(){
    console.log(this.$firebase)
  },
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
