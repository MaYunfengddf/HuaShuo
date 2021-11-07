window.onload = function (){
	new Vue({
		el: '#app',
		data: {
			
			message: 'Hello Vue.js1!',
			recommend: "请输入主页推荐对应全部商品的键",
			message2: 'Hello Vue.js2!',
			id: "请输入主页推荐ID",
			message3: 'Hello Vue.js3!',
			recommend2: "请输入主页推荐对应全部商品的键",
			id2: "请输入主页推荐ID",
			message4: 'Hello Vue.js4!'
		},
		methods: {
			// 增
			login: function() {
				console.log(this.accontc + ":" + this.key);
				this.$http.post(
					'http://localhost:8080/huashuo/HomePageInput',
					{
						recommend: this.recommend
					}
				).then(function(res){
					console.log(res);
					this.message = res.body.message
					console.log(this.message);
				}, function(res){
					console.log(res.status);
				});
			},
			// 删
			login2: function() {
				console.log(this.id);
				this.$http.post(
					'http://localhost:8080/huashuo/HomePageDelete',
					{
						id: this.id
					}
				).then(function(res){
					console.log(res);
					this.message2 = res.body.message
					console.log(this.message2);
				}, function(res){
					console.log(res.status);
				});
			},
			// 改
			login3: function() {
				console.log(this.accountc2 + ":" + this.key2 + ":" + this.id2);
				this.$http.post(
					rootPath + 'HomePageModify',
					{
						recommend: this.recommend2,
						id: this.id2
					}
				).then(function(res){
					console.log(res);
					this.message3 = res.body.message
					console.log(this.message3);
				}, function(res){
					console.log(res.status);
				});
			},
			regis: function() {
				console.log("AAAAAAAAAAA");
				window.location.href="./HomepageMaintenanceQuery.html";
			},
		},
	})
}