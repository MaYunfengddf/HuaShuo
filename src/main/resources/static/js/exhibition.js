window.onload = function (){
	var vue = new Vue({
		el: '#app',
		// 筛选页面推荐
		data: {
			sites : [
					// {	cat:1,
					// 	accountb: '55555',
					// 	colour: '幻彩白',
					// 	harddisk: 'SSD',
					// 	id: '1',
					// 	images: '../images/huashuo17.jpg',
					// 	key: '11',
					// 	memory: '512G',
					// 	model: 'adolbook14s 锐炬版',
					// 	name: '华硕笔记本',
					// 	price: '4499',
					// 	processor: '11代i5',
					// 	quantity: '38',
					// 	size: '14英寸',
					// 	time: '2021-09-17 11:50:24',
					// 	type: '金属潮色轻薄办公笔记本电脑',
					// 	num:1}
				],
			},
		// 里面定义一个方法
		methods: {
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
			sum() {
			    // let sum = 0;
			    // this.checkGroup.forEach((value) => {
			    //     sum += value.price * value.num;
			    // });
			    // return sum;
					
					
			    return this.sites.reduce((previousValue, value) => {
			        console.log(this.sites);
			        console.log(value);
			        return previousValue += value.price * value.num;
			    }, 0);
			},
			// 查询指定id
			regis: function() {
				var id2 = JSON.parse(sessionStorage.getItem('queryParam'));
					console.log(id2);
				this.$http.post(
					rootPath + 'AllGoodsInquiry2',
					{
						id: id2
					}
				).then(function(res){
					console.log(res);
					this.sites = res.body; 
				}, function(res){
					console.log(res.status);
				});
			},
		}
	});
	vue.regis();
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
	