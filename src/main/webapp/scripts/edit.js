var userid=getCookie("userid");
var url="/note02/log_in.html";
$(function(){
	if(userid==''){
		alert("请先登陆");
		location.href=url;
	}
	$('#logout').click(logout);
	getnotebookbyuserid(userid);
	$('#save_note').click(savenote);
	$('#add_note').bind("click","alert_note",openaddnote);
	$('#add_notebook').bind("click","alert_notebook",openaddnote);
});

function logout(){
	setCookie("userid","");
	location.href=url;
}

function openaddnote(e){
		$('#can').load('./alert/'+e.data+'.html',function(){
		$('#can').show();
		$('.opacity_bg').show();
		$('.sure').bind("click",e.data,add);
		$('.cancel,.close').click(function(){
			$('.opacity_bg').hide();
			$('#can').hide();
		})
	});
}

function add(e){
	var data;
	var notebookid=$('#first_side_right .checked').attr('id');
	if(e.data=="alert_notebook"){
		var notebooktitle=$('#input_notebook').val(); 
		data={"userid":userid,"notebookname":notebooktitle}
		var url="notebook/addnotebook.do";
	}else{
		var notetitle=$('#input_note').val();
		data={"userid":userid,"notebookid":notebookid,"notetitle":notetitle}
		var url="note/addnote.do";
	}
	$.ajax({
		url:url,
		type:"post",
		data:data,
		dataType:"json",
		success:function(data){
			console.log(data);
			if(data=="1"){
				alert("增加成功！");
				getnotebookbyuserid(userid);
			}else{
				alert("增加失败！")
			}
		}
	});
}

function savenote(){
	var noteid=$('#second_side_right .checked').attr('id');
	var notebody=UM.getEditor('myEditor').getContent();
	var notetitle=$('#input_note_title').val();
	var data={"noteid":noteid,"notetitle":notetitle,"notebody":notebody};
	$.ajax({
		url:"note/updatenote.do",
		type:"post",
		data:data,
		dataType:"json",
		success:function(data){
			if(data=="1"){
				alert("修改成功！");
				getnotebookbyuserid(userid);
			}else{
				alert("修改失败！")
			}
		}
	});
}

function getnotebookbyuserid(userid){
	$.ajax({
		url:"notebook/getnotebooklist.do",
		type:"post",
		data:{userid:userid},
		dataType:"json",
		success:function(data){
			var str="";
			for(i=0;i<data.length;i++){
				str+="<li class=\"online\">"+
					"<a id=\""+data[i].notebookId+"\" href=\"javascript:void(0);\" onclick=\"getnotebyid('"+data[i].notebookId+"')\">"+
				"<i class=\"fa fa-book\" title=\"online\" rel=\"tooltip-bottom\">"+
				"</i> "+data[i].notebookName+"</a></li>";
			}
			$('#first_side_right .contacts-list').html(str);
			var notebookid=$('#first_side_right .checked').attr('id');
			if(notebookid==undefined){
				var notebookid=data[0].notebookId
			}
			getnotebyid(notebookid);
		},
		error:function(){
			alert("获取数据失败！");
		}
	});
}

function getnotebyid(notebookid){
	$('#first_side_right .contacts-list a').removeClass("checked");
	$('#'+notebookid).addClass("checked");
	$.ajax({
		url:"note/getnotelist.do",
		type:"post",
		data:{notebookid:notebookid},
		dataType:"json",
		success:function(data){
			var str="";
			if(data.length>0){			
			for(i=0;i<data.length;i++){
				str+="<li class=\"online\">"+
				"<a href=\"javascript:void(0);\" id=\""+data[i].noteid+"\" onclick=\"shownote('"+data[i].noteid+"','"+data[i].notetitle+"','"+data[i].notebody+"')\">"+
				"<i class=\"fa fa-file-text-o\" title=\"online\" rel=\"tooltip-bottom\" databody=\""+data[i].notebody+"\">"+
				"</i> "+data[i].notetitle+"<button type=\"button\" class=\"btn btn-default btn-xs btn_position btn_slide_down\">" +
						"<i class=\"fa fa-chevron-down\"></i></button></a></li>";
			}						
			$('#second_side_right .contacts-list').html(str);
			shownote(data[0].noteid,data[0].notetitle,data[0].notebody);
			}else{
			$('#second_side_right .contacts-list').html(str);
			}
		},
		error:function(){
			alert("获取数据失败！");
		}
	});
}


function shownote(id,title,body){
	$('#second_side_right .contacts-list a').removeClass("checked");
	$('#'+id).addClass("checked");
	$('#input_note_title').val(title);
	var um = UM.getEditor('myEditor');
	um.ready(function() {//编辑器初始化完成再赋值  
		um.setContent(body);  //赋值给UEditor  
    });
}