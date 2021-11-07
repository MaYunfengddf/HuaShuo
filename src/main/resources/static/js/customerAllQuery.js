window.onload = function (){
	var vue = new Vue({
		el: '#app',
		// 筛选页面推荐
		data: {
			sites : [],
		},
		methods: {
			allQuery:function(){
				this.$http.post(
					rootPath + 'CustomerInquiry2'
				).then(function(res){
					console.log(res);
					this.sites = res.body; 
				}, function(res){
					console.log(res.status);
				});
			},
		}
	});
	
	vue.allQuery();
}