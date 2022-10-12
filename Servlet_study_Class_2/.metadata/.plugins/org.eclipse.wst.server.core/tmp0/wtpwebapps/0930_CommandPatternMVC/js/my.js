window.onload = function(){
	let loginId = $.cookie("loginId");
	if(loginId){
		login(loginId);
	}
}  // 그냥 자바스크립트이다.

$(document).on("click","#loginBtn",login);
$(document).on("click","#logoutBtn",logout);

async function login(id){  // 이게 웹에서 바로 오면 이벤트 객체가 온다.... 위의 온로드에서 오는 경우와 웹에서 오는 경우를 생각하자.
	console.log(id);
	let data;
	if(typeof id == "string"){
		data = JSON.stringify({sign:"login",id});
	}else{
		let id = $("#id").val(); // documnet.querySelector 이다.
		let pw = $("#pw").val();
		data = JSON.stringify({sign:"login",id,pw});  // json 으로 바꿔줌
	}
	
	
	
	data = await fetch("main",{method:"POST",body:data});
	console.log(data);
	data = await data.text();
	console.log(data);
	data = JSON.parse(data);
	console.log(data);
	if(data.loginId){
		$.cookie("loginId",data.loginId);
		$("#loginDiv").html(`<div class = "text-white">${data.loginId} <button class="btn btn-primary" type="button" id="logoutBtn">Logout</button>`);
		
	}else{
		alert(data.msg);
		$.removeCookie("loginId");
	}
}

async function logout(){
	let data = JSON.stringify({sign:"logout"});
	data = await fetch("main",{method:"POST",body:data});
	
}