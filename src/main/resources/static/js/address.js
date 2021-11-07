window.onload = function (){
	new Vue({
		el: '#app',
		data: {
			
			message: 'Hello Vue.js1!',
			accountd: "请输入收件人账号",
			phone: "请输入收件人手机号",
			address: "请输入收件人地址",
			name: "请输入收件人姓名",
			message2: 'Hello Vue.js2!',
			id: "请输入收件地址ID",
			message3: 'Hello Vue.js3!',
			accountd1: "请输入收件人账号",
			phone1: "请输入收件人手机号",
			address1: "请输入收件人地址",
			name1: "请输入收件人姓名",
			id1: "请输入收件人ID",
			message4: 'Hello Vue.js4!'
		},
		methods: {
			// 增
			login: function() {
				console.log(this.accountd + ":" + this.phone +":" + this.address + ":" + this.name);
				this.$http.post(
					rootPath + 'AddressInput',
					{
						accountd: this.accountd,
						phone: this.phone,
						address: this.address,
						name: this.name
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
					rootPath + 'AddressDelete',
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
				console.log(this.phone +":" + this.address + ":" + this.name+ ":" + this.id);
				this.$http.post(
					rootPath + 'AddressModify',
					{
						phone: this.phone1,
						address: this.address1,
						name: this.name1,
						id: this.id1
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
				window.location.href="./addressQuery.html";
			},
		},
	})
}