window.onload = function (){
	new Vue({
		el: '#app',
		data: {
			
			message: 'Hello Vue.js1!'
		},
		methods: {
			regis1: function() {
				console.log("AAAAAAAAAAA");
				window.location.href="./customer.html";
			},
			regis2: function() {
				console.log("AAAAAAAAAAA");
				window.location.href="./order.html";
			},
			regis3: function() {
				console.log("AAAAAAAAAAA");
				window.location.href="./AllGoods.html";
			},
			regis4: function() {
				console.log("AAAAAAAAAAA");
				window.location.href="./address.html";
			},
		},
	})
}