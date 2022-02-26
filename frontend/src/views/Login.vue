<template>
  <section>
  <body class="text-center">

<main class="form-signin">
  <form>
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

    <div class="form-floating">
      <input type="email" class="form-control" id="email" placeholder="name@example.com">
      <label for="email">Email address</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="password" placeholder="Password">
      <label for="password">Password</label>
    </div>

    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>

        <span><router-link :to="{name: 'SignUp'}">회원가입</router-link></span>
       <div id="my-signin2" ></div>
       <button @click="signout" align="left">signout</button>
    </form>
    </main>
  </body>
  </section>
</template>

<script>
import axios from "axios";
export default {
    data() {
         return {
              googleUser: null,
         };
    },
    mounted() {
       window.addEventListener('google-oauth-library-load', this.renderSignInButton);
     },
     methods: {
       renderSignInButton() {
         window.gapi.signin2.render('my-signin2', {
           scope: 'profile email',
           width: 240,
           height: 50,
           longtitle: true,
           theme: 'dark',
           onsuccess: this.onSuccess,
           onfailure: this.onFailure,
         });
       },
      onSuccess(googleUser) {
          console.log(googleUser);
          this.googleUser = googleUser.getBasicProfile();
          const url = '/user/tokenVerify';
          const params = new URLSearchParams();
          var authResponse = googleUser.getAuthResponse()
                      console.log(authResponse);
                      var id_token = authResponse.id_token;
                      console.log('JWT token (encrypted): ' + id_token);
                      console.log('JWT token (decrypted):');
          params.append('idToken', id_token);

            axios.post(url, params).then((res) => {
              // eslint-disable-next-line
              console.log(res);
            }).catch((error) => {
              // eslint-disable-next-line
              console.log(error);
            }).then(() => {
              // eslint-disable-next-line
              console.log('tokenVerify End!!');
              this.movePage();
            });

          console.log(googleUser.getBasicProfile().getId());
          console.log(googleUser.getBasicProfile().getName());
          console.log(googleUser.getBasicProfile().getGivenName());
          console.log(googleUser.getBasicProfile().getFamilyName());
          console.log(googleUser.getBasicProfile().getImageUrl());
          console.log(googleUser.getBasicProfile().getEmail());
      },
      movePage() {
            this.$router.push('/');
          },
      onFailure(error) {
          console.log(error);
      },
      signout() {
         const authInst = window.gapi.auth2.getAuthInstance();
         authInst.signOut().then(() => {

            console.log('User Signed Out!!!');
         });
      },
      }
}
</script>
<style scoped>
    section { display: flex; flex-direction: column; align-items: center; justify-content: center;  }
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