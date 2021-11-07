window.onload = function (){
	var vue = new Vue({
		el: '#app',
		// 筛选页面推荐
		data: {
			sites : [],
			query : "华硕"
		},
		methods: {
			home:function(){
				var url =rootPath + 'HomePageQuery';
				//发送 get 请求
				this.$http.get(url)
				.then(
					function(res){
						console.log(res);
						this.sites = res.body;   
					},
					function(){
						console.log('请求失败处理');
					}
				);
				var OneLinks = new Array(6);//图片数组
				
				OneLinks[0] = "../images/huashuo01.jpg";//给图片数组赋值，即变换时的图像值
				
				OneLinks[1] = "../images/huashuo02.jpg";
				
				OneLinks[2] = "../images/huashuo03.jpg";
				
				OneLinks[3] = "../images/huashuo04.jpg";
				
				OneLinks[4] = "../images/huashuo05.jpg";
				
				OneLinks[5] = "../images/huashuo06.jpg";
				
				
				var id = function(el) {           
				
					return document.getElementById(el);      
				
				 };
				
				c = id('photo-list');//由id得到photo-list元素
				
				ul = id('scroll');//由id得到scroll元素
				
				var i=0;
				
				if(c){  marquee = function() {   
				
					var j=i%6;//循环   
				
					ul.getElementsByTagName('img')[0].src = OneLinks[j];//将每次即将变换的图像值赋值给图片元素的src 
				
					 i++;
				
				}; 
				
				  speed = 1000;//变换的时间差，越大变换速度越慢
				
				  var timer = setInterval(marquee, speed); 
				
				}
			},
			input:function(){
				//发送 post 请求
				this.$http.post(
					rootPath + 'AllQuery',
					{query : this.query}
				).then(
					function(res){
						console.log(res);
						this.sites = res.body;   
					},
					function(){
						console.log('请求失败处理');
					}
				);
			},
			money(id) {
				if(typeof(Storage)!=="undefined"){
					sessionStorage.clickcount= "AAAA";
					//跳转
					window.location.href="./exhibition.html";
					//封装 网页传值
					sessionStorage.setItem('queryParam',JSON.stringify(id))
				}
				else{
					document.getElementById("result").innerHTML="抱歉，您的浏览器不支持 web 存储";
				}
			},
		}
	});
	
	vue.home();
}
	