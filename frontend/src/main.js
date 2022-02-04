import Vue from 'vue'
import App from './App.vue'
import router from "./router/index";
import firebase from 'firebase';
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)
Vue.config.productionTip = false

var firebaseConfig = {
  apiKey: "AIzaSyDqouMrWbJwJrpPLQS5JXIHbCeXRGeofPU",
  authDomain: "blog-339506.firebaseapp.com",
  projectId: "blog-339506",
  storageBucket: "blog-339506.appspot.com",
  messagingSenderId: "18503095621",
  appId: "1:18503095621:web:95b5922ccf13efa88fda2c",
  measurementId: "G-BL9HKQ7W4Y"
}

firebase.initializeApp(firebaseConfig);
new Vue({
    router,

    render: h => h(App),
}).$mount('#app')
