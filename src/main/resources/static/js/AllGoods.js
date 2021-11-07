window.onload = function (){
	new Vue({
		el: '#app',
		data: {
			
			message: 'Hello Vue.js1!',
			name: "请输入商品名称",
			model: "请输入商品型号",
			colour: "请输入商品颜色",
			size: "请输入商品屏幕尺寸",
			price: "请输入商品价格",
			images: "请输入商品图片位置",
			quantity: "请输入商品库存",
			type: "请输入商品定位",
			processor: "请输入商品处理器",
			memory: "请输入商品内存",
			harddisk: "请输入商品硬盘",
			message2: 'Hello Vue.js2!',
			id: "请输入商品ID",
			message3: 'Hello Vue.js3!',
			name1: "请输入商品名称",
			model1: "请输入商品型号",
			colour1: "请输入商品颜色",
			size1: "请输入商品屏幕尺寸",
			price1: "请输入商品价格",
			images1: "请输入商品图片位置",
			quantity1: "请输入商品库存",
			type1: "请输入商品定位",
			processor1: "请输入商品处理器",
			memory1: "请输入商品内存",
			harddisk1: "请输入商品硬盘",
			id1: "请输入商品ID",
			message4: 'Hello Vue.js4!'
		},
		methods: {
			// 增
			login: function() {
				console.log(this.name + ":" + this.model +":" + this.colour + ":" + this.size + ":" +
							this.price + ":" + this.images + ":" + this.quantity + ":" + this.type + ":" +
							this.processor + ":" + this.memory + ":" + this.harddisk);
				this.$http.post(
					rootPath + 'AllGoodsWrite',
					{
						name: this.name,
						model: this.model,
						colour: this.colour,
						size: this.size,
						price: this.price,
						images: this.images,
						quantity: this.quantity,
						type: this.type,
						processor: this.processor,
						memory: this.memory,
						harddisk: this.harddisk
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
					rootPath + 'AllGoodsDelete',
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
				console.log(this.name + ":" + this.model +":" + this.colour + ":" + this.size + ":" +
							this.price + ":" + this.images + ":" + this.quantity + ":" + this.type + ":" +
							this.processor + ":" + this.memory + ":" + this.harddisk,this.id);
				this.$http.post(
					rootPath + 'AllGoodsModify',
					{
						name: this.name1,
						model: this.model1,
						colour: this.colour1,
						size: this.size1,
						price: this.price1,
						quantity: this.quantity1,
						images: this.images1,
						type: this.type1,
						processor: this.processor1,
						memory: this.memory1,
						harddisk: this.harddisk1,
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
				window.location.href="./AllGoodsQueryAd.html";
			},
		},
	})
}