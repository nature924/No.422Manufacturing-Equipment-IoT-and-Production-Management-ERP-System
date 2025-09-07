import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import cailiao from '@/views/modules/cailiao/list'
    import cailiaoChuruInout from '@/views/modules/cailiaoChuruInout/list'
    import cailiaoChuruInoutList from '@/views/modules/cailiaoChuruInoutList/list'
    import chanpin from '@/views/modules/chanpin/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gukedingdan from '@/views/modules/gukedingdan/list'
    import shebei from '@/views/modules/shebei/list'
    import shebeijianxiu from '@/views/modules/shebeijianxiu/list'
    import shengcanjihua from '@/views/modules/shengcanjihua/list'
    import weixiuyuan from '@/views/modules/weixiuyuan/list'
    import yonghu from '@/views/modules/yonghu/list'
    import zhiljiankong from '@/views/modules/zhiljiankong/list'
    import dictionaryBumen from '@/views/modules/dictionaryBumen/list'
    import dictionaryCailiao from '@/views/modules/dictionaryCailiao/list'
    import dictionaryCailiaoChuruInout from '@/views/modules/dictionaryCailiaoChuruInout/list'
    import dictionaryChanpin from '@/views/modules/dictionaryChanpin/list'
    import dictionaryGukedingdan from '@/views/modules/dictionaryGukedingdan/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryShebei from '@/views/modules/dictionaryShebei/list'
    import dictionaryShengcanjihua from '@/views/modules/dictionaryShengcanjihua/list'
    import dictionaryStatus from '@/views/modules/dictionaryStatus/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBumen',
        name: '部门',
        component: dictionaryBumen
    }
    ,{
        path: '/dictionaryCailiao',
        name: '材料类型',
        component: dictionaryCailiao
    }
    ,{
        path: '/dictionaryCailiaoChuruInout',
        name: '出入库类型',
        component: dictionaryCailiaoChuruInout
    }
    ,{
        path: '/dictionaryChanpin',
        name: '产品类型',
        component: dictionaryChanpin
    }
    ,{
        path: '/dictionaryGukedingdan',
        name: '订单状态',
        component: dictionaryGukedingdan
    }
    ,{
        path: '/dictionarySex',
        name: '性别',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryShebei',
        name: '设备类型',
        component: dictionaryShebei
    }
    ,{
        path: '/dictionaryShengcanjihua',
        name: '计划状态',
        component: dictionaryShengcanjihua
    }
    ,{
        path: '/dictionaryStatus',
        name: '设备状态',
        component: dictionaryStatus
    }


    ,{
        path: '/cailiao',
        name: '材料信息',
        component: cailiao
      }
    ,{
        path: '/cailiaoChuruInout',
        name: '出入库',
        component: cailiaoChuruInout
      }
    ,{
        path: '/cailiaoChuruInoutList',
        name: '出入库详情',
        component: cailiaoChuruInoutList
      }
    ,{
        path: '/chanpin',
        name: '产品信息',
        component: chanpin
      }
    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/gukedingdan',
        name: '顾客订单',
        component: gukedingdan
      }
    ,{
        path: '/shebei',
        name: '设备信息',
        component: shebei
      }
    ,{
        path: '/shebeijianxiu',
        name: '设备检修',
        component: shebeijianxiu
      }
    ,{
        path: '/shengcanjihua',
        name: '生产计划',
        component: shengcanjihua
      }
    ,{
        path: '/weixiuyuan',
        name: '维修员',
        component: weixiuyuan
      }
    ,{
        path: '/yonghu',
        name: '员工',
        component: yonghu
      }
    ,{
        path: '/zhiljiankong',
        name: '质量监控',
        component: zhiljiankong
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
