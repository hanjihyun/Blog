import Vue from 'vue'
import firebase from 'firebase/app';
import 'firebase/auth';
import 'firebase/firebase-database' // database
import firebaseConfig from '@/plugins/firebaseConfig'

firebase.initializeApp(firebaseConfig)

Vue.prototype.$firebase = firebase
