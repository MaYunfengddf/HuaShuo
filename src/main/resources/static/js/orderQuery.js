window.onload = function (){
	var vue = new Vue({
		el: '#app',
		// 筛选页面推荐
		data: {
			sites : [],
		},
		methods: {
			orderQuery:function(){
				//发送 post 请求
				this.$http.post(
					rootPath + 'OrderQuery',
					{emulateJSON:true}
				).then(
					function(res){
						console.log(res);
						this.sites = res.body;   
					},
					function(){
						console.log('请求失败处理');
					}
				);
			}
		}
	});
	
	vue.orderQuery();
}