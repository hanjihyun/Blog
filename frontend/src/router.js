import Vue from "vue";
import Router from "vue-router";
import Index from "./views/Index";
import Login from "./views/Login";
import SignUp from "./views/SignUp";
Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        {
            path: "/",
            name: "Index",
            components: Index

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
