window.onload = function (){
	var url = rootPath + "HomePageQuery";
	var request = new XMLHttpRequest();
	request.onload = function (){
		if(request.status == 200){
			displayContent(request.responseText);
		}
	}
	request.open("GET",url,true);
	request.send(null);
}

function displayContent(content) {
	var txt = content;
	var obj = eval ("(" + txt + ")");
	console.log(txt);
	console.log(obj);
	new Vue({
	  el: '#app',
	  data: {
	    sites: obj
			
	  }
	})
}