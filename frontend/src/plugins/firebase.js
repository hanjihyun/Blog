import 'firebase/auth';
import firebase from 'firebase/app';

const firebaseConfig = {
  apiKey: "AIzaSyCbqWrC1PCPzgqOClz4jnsCgBD19kZJT-Y",
  authDomain: "my-blog-341302.firebaseapp.com",
  projectId: "my-blog-341302",
  storageBucket: "my-blog-341302.appspot.com",
  messagingSenderId: "155279474103",
  appId: "1:155279474103:web:01952c2fcc0158bd5dbc32",
  measurementId: "G-M1L2J15Q52"
};

firebase.initializeApp(firebaseConfig);

export const auth = firebase.auth();