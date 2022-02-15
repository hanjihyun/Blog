<template>
  <section>
  <body class="text-center">

<main class="form-signin">
  <form>
    <h1 class="h3 mb-3 fw-normal">Please sign Up</h1>

    <div class="form-floating">
      <input type="name" class="form-control" v-model="name" placeholder="Name">
      <label for="name">Name</label>
    </div>

    <div class="form-floating">
      <input type="email" class="form-control" v-model="email" placeholder="name@example.com">
      <label for="email">Email address</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="password" placeholder="Password">
      <label for="password">Password</label>
    </div>
    <div class="blank mb-3"></div>

    <button @click="checkSignUp" class="w-100 btn btn-lg btn-primary" type="submit">Sign Up</button>
    <span><router-link :to="{name: 'Login'}">로그인</router-link>으로 돌아가기</span>
  </form>
</main>



  </body>
  </section>
</template>
<script>
import axios from "axios";
    export default{
        name:'signUp',
        components: {
          },
        data(){
            return {
                name:'',
                email:'',
                password:'',
            }
        },
        methods:{
        checkSignUp(){
          let err = true;
          let msg = '';
          !this.name &&
            ((msg = '이름을 입력해주세요'),
            (err = false),
            this.$refs.name.focus());
          err &&
            !this.email &&
            ((msg = '이메일을 입력해주세요'), (err = false), this.$refs.email.focus());
          err &&
            !this.password &&
            ((msg = '비밀번호를 입력해주세요'),
            (err = false),
            this.$refs.password.focus());
          if (!err) alert(msg);
          else this.createHandler();
        },
            createHandler(){
                console.log("signUp", this.name,this.email, this.password);
            }
        }
    }

</script>
<style scoped>
    section {
        display: flex;
        flex-direction:
        column;
        align-items:
        center;
        justify-content:
        center;
        }
    .bd-placeholder-img {
         font-size: 1.125rem;
         text-anchor: middle;
         -webkit-user-select: none;
         -moz-user-select: none;
         user-select: none;
         }
    @media (min-width: 768px) {
         .bd-placeholder-img-lg {
            font-size: 3.5rem;
         }
         }
</style>