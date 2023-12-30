<template>
    <div id="ProductCreateView">
      <h1>상품 등록</h1>
      <div>
        <input type="text" v-model="product.title" placeholder="상품명" />
      </div>
      <div>
        <input type="number" v-model="product.price" placeholder="가격" />
      </div>
      <div>
        <input type="text" v-model="product.category" placeholder="카테고리" />
      </div>
      <div>
        <button type="button" v-on:click="save">저장</button>
        <button type="button" v-on:click="goList">취소</button>
      </div>
    </div>
  </template>
  
  <script>
  import { insertProduct } from '../productService';
  
  export default {
    name: "ProductCreateView",
    data() {
      return {
        product: {}
      }
    },
    methods: {
      async save() {
        await insertProduct(this.product);
        this.goList();
      },
      goList() {
        this.$router.push("/");
      }
    }
  }
  </script>
  
  <style>
  input[type=text], input[type=number] { padding: 6px; width: 200px; }
  div { margin-bottom: 15px; }
  button { padding: 5px 20px; margin-right: 10px; }
  </style>
  