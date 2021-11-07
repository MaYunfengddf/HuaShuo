window.onload = function (){
	var vue = new Vue({
		el: '#app',
		// 筛选页面推荐
		data: {
			isAll: false,
			checkGroup: [],
			lists:[	
					// {
					// 	cat:1,
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
					// 	num:1
					// },
					// {
					// 	cat:1,
					// 	accountb: '55555',
					// 	colour: '山川黛',
					// 	harddisk: 'SSD',
					// 	id: '2',
					// 	images: '../images/huashuo08.jpg',
					// 	key: '1',
					// 	memory: '512G',
					// 	model: '灵耀14S',
					// 	name: '华硕笔记本',
					// 	price: '5499',
					// 	processor: '11代i5',
					// 	quantity: '75',
					// 	size: '14英寸',
					// 	time: '2020-08-17 11:40:24',
					// 	type: '轻薄长续航办公笔记本电脑',
					// 	num:1
					// },
				],
		},
		methods: {
			cart:function(){
				//发送 post 请求
				this.$http.post(
					rootPath + 'ShoppingCartQuery',
					{emulateJSON:true}
				).then(
					function(res){
						console.log(res);
						this.lists = res.body;   
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			checkall: function() {
				/**
				*控制全选反选
				*/
				var _this = this
				//true的时候是全选，false是不选
				if(this.checkall) {
					// 实现反选，按钮选中时 实现了反选，列表为空
					this.checked = []
					this.price=0;
					this.count=0;
				} else {
					// 实现全选
					this.price=0;
					this.count=0;
					this.checked = []
					this.list.forEach(function(dateil) {
						_this.price+=parseInt(dateil.detailProductprice);
						_this.count+=parseInt(dateil.detailProductnum);
						_this.checked.push(dateil.detailId)
					})
				}
				if(this.checked.length === this.list.length) {
					this.checkall = true
					// console.log(this.checkall)
					// console.log(this.checked)
				}
			},
			sum() {
			    // let sum = 0;
			    // this.checkGroup.forEach((value) => {
			    //     sum += value.price * value.num;
			    // });
			    // return sum;
					
					
			    return this.checkGroup.reduce((previousValue, value) => {
			        console.log(this.checkGroup);
			        console.log(value);
			        return previousValue += value.price * value.num;
			    }, 0);
			},
			del(i, id2,cat) {
			    console.log('网页顺序:' + i);
			    console.log('ID:' + id2);
				console.log('cat:' + cat);
			    //删除原数组
			    this.lists.splice(i, 1);
			    //得删除checkGroup数组中对应的元素
			    this.checkGroup = this.checkGroup.filter((value) => {
			        return value.id !== id2;
			    });
			    //这个checkOne在点删除事件的时候也要判定一次
			    this.checkOne();
				
				this.$http.post(
					rootPath + 'ShoppingCartDelete',
					{
						cat: cat
					}
				).then(function(res){
					console.log(res);
					console.log(this.message2);
				}, function(res){
					console.log(res.status);
				});
			},
			checkAll() {
			    if (this.isAll) {
			        this.checkGroup = this.lists;
			    } else {
			        this.checkGroup = [];
			    }
			},
			checkOne() {
			    if (this.checkGroup.length === this.lists.length && this.lists.length !== 0) {
			        this.isAll = true;
			    } else {
			        this.isAll = false;
			    }
			},
			money() {
				if(typeof(Storage)!=="undefined"){
					sessionStorage.clickcount= "AAAA";
					//跳转
					window.location.href="./settlement.html";
					//封装 网页传值
					sessionStorage.setItem('queryParam',JSON.stringify(this.checkGroup))
				}
				else{
					document.getElementById("result").innerHTML="抱歉，您的浏览器不支持 web 存储";
				}
			},
		},
	});
	vue.cart();
}


// window.onload = function (){
// 	var vue = new Vue({
// 		el: '#app',
// 		data: {
// 			sites : [],
// 			list: [],
// 			checkall: false,
// 			checked: [],
// 			price:0,
// 			count:0,
// 		},
// 		methods: {
// 			cart:function(){
// 				//发送 post 请求
// 				this.$http.post(
// 					rootPath + 'ShoppingCartQuery',
// 					{emulateJSON:true}
// 				).then(
// 					function(res){
// 						console.log(res);
// 						this.sites = res.body;   
// 					},
// 					function(){
// 						console.log('请求失败处理');
// 					}
// 				);
// 			},
		
// 			checkAll: function() {
// 				/**
// 				*控制全选反选
// 				*/
// 				var _this = this
// 				//true的时候是全选，false是不选
// 				if(this.checkall) {
// 					// 实现反选，按钮选中时 实现了反选，列表为空
// 					this.checked = []
// 					this.price=0;
// 					this.count=0;
// 				} else {
// 					// 实现全选
// 					this.price=0;
// 					this.count=0;
// 					this.checked = []
// 					this.list.forEach(function(dateil) {
// 						_this.price+=parseInt(dateil.detailProductprice);
// 						_this.count+=parseInt(dateil.detailProductnum);
// 						_this.checked.push(dateil.detailId)
// 					})
// 				}
// 				if(this.checked.length === this.list.length) {
// 					this.checkall = true
// 					// console.log(this.checkall)
// 					// console.log(this.checked)
// 				}
// 			}
// 		},
// 	});
// 	vue.cart();
// }