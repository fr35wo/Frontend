import { createRouter, createWebHistory } from 'vue-router'
import ProductListView from '../views/ProductListView.vue'
import ProductEditView from '../views/ProductEditView.vue'
import ProductCreateView from '../views/ProductCreateView.vue'
import CounterView from '../views/CounterView.vue'  // CounterView import

const routes = [
  {
    path: '/',
    name: 'ProductListView',
    component: ProductListView
  },
  {
    path: '/edit/:id',
    name: 'ProductEditView',
    component: ProductEditView
  },
  { path: '/create',
   name: 'ProductCreateView',
    component: ProductCreateView 
  },
  { path: '/exam1',
   name: 'CounterView',
    component: CounterView   // CounterView route
  },
]

const router = createRouter({ 
  history: createWebHistory(process.env.BASE_URL),
  routes 
})

export default router
