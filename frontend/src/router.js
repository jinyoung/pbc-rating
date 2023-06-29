
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import RatingManager from "./components/listers/RatingCards"
import RatingDetail from "./components/listers/RatingDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/ratings',
                name: 'RatingManager',
                component: RatingManager
            },
            {
                path: '/ratings/:id',
                name: 'RatingDetail',
                component: RatingDetail
            },



    ]
})
