$(document).on("click","#memberInsertBtn",join);

async function join(id,pw,name){
	
	var name=$("#name").val();
	var id=$("#id").val();
	var pw=$("#pw").val();
	console.log("join js로 왔구나",name,id,pw);
	//alert(name+":"+id+":"+pw);
	data =JSON.stringify({sign:"join",id,pw,name});
	data = await fetch("main",{method:"POST",body:data});
	data=await data.text();
	data = JSON.parse(data);
	alert(data.msg);
	window.close();
}