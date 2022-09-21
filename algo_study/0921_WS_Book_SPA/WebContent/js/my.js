let cookie_loginId = $.cookie("loginId");
if(cookie_loginId){
	document.querySelector("#loginSpan").innerHTML = cookie_loginId+" <button>logout</button>";
}

document.querySelector("#loginBtn").addEventListener("click",login);

async function login(){
	let id = document.querySelector("#id").value;
	let pw = document.querySelector("#pw").value;
	let data = JSON.stringify({sign:"login",id,pw});  // : id 이렇게 안해도 되는데 이게 비구조화 할당이다. = 구조분해 할당
	data = await fetch("main",{method:"POST", body:data});
	data = await data.text();
	data = JSON.parse(data);
	if(data.loginId){
		document.cookie="loginId="+data.loginId;
		document.querySelector("#loginSpan").innerHTML = data.loginId+" <button>logout</button>";
	}
	
}