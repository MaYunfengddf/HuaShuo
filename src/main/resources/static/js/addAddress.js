 window.onload = function (){
 	var vue = new Vue({
 		el: '#app',
 		data: {
			message: 'Hello Vue.js1!',
			phone: "请输入收件人手机号",
			address: "请输入收件人地址",
			name: "请输入收件人姓名",
 			sites:[]
 		},
 		methods: {
 			// 客户地址
 			address2: function() {
 				this.$http.post(
 					rootPath + 'AddressQuery',
 				).then(function(res){
 					console.log(res);
 					this.sites = res.body;
 				}, function(res){
 					console.log(res.status);
 				});
 			},
 			//设置默认地址
 			setDefault(i,id2){
				console.log(this.sites[0]);
				console.log(this.sites[0].id);
				this.$http.post(
					rootPath + 'AddressModify2',
					{
						id: this.sites[0].id,
						default2: 1
					}
				).then(function(res){
					console.log(res);
					this.message = res.body.message
					console.log(this.message);
				}, function(res){
					console.log(res.status);
				});
				
 			    const sites = this.sites;
 			    sites.forEach((item, index) => {
 			        item.isDefault = index == i;
 			    });
 			    sites.splice(0, 0, ...sites.splice(i, 1));
				
				console.log(id2);
				this.$http.post(
					rootPath + 'AddressModify2',
					{
						id: id2,
						default2: 2
					}
				).then(function(res){
					console.log(res);
					this.message = res.body.message
					console.log(this.message);
				}, function(res){
					console.log(res.status);
				});
 			},
			// 增
			login: function() {
				console.log(this.phone +":" + this.address + ":" + this.name);
				this.$http.post(
					rootPath + 'AddressInput',
					{
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
			//修改转跳
			modify(id2){
				
			},
			// 删
			delete(id2) {
				console.log(id2);
				this.$http.post(
					rootPath + 'AddressDelete',
					{
						id: id2
					}
				).then(function(res){
					console.log(res);
					this.message2 = res.body.message
					console.log(this.message2);
				}, function(res){
					console.log(res.status);
				});
			},
 		}
 	});
	vue.address2();
	
 }