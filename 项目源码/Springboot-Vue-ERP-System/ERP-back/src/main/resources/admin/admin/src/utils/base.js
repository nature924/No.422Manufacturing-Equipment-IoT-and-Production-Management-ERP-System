const base = {
    get() {
        return {
            url : "http://localhost:8080/zizhaozhuanbeiwulianjishengcan/",
            name: "zizhaozhuanbeiwulianjishengcan",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zizhaozhuanbeiwulianjishengcan/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "制造装备物联及生产管理ERP系统"
        } 
    }
}
export default base
