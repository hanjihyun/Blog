import Vue from "vue";
import Router from "vue-router";
import Index from "@/views/Index";
import Login from "@/views/Login";
import SignUp from "@/views/SignUp";
Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        {
            path: "/",
            name: "Index",
            component: Index,
        },
        {
            path: '*',
            name: '404',
            component: () => import('@/views/error/404.vue'),
        },
        {
            path: "/login",
            name: "Login",
            component: Login,
        },
        {
             path: "/signUp",
             name: "SignUp",
             component: SignUp,
        },

    ]
});
