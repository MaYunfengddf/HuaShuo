window.onload = function (){
	new Vue({
		el: '#app',
		data: {
			
			message: 'Hello Vue.js1!',
			accountc: "请输入改订单对应的账号",
			key: "请输入订单对应全部商品的键",
			message2: 'Hello Vue.js2!',
			id: "请输入订单ID",
			message3: 'Hello Vue.js3!',
			accountc2: "请输入改订单对应的账号",
			key2: "请输入订单对应全部商品的键",
			id2: "请输入订单ID",
			message4: 'Hello Vue.js4!'
		},
		methods: {
			// 增
			login: function() {
				console.log(this.accontc + ":" + this.key);
				this.$http.post(
					rootPath + 'OrderWriting',
					{
						accountc: this.accountc,
						key: this.key,
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
					rootPath + 'OrderDelete',
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
					rootPath + 'OrderModify',
					{
						accountc: this.accountc2,
						key: this.key2,
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
				window.location.href="./orderQuery.html";
			},
		},
	})
}