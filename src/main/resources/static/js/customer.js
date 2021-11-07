window.onload = function (){
	new Vue({
		el: '#app',
		data: {
			
			message: 'Hello Vue.js1!',
			accounta: "请输入新增客户的账号",
			name: "请输入新增客户名字",
			message2: 'Hello Vue.js2!',
			id: "请输入删除客户ID",
			message3: 'Hello Vue.js3!',
			accounta2: "请输入修改客户的账号",
			name2: "请输入修改客户名字",
			id2: "请输入修改客户ID",
			message4: 'Hello Vue.js4!'
		},
		methods: {
			// 增
			login: function() {
				console.log(this.acconta + ":" + this.name);
				this.$http.post(
					rootPath + 'CustomerWrite',
					{
						accounta: this.accounta,
						name: this.name,
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
					rootPath + 'CustomerDelete',
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
				console.log(this.accounta2 + ":" + this.name2 + ":" + this.id2);
				this.$http.post(
					rootPath + 'CustomerModify',
					{
						accounta: this.accounta2,
						name: this.name2,
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
				window.location.href="./customerQuery.html";
			},
			regisall: function() {
				console.log("AAAAAAAAAAA");
				window.location.href="./customerAllQuery.html";
			},
		},
	})
}