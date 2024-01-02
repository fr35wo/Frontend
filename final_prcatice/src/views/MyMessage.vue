<template>
    <div class="message-box">
      {{ message }}
    </div>
  </template>
  
  <script>
  export default {
    name: 'MyMessage',
    props: {
      message: {
        type: String,
        default: ''
      }
    }
  };
  </script>
  
  <style scoped>
  .message-box {
    background-color: yellow;
    padding: 10px;
    margin-top: 10px;
  }
  </style>
  