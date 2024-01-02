<template>
    <div>
      <h1>Exam1</h1>
      <div class="todo-container">
        <div v-for="todo in todos" :key="todo.id" class="todo-item">
          {{ todo.title }}
        </div>
      </div>
      <input type="text" v-model="title" />
      <button type="button" @click="addTodo">추가</button>
    </div>
  </template>
  
  <script> 
  export default { 
    name: 'Exam1View' ,
    data() {
      return {
        todos: [
          { id: 1, title: "zero" },
          { id: 2, title: "one" },
          { id: 3, title: "two" }
        ],
        title: "",
        lastId: 3
      };
    },
    methods: {
      addTodo: function() {
        const newTodo = { id: ++this.lastId, title: this.title };
        this.todos.push(newTodo);
        this.title = "";
      }
    }
  };
  </script>
  
  <style scoped>
  h1 {
    border-bottom: 1px solid gray;
  }
  
  div {
    padding: 30px;
    margin: 30px auto;
    width: 400px;
    border: 1px solid #ccc;
    box-shadow: 3px 3px 3px #aaa;
  }
  
  .todo-container {
    display: flex;
    flex-direction: row;
    justify-content: start;
    gap: 20px;
    margin: 20px 0;
  }
  
  .todo-item {
    padding: 10px;
    border: 1px solid gray;
  }
  
  input[type=text] {
    padding: 5px;
    margin-right: 5px;
    width: 300px;
  }
  
  button {
    padding: 0.3em 1.5em;
  }
  </style>
  