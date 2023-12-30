<template>
    <div>
      <h1>카운터 뷰</h1>
      <button @click="incrementCounter">++</button>
      <CounterDisplay :count="counter" />
    </div>
  </template>
  
  <script>
  import CounterDisplay from './CounterDisplay.vue'
  
  export default {
    name: 'CounterView',
    components: { CounterDisplay },
    data() {
      return {
        counter: 0
      }
    },
    methods: {
      incrementCounter() {
        this.counter += 1;
      }
    }
  }
  </script>
  
  <style scoped>
  h1 { border-bottom: 1px solid gray; }
  button { margin: 20px 0; }
  </style>
  