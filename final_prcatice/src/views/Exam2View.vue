<template>
    <div>
      <h1>Exam 2</h1>
      <table>
        <tr v-for="(todo, index) in todos" v-bind:key="todo.id">
          <td>{{ todo.title }}</td>
          <td><button v-on:click="deleteTodo(index)">삭제</button></td>
        </tr>
      </table>
      <input type="text" v-model="title" />
      <button type="button" v-on:click="addTodo">추가</button>
    </div>
  </template>
  
  <script> 
  export default { 
    name: 'Exam2View' ,
    data() {
      return {
        todos: [
          {title: "zero"},
          {title: "one"},
          {title: "two"},
        ],
        title: "",
        lastId: 0
      };
    },
    methods: {
      addTodo: function() {
        this.todos.push({id: ++this.lastId, title: this.title});
        this.title = "";
      },
      deleteTodo(index) {
        if (confirm("삭제하시겠습니까?")) this.todos.splice(index, 1);
      }
    }
  } 
  </script>
  
  <style scoped>
  h1 { border-bottom: 1px solid gray; }
  div { padding: 30px; margin: 30px auto; width: 400px; border: 1px solid #ccc; box-shadow: 3px 3px 3px #aaa; }
  table { border-collapse: collapse; margin: 20px 0; width: 100%; }
  td { border: 1px solid gray; padding: 6px; }
  input[type=text] { padding: 5px; margin-right: 5px; width: 300px; }
  button { padding: 0.3em 1.5em; }
  </style>
  