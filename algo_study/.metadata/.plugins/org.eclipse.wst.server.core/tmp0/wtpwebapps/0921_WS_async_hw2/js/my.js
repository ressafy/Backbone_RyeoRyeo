let cookie_loginId = $.cookie("loginId");
if(cookie_loginId){
	document.querySelector("#loginSpan").innerHTML=cookie_loginId+" <button id ='logoutBtn'>logout</button>";
}

$(document).on("click","#loginBtn",login);
$(document).on("click","#logoutBtn",logout);


async function detailBookInfo(productCode){
	alert(productCode);
//	let id = document.querySelector("#id").value;
//	let pw = document.querySelector("#pw").value;
//	let name = document.querySelector("#name").value;
//	
//	let data = JSON.stringify({sign:"memberInsert",id,pw,name});
//	console.log(data);
//	data = await fetch("../main",{method:"POST",body:data});
//	data = await data.text();
//	data = JSON.parse(data);
//	console.log(data);
//	alert(data.msg);
//	window.close();
}

async function memberInsert(){

	let id = document.querySelector("#id").value;
	let pw = document.querySelector("#pw").value;
	let name = document.querySelector("#name").value;
	
	let data = JSON.stringify({sign:"memberInsert",id,pw,name});
	console.log(data);
	data = await fetch("../main",{method:"POST",body:data});
	data = await data.text();
	data = JSON.parse(data);
	console.log(data);
	alert(data.msg);
	window.close();
}

async function login(){
	let id = document.querySelector("#id").value;
	let pw = document.querySelector("#pw").value;
	let data = JSON.stringify({sign:"login",id,pw});
	data = await fetch("main",{method:"POST",body:data});
	data = await data.text();
	data = JSON.parse(data);
	if(data.loginId){
		$.cookie("loginId",data.loginId);
		document.querySelector("#loginSpan").innerHTML=data.loginId+" <button id = 'logoutBtn'>logout</button>";
	}else{
		alert(data.msg);
	}
}

async function logout(){
	let data = JSON.stringify({sign:"logout"});
	data = await fetch("main",{method:"POST",body:data});
	$.removeCookie("loginId");
	location.reload();
}