
window.onload = function (){
	new Vue({
		el: '#app',
		data: {
			message: 'Hello Vue.js!',
			account: "请输入账号",
			password: "111",
			router:'11212',
			code: "9999",
			sites:[
					{
						id:"2",
						name2: "华硕笔记本",
						model: "飞行堡垒",
						size: "12英寸",
						type: "办公笔记本",
						processor: "i7",
						memory: "512G",
						harddisk: "SSD",
						colour: "冰晶银",
						price: "8888",
						images:"../images/huashuo08.jpg",
						
						express:"快递 免邮",
						hoTime:"24:00前付款，,预计10月24日送达"
					},
					{
						id:"5",
						name2: "华硕笔记本",
						model: "飞行堡垒",
						size: "12英寸",
						type: "办公笔记本",
						processor: "i7",
						memory: "512G",
						harddisk: "SSD",
						colour: "冰晶银",
						price: "8888",
						images:"../images/huashuo08.jpg",
						
						express:"快递 免邮",
						hoTime:"24:00前付款，,预计10月24日送达"
					},
					{
						id:"8",
						name2: "华硕笔记本",
						model: "飞行堡垒",
						size: "12英寸",
						type: "办公笔记本",
						processor: "i7",
						memory: "512G",
						harddisk: "SSD",
						colour: "冰晶银",
						price: "8888",
						images:"../images/huashuo08.jpg",
						
						express:"快递 免邮",
						hoTime:"24:00前付款，,预计10月24日送达"
					},
				],
		},
		methods: {
			money(id) {
				if(typeof(Storage)!=="undefined"){
					sessionStorage.clickcount= "AAAA";
					//跳转
					window.location.href="./new_file2.html";
					//封装 网页传值
					sessionStorage.setItem('queryParam',JSON.stringify(id))
				}
				else{
					document.getElementById("result").innerHTML="抱歉，您的浏览器不支持 web 存储";
				}
			},
		}
	})
}