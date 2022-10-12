window.onload=function(){
	let loginId = $.cookie("loginId");
	if(loginId){
		login(loginId);
	}
}

$(document).on("click","#loginBtn",login);
$(document).on("click","#logoutBtn",logout);
$(document).on("change","#sido",getGugun);
$(document).on("change","#gugun",getDong);
$(document).on("change","#dong",selectedDong);
$(document).on("click","#list-btn",getHouseDealInfo);
$(document).on("change","#year",selectYear);
$(document).on("change","#month",selectMonth);
$(document).on("click","#houseDealInfoBtn",getHouseDealInfo);




let month;
function selectMonth() {
	month=$("#month option:selected").val();
}

let year;
function selectYear() {
	year=$("#year option:selected").val();
}


let dong;
function selectedDong(){
	dong=$("#dong option:selected").val();
	
}

async function getHouseDealInfo() {	
	console.log(sido,gugun,dong,year,month);
	if (sido==undefined || gugun==undefined || dong==undefined || year==undefined || month==undefined) {	
		alert("검색 조건을 모두 선택해 주세요");
	}else{
		let data = JSON.stringify({ sign: "getHouseDealInfo", sido,gugun,dong,year,month});
		data = await fetch("main", { method: "POST", body: data });
		data = await data.text();
		console.log(data);
		data = JSON.parse(data);
		console.log(data);
		let houseDealInfoListTable=`  <table class="table table-hover">
								    <thead>
								      <tr>
								        <th>no</th>
								        <th>dong</th>
								        <th>roadName</th>
								        <th>apartmentName</th>
								        <th>floor</th>
								        <th>area</th>
								        <th>dealAmount</th>
								      </tr>
								    </thead><tbody>`;
		data.houseDealInfoList.forEach(function (item, index) {
			item=JSON.parse(item);  // 파싱 한 번 더
			houseDealInfoListTable += `<tr onclick="alert(${item.lat}+':'+${item.lng})">
								        <th>${item.no}</th>
								        <th>${item.dong}</th>
								        <th>${item.roadName}</th>
								        <th>${item.apartmentName}</th>
								        <th>${item.floor}</th>
								        <th>${item.area}</th>
								        <th>${item.dealAmount}</th>
								      </tr>`;
		});
		
		houseDealInfoListTable += `</tbody></table>`;

		$("#contentTopDiv").html(houseDealInfoListTable);		 
		
	} 
}


/*async function getHouseDealInfo() {
	console.log(sido,gugun,dong,year,month);
//		if () {

//	}else{
		let data = JSON.stringify({ sign: "getDong", sido, gugun, dong});
		data = await fetch("main", { method: "POST", body: data });
		data = await data.text();
		console.log(data);
		data = JSON.parse(data);
		console.log(data);
		let options=`<option value="">동</option>`;
		data.dongList.forEach(function (item, index) {
			options += `<option value="${item}">${item}</option>`;
		});

		$("#dong").html(options);
//	}
}*/


let sido;
async function getGugun() {
	let sido=$("#sido option:selected").val()
	// alert(sido);
	
	if (sido.length>2) {	
		let data = JSON.stringify({ sign: "getGugun", sido});
		data = await fetch("main", { method: "POST", body: data });
		data = await data.text();
		console.log(data);
		data = JSON.parse(data);
		console.log(data);
		let options=`<option value="">구군</option>`;
		data.gugunList.forEach(function (item, index) {
			options += `<option value="${item}">${item}</option>`;
		});

		$("#gugun").html(options);		 
		
	} 
}

let gugun;
async function getDong() {
	 sido=$("#sido option:selected").val();
	 gugun=$("#gugun option:selected").val();
	// alert(sido);
		if (gugun!=="구군") {
		let data = JSON.stringify({ sign: "getDong", sido,gugun});
		data = await fetch("main", { method: "POST", body: data });
		data = await data.text();
		console.log(data);
		data = JSON.parse(data);
		console.log(data);
		let options=`<option value="">동</option>`;
		data.dongList.forEach(function (item, index) {
			options += `<option value="${item}">${item}</option>`;
		});

		$("#dong").html(options);
	}
}




async function logout(id){
	let data =JSON.stringify({sign:"logout"});
	await fetch("main",{method:"POST",body:data});
	$.removeCookie("logined");
	location.reload();
	
}


async function login(id){	// 버튼 이벤트 핸들러: 이벤트객체를 갖는다.
	console.log(id);
	let data;
	if(typeof id =="string"){
		data =JSON.stringify({sign:"login",id});
	}else{		
		let id=$("#id").val();// document.querySelector("id").value()
		let pw=$("#pw").val();
	// alert(id+"&"+pw);
		data =JSON.stringify({sign:"login",id,pw});
	}
	
	data = await fetch("main",{method:"POST",body:data});
	console.log(data);
	data=await data.text();
	console.log(data);
	data = JSON.parse(data);
	console.log(data);
	if(data.loginId){
		$.cookie("loginId",data.loginId);
		$("#loginDiv").html(`<div class="text-white">${data.loginId} <button class="btn btn-primary" type="button" id="logoutBtn">Logout</button></div>`);
	}else{
		alert(data.msg);
		$.removeCookie("loginId");
	}
	
}




