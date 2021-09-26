import Vue from 'vue/dist/vue.common';
import VueRouter from 'vue-router';
import App from './App';
import {routes} from './routes';

Vue.use(VueRouter);
Vue.config.productionTip = false;

const router = new VueRouter({
    routes,
    base: '/web/guest/home1/'
});

export default function (portletNamespace) {
    new Vue({
        el: `#${portletNamespace}-1`,
        router,
        template: '<App/>',
        components: {App}
    });
}
