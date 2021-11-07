window.onload = function (){
	var vue = new Vue({
		el: '#app',
		// 筛选页面推荐
		data: {
			sites : [
							// {
							// 	accound:'111225',
							// 	phone:'221513',
							// 	address:'案发就哦啊',
							// 	name:'李白',
							// },
							// {
							// 	accound:'222222',
							// 	phone:'331513',
							// 	address:'几代ask才能系列课程教学总成绩发的是开发商的思考v模型几代ask才能系列课程教学总成绩发的是开发商的思考v模型几代ask才能系列课程教学总成绩发的是开发商的思考v模型几代ask才能系列课程教学总成绩发的是开发商的思考v模型几代ask才能系列课程教学总成绩发的是开发商的思考v模型',
							// 	name:'黧黑',
							// },
					],
		},
		methods: {
			addressQuery:function(){
				//发送 post 请求
				this.$http.post(
					rootPath + 'AddressQuery',
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
	
	vue.addressQuery();
}