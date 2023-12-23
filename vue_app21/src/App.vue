<template>
  <div id="app">
    <h1>MyCounter2</h1>
    <MyCounter2 title="카운터2" description="첫째 컴포넌트" color="#ffb" v-on:send="showValue" />
    <MyCounter2 title="카운터2" color="#afa" v-on:send="showValue" />
    <p>{{ textValue }}</p> <!-- 추가: 'textValue'를 화면에 출력 -->
  </div>
</template>

<script>
import MyCounter2 from './MyCounter2.vue'

export default {
  name: "App",
  data() {
    return {
      textValue: "" // 'text' 이벤트로 받은 문자열을 저장할 변수
      };
    },
    methods: {
      showValue(value) {
        this.textValue = value; // 'text' 이벤트로 받은 값을 textValue에 저장
      }
    },
    components: { MyCounter2 }
  }

</script>

<style scoped>
div#app {
  padding: 0 30px 30px 30px;
  margin: 30px auto;
  max-width: 400px;
  border: 1px solid #ccc;
  box-shadow: 3px 3px 3px #aaa;
}
</style>
