window.onload=function(){
	let loginId=$.cookie("loginId");
	if(loginId){
		login(loginId);
	}
	
	
	
}


$(document).on("click","#loginBtn",login);
$(document).on("click","#logoutBtn",logout);
$(document).on("change","#sido",getGugun);
$(document).on("change","#gugun",getDong);

let gugun;
async function getDong() {
	  gugun=$("#gugun option:selected").val()
		
		if (sido.length>2) {	
			if(gugun.length>2){
				let data = JSON.stringify({ sign: "getDong", sido,gugun});
				data = await fetch("main", { method: "POST", body: data });
				data = await data.text();
				data = JSON.parse(data);
				console.log(data);
				let options=`<option value="">동</option>`;
				data.dongList.forEach(function (item, index) {
					options += `<option value="${item}">${item}</option>`;
				});

				$("#dong").html(options);		
			}
			 
			
		} 
		

	}
let sido;
async function getGugun() {
	sido=$("#sido option:selected").val()
	
	if (sido.length>2) {	
		let data = JSON.stringify({ sign: "getGugun", sido});
		data = await fetch("main", { method: "POST", body: data });
		data = await data.text();
		data = JSON.parse(data);
		console.log(data);
		let options=`<option value="">구군</option>`;
		data.gugunList.forEach(function (item, index) {
			options += `<option value="${item}">${item}</option>`;
		});

		$("#gugun").html(options);		 
		
	} 
	

}



async function logout(){
	let data=JSON.stringify({sign:"logout"});
	await fetch("main",{method:"POST",body:data});
	$.removeCookie("loginId");
	location.reload();

}

async function login(id){
	
	let data; // 인자로 받아올때랑 분기를 해야됨 이렇게
	if(typeof id=="string"){
		 data=JSON.stringify({sign:"login",id});
	}else {
	    let id=$("#id").val();
	    let pw=$("#pw").val();
	    data=JSON.stringify({sign:"login",id,pw});
	}

    data=await fetch("main",{method:"POST",body:data});
    console.log(data);
    data=await data.text();
    console.log(data);
    data=JSON.parse(data);
    console.log(data);
    
    if(data.loginId){
    	$.cookie("loginId", data.loginId);
    	$("#loginDiv").html(`<div class="text-white">${data.loginId} <button class="btn btn-primary" type="button" id="logoutBtn">logout</button></div>
`);
    }else{
    	alert(data.msg);
    	$.removeCookie("loginId");
    }
}