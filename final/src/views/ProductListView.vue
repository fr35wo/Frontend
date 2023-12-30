<template>
  <div id="ProductListView">
    <h1>상품 목록</h1>
    <button type="button" v-on:click="goCreate">등록</button>
    <table>
      <tr><td>ID</td><td>상품명</td><td>가격</td><td>카테고리</td></tr>
      <tr v-for="product in products" v-bind:key="product.id" v-on:click="goEdit(product.id)">
        <td>{{ product.id }}</td>
        <td>{{ product.title }}</td>
        <td>{{ product.price }}</td>
        <td>{{ product.category }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import { loadProducts } from '../productService';

export default {
  name: "ProductListView",
  data() {
    return {
      products: []
    }
  },
  async mounted() {
    this.products = await loadProducts();
  },
  methods: {
    goEdit(id) {
      this.$router.push("/edit/" + id);
    },
    goCreate() {
      this.$router.push("/create");
    },
  }
}
</script>

<style scoped>
button { float: right; margin-top: -40px; }
table { border-collapse: collapse; margin: 20px 0; width: 100%; }
tr:nth-child(1) { background-color: #eee; text-align: center; }
td { border: 1px solid gray; padding: 6px; }
td:nth-child(1) { text-align: center; width: 30px; }
tr:hover { background-color: #ffd; cursor: pointer }
</style>
