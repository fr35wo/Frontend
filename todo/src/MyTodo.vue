<template>
  <div>
    <h1>할 일</h1>
    <table>
      <tr><td>ID</td><td>기한</td><td>할일</td></tr>
      <tr v-for="todo in todos" v-bind:key="todo.id" v-bind:class="{done: todo.done}">
        <td>{{ todo.id }}</td>
        <td>{{ todo.dueDate }}</td>
        <td>
          <input type="checkbox" v-model="todo.done" v-on:click="toggleTodo(todo)"/>
          {{ todo.title }}
          <span v-on:click="deleteTodo(todo.id)">x</span>
        </td>
      </tr>
    </table>
    <input type="text" v-model="title" placeholder="할 일을 입력하세요" />
    <input type="date" v-model="dueDate" />
    <button type="button" v-on:click="addTodo">추가</button>
  </div>
</template>


<script>
import axios from 'axios';

axios.defaults.baseURL = "http://localhost:3000";

export default {
  name: "MyTodo",
  data() {
    return {
      todos: [ ],
      title: "",
      dueDate: ""
    }
  },
  mounted() {
    this.reloadTodos();
  },
  methods: {
    async reloadTodos() {
      try {
        const response = await axios.get("/todos");
        this.todos = response.data;
      } catch (error) {
        alert('조회 에러: ' + (error instanceof Error ? error.message : error));
      }
    },
    async addTodo() {
      try {
        const todo = {id: 0, title: this.title, dueDate: this.dueDate };
        await axios.post("/todos", todo);
        this.reloadTodos();
        this.title = "";
        this.dueDate = "";
      } catch (error) {
        alert('저장 에러: ' + (error instanceof Error ? error.message : error));
      }
    },
    async deleteTodo(id) {
      try {
        if (confirm("삭제하시겠습니까?") == false) return;
        await axios.delete("/todos/" + id);
        this.reloadTodos();
      } catch (error) {
        alert('삭제 에러: ' + (error instanceof Error ? error.message : error));
      }
    },
    async toggleTodo(todo) {
      try {
        todo.done = !todo.done;
        await axios.put("/todos/" + todo.id, todo);
        this.reloadTodos();
      } catch (error) {
        alert('저장 에러: ' + (error instanceof Error ? error.message : error));
      }
    },
  }
}
</script>

<style scoped>
h1 { border-bottom: 1px solid gray; }
div { padding: 30px; margin: 30px auto; width: 550px; border: 1px solid #ccc; box-shadow: 3px 3px 3px #aaa; }
table { border-collapse: collapse; margin: 20px 0; width: 100%; }
tr:nth-child(1) { background-color: #eee; text-align: center; }
td { border: 1px solid gray; padding: 6px; }
td:nth-child(1) { text-align: center; width: 30px; }
input[type=text] { padding: 5px; margin-right: 5px; width: 300px; }
button { padding: 0.3em 1.5em; }
span { font-weight: bold; margin-left: 10px; cursor: pointer; float: right; }
tr.done { background-color: #f8f8f8; color: #bbb; text-decoration: line-through; }
input[type=checkbox] { accent-color: #bbb; }
</style>
