import Vue from 'vue'
import App from './App.vue'
import router from "./router";
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import './plugins/element.js'
import GAuth from 'vue-google-oauth2'
Vue.use(BootstrapVue)
Vue.use(GAuth, {clientId: '18503095621-5nr55k6ulpaigcjc129aundrhf4tldd6.apps.googleusercontent.com', scope: 'profile email https://www.googleapis.com/auth/plus.login'})

Vue.config.productionTip = false

new Vue({
   router,
  render: h => h(App),
}).$mount('#app')
