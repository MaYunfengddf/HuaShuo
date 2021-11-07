// window.onload = function (){
// new Vue({
// 	  el: '#app',
// 	  data: {
// 	    sites: [
// 		{
// 			name:'华为笔记本',
// 			model:'MateBook 13',
// 			colour:'皓月银',
// 			size:'13英寸',
// 			price:6999,
// 			images:'../images/huawei05.png',
// 			quantity:44,
// 			type:'触控屏轻薄笔记本',
// 			processor:'11代i7',
// 			memory:'512G',
// 			harddisk:'SSD'
// 		},
// 		{
// 			name:'华为笔记本',
// 			model:'MateBook 13',
// 			colour:'樱粉金',
// 			size:'13英寸',
// 			price:6999,
// 			images:'../images/huawei06.png',
// 			quantity:74,
// 			type:'触控屏轻薄笔记本',
// 			processor:'锐龙R5',
// 			memory:'512G',
// 			harddisk:'SSD'
// 		},
// 		]
// 	  }
// 	})
// }

window.onload = function (){
	var vue = new Vue({
		el: '#app',
		// 筛选页面推荐
		data: {
			sites : [],
		},
		methods: {
			allQuery:function(){
				this.$http.post(
					rootPath + 'AllGoodsInquiry'
				).then(function(res){
					console.log(res);
					this.sites = res.body; 
				}, function(res){
					console.log(res.status);
				});
			},
		}
	});
	
	vue.allQuery();
}