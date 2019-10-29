import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const router = new VueRouter({
    routes: [{
        path: '',
        component: () => import('../components/Layout.vue'),
        children: [{
                path: '/',
                component: () => import('../pages/Main.vue')
            },
            {
                path: '/goods/category',
                component: () => import('../pages/goods/Category')
            },
            {
                path: '/goods/brand',
                component: () => import('../pages/goods/Brand')
            }
        ]
    }]
})

// 权限验证
router.beforeEach((to, from, next) => {
    next()
})

export default router;