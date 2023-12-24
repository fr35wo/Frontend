<template>
  <div id="App">
  <select v-model="color">
    <option value="#ffe">yellow</option>
    <option value="#efe">green</option>
    <option value="#fee">red</option>
    <option value="#eef">blue</option>
  </select>
  <p />
  <input type="text" v-model="message" />
  <hr />
  <MyMessage :bgColor="color" :text="message" /> 
</div>
</template>

<script>
import MyMessage from './Mymessage.vue'

export default {
  name: 'App',
  data() {
    return {
      color: '#ffe',
      message: 'Hello'
    }
  },
  components: {
    MyMessage
  }
}
</script>

<style>
div#App{
  border: 1px solid gray; padding: 20px;
  box-shadow: 5px 5px 5px gray; 
  width: 400px;
}
select {
  padding: 4px; width: 100px;
}
input{
  padding: 4px;
}
hr{
  margin: 20px 0;
}
</style>
