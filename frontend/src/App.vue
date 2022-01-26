<template>
 <div id="app">
     <!-- 추가된 헤더 컴포넌트 사용 -->
     <Header />

     <HelloWorld msg="Welcome to Your Vue.js App"/>

     <!-- 추가된 풋터 컴포넌트 사용 -->
     <Footer />
   </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

import Header from '@/components/common/Header.vue';
import Footer from '@/components/common/Footer.vue';
export default {
  name: 'app',
  components: {
  Header,
      Footer,
    HelloWorld
  }
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
