
window.onload = function (){
	new Vue({
		el: '#app',
		data: {
			message: 'Hello Vue.js!',
			account: "请输入账号",
			password: "111",
			code: "9999"
		},
		methods: {
			regis: function() {
				console.log("AAAAAAAAAAA");
				window.location.href="./HuaShuoRegister.html";
			},
			login: function() {
				console.log(this.account + ":" + this.password);
				this.$http.post(
						rootPath + 'loginSystem',
					{
						account: this.account,
						password: this.password
					}
				).then(function(res){
					console.log(res);
					this.message = res.body.message
					console.log(this.message);
					this.code = res.body.code
					if(this.code == '0000'){
						window.location.href='./homepage.html';
					}
					
				}, function(res){
					console.log(res.status);
				});
			}
		}
	})
}