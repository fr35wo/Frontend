<template>
    <div>
      <h2>{{ count }}</h2>
    </div>
  </template>
  
  <script>
  export default {
    name: 'CounterDisplay',
    props: ['count']
  }
  </script>
  
  <style scoped>
  h2 { font-size: 2em; }
  </style>
  