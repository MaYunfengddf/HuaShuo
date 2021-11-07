window.onload = function (){
	var vue = new Vue({
		el: '#app',
		data: {
			message: 'Hello Vue.js1!',
			phone: "请输入收件人手机号",
			address: "请输入收件人地址",
			name: "请输入收件人姓名",
			checkGroup: [],
			time: "",
			regi:[],
			express:"快递 免邮",
			ass:[
					// {
					// 	name: "张珊",
					// 	address: "河南省 驻马店市 驿城区 雪松街道 御苑城4号楼西梯2207",
					// 	phone: "123546879",
					// },{
					// 	name: "张珊",
					// 	address: "河南省czxczxczxczxczxcxzczxcxzcsdsdxcxcx",
					// 	phone: "123546879",
					// },{
					// 	name: "张珊",
					// 	address: "河南省 驻马店市 驿城区 雪松街道 御苑城4号楼西梯2207",
					// 	phone: "123546879",
					// },{
					// 	name: "张珊",
					// 	address: "河南省 驻马店市 驿城区 雪松街道 御苑城4号楼西梯2207",
					// 	phone: "123546879",
					// },{
					// 	name: "张珊",
					// 	address: "河南省 驻马店市 驿城区 雪松街道 御苑城4号楼西梯2207",
					// 	phone: "123546879",
					// },{
					// 	name: "张珊",
					// 	address: "河南省 驻马店市 驿城区 雪松街道 御苑城4号楼西梯2207",
					// 	phone: "123546879",
					// },{
					// 	name: "张珊",
					// 	address: "河南省 驻马店市 驿城区 雪松街道 御苑城4号楼西梯2207",
					// 	phone: "123546879",
					// },{
					// 	name: "张珊",
					// 	address: "河南省 驻马店市 驿城区 雪松街道 御苑城4号楼西梯2207",
					// 	phone: "123546879",
					// },{
					// 	name: "张珊",
					// 	address: "河南省 驻马店市 驿城区 雪松街道 御苑城4号楼西梯2207",
					// 	phone: "123546879",
					// },{
					// 	name: "张珊",
					// 	address: "河南省 驻马店市 驿城区 雪松街道 御苑城4号楼西梯2207",
					// 	phone: "123546879",
					// },{
					// 	name: "张珊",
					// 	address: "河南省 驻马店市 驿城区 雪松街道 御苑城4号楼西梯2207",
					// 	phone: "123546879",
					// },
				],
			
			sites:[
					// {
					// 	id:"2",
					// 	num:"1",
					// 	name2: "华硕笔记本",
					// 	model: "飞行堡垒",
					// 	size: "12英寸",
					// 	type: "办公笔记本",
					// 	processor: "i7",
					// 	memory: "512G",
					// 	harddisk: "SSD",
					// 	colour: "冰晶银",
					// 	price: "8888",
					// 	images:"../images/huashuo08.jpg",
					// },
					// {
					// 	id:"4",
					// 	num:"5",
					// 	name2: "华硕笔记本",
					// 	model: "飞行堡垒",
					// 	size: "12英寸",
					// 	type: "办公笔记本",
					// 	processor: "i7",
					// 	memory: "512G",
					// 	harddisk: "SSD",
					// 	colour: "冰晶银",
					// 	price: "8888",
					// 	images:"../images/huashuo08.jpg",
					// },
				],
			
		},
		methods: {
			//自动生成当天时间 然后加三天  大概到达时间
			time2: function() {
				var myDate = new Date();
				var time1 = myDate.getMonth();       //获取当前月份(0-11,0代表1月)
				var time2 =myDate.getDate();        //获取当前日(1-31)
				var time3 = time1 + 1;
				var time4 = time2 + 3;
				this.time = '24:00前付款 大概' + time3 + "." + time4 + "送达";
				
			},
			//获取网页传值
			money: function() {
				this.sites = JSON.parse(sessionStorage.getItem('queryParam'));
				console.log(this.sites);
			},
			//选择地址
			regis(addressId) {
				this.regi = addressId;
			},
			//生成订单付款
			regis2() {
				var reg = this.sites;
				console.log(reg);
				console.log(reg[0].id);
				console.log(reg[1].id);
				var i = 0;
				var list = [];
				for(i;i < reg.length ;i++){
					list.unshift(reg[i].id);
				}
				
				console.log(list);
				
				this.$http.post(
					rootPath + 'OrderWriting',
					{
						key2 : list
					}
				).then(function(res){
					console.log(res);
				}, function(res){
					console.log(res.status);
				});
			},
			// 客户地址
			address2: function() {
				this.$http.post(
					rootPath + 'AddressQuery',
				).then(function(res){
					console.log(res);
					this.ass = res.body;
				}, function(res){
					console.log(res.status);
				});
			},
			//计算总价
			sum() {
			    // let sum = 0;
			    // this.checkGroup.forEach((value) => {
			    //     sum += value.price * value.num;
			    // });
			    // return sum;
					
					
			    return this.sites.reduce((previousValue, value) => {
			        console.log(this.sites);
			        console.log(value);
					var va = value.price  + 'blue';
					 parseInt("1234blue")
			        return previousValue += parseInt(va)*value.num;
			    }, 0);
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
			maintain: function() {
				//跳转
				window.location.href="./addAddress.html";
			}
		},
	})
	vue.time2();
	vue.money();
	vue.address2();
	// 获取弹窗
	var modal = document.getElementById('myModal');
	
	// 打开弹窗的按钮对象
	var btn = document.getElementById("myBtn");
	
	// 获取 <span> 元素，用于关闭弹窗 that closes the modal
	var span = document.getElementsByClassName("close")[0];
	
	// 点击按钮打开弹窗
	btn.onclick = function() {
		modal.style.display = "block";
	}
	
	// 点击 <span> (x), 关闭弹窗
	span.onclick = function() {
		modal.style.display = "none";
	}
	
	// 在用户点击其他地方时，关闭弹窗
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
}
