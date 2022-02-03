import Vue from 'vue'
import App from './App.vue'
import router from "./router";
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import './plugins/element.js'
import firebase from './plugins/firebase';
import vuetify from './plugins/vuetify'

Vue.use(BootstrapVue)
Vue.config.productionTip = false

firebase.analytics();
new Vue({
   router,
    vuetify,
  render: h => h(App),
}).$mount('#app')
