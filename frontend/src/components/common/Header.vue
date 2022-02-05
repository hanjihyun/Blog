<template>
  <div id="app">

  <div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
        <h1>Blog</h1>
      </a>

      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
        <li><a href="#" class="nav-link px-2 link-secondary">Home</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">Features</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">Pricing</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">FAQs</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
      </ul>

      <div class="col-md-3 text-end">
        <button type="button" class="btn btn-dark">
        <router-link :to="{name: 'Login'}">Login</router-link>
        </button>

        <button type="button" class="btn btn-secondary">
        <router-link :to="{name: 'SignUp'}">Sign-up</router-link>
        </button>
      </div>
    </header>
  </div>
  </div>
</template>
<script>
export default {
    data() {
         return {

         };
    },
    methods: {

    }
}