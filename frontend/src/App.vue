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
  name: 'App',
  components: {
    Header,
      Footer
  },

}
</script>


