<template>
    <div>
      <input type="text" v-model="message" />
      <MyMessage :message="message" />
    </div>
  </template>
  
  <script>
  import MyMessage from './MyMessage.vue';
  
  export default {
    name: 'Exam3View',
    components: {
      MyMessage
    },
    data() {
      return {
        message: ''
      };
    },
  };
  </script>
  