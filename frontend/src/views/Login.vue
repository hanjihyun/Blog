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
    <div class="g-signin2" data-width="300" data-height="200" data-longtitle="true">GoogleLogin</div>
  </form>
</main>



  </body>
  </section>
</template>

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