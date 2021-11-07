window.onload = function (){
	var vue = new Vue({
		el: '#app',
		// 筛选页面推荐
		data: {
			sites : [
					// {id: "12",
					// images: "../images/huawei01.png",
					// model: "MateBook X Pro",
					// name: "华为笔记本",
					// price: "9999"},{
					// id: "13",
					// images: "../images/huawei02.png",
					// model: "MateBook X Pro ",
					// name: "华为笔记本",
					// price: "9999"},{
					// id: "14",
					// images: "../images/huawei03.png",
					// model: "  MateBook D 14",
					// name: "华为笔记本",
					// price: "4099"},
				],
			},
		// 里面定义一个方法
		methods: {
			default: function (event){
				var url = rootPath + "HomePageQuery";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			//添加购物车
			login(id) {
				this.$http.post(
					rootPath + 'ShoppingCartInput',
					{
						key: id
					}
				).then(function(res){
					console.log(res);
					console.log(this.message2);
					alert("添加成功");
				}, function(res){
					console.log(res.status);
				});
			},
			// 价格搜索
			price1: function (event){
				var url = rootPath + "CommodityInquiryPrice?price1=1&price2=4999";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			price2: function (event){
				var url = rootPath + "CommodityInquiryPrice?price1=5000&price2=7999";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			price3: function (event){
				var url = rootPath + "CommodityInquiryPrice?price1=8000&price2=11999";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			price4: function (event){
				var url = rootPath + "CommodityInquiryPrice?price1=12000&price2=9999999999";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			
			// 型号搜索
			model: function (event){
				var url = rootPath + "CommodityInquiryModel?model=灵耀";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			model1: function (event){
				var url = rootPath + "CommodityInquiryModel?model=VivoBook15";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			model2: function (event){
				var url = rootPath + "CommodityInquiryModel?model=天选2";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			model5: function (event){
				var url = rootPath + "CommodityInquiryModel?model=Redmibook";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			model6: function (event){
				var url = rootPath + "CommodityInquiryModel?model=adolbook";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			model7: function (event){
				var url = rootPath + "CommodityInquiryModel?model=MateBook";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			model8: function (event){
				var url = rootPath + "CommodityInquiryModel?model=Redmibook";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			model9: function (event){
				var url = rootPath + "CommodityInquiryModel?model=Pro X 15";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			
			//名字搜索
			greet: function (event){
				var url = rootPath + "CommodityInquiryName?name=华硕";
				
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			
			greet2: function (event) {
				var url = rootPath + "CommodityInquiryName?name=小米";
					
					
				//发送get请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			greet3: function (event) {
				var url = rootPath + "CommodityInquiryName?name=华为";
				
				
				//发送get请求
				this.$http.get(url)
				.then(
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
	vue.default();
}


	// 背景变色
	$(document).ready(function(){
	  $(".p1").mouseenter(function(){
		$(".p1").css("background-color","yellow");
	  });
	  $(".p1").mouseleave(function(){
		$(".p1").css("background-color","white");
	  });
	});
	