import Vue from 'vue'
import Router from 'vue-router'

import Home from '../pages/Home.vue';
import UserPosts from '../pages/Posts.vue'
import UserProfile from '../pages/Profile.vue'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home,
            children: [
                {

                    path: 'profile',
                    component: UserProfile
                },
                {
                    path: 'posts',
                    component: UserPosts
                }
            ]
        }
    ]
})