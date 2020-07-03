import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '@/routers/Main'
import Home from '@/routers/Home'
import About from '@/routers/About'
import ListBlog from '@/routers/ListBlog'
import Blog from '@/routers/Blog'

Vue.use(VueRouter)

export default new VueRouter({
  routes: [

    {
      path: '/',
      name: 'Main',
      component: Main,
      children: [
        {
          path: '',
          name: 'Home',
          component: Home
        },
        {
          path: '/list_blog/:id',
          name: 'List Blog',
          component: ListBlog
        },
        {
          path: '/blog/:id',
          name: 'Blog',
          component: Blog
        },
        {
          path: '/about',
          name: 'About',
          component: About
        }
      ]
    }
  ]
})
