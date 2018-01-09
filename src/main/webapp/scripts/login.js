	$(function(){
		$('#login').click(loginAction);
		$('#count').bind('blur','#count',checklogin);
		$('#password').bind('blur','#password',checklogin);
		
		$('#regist_button').click(regAction);		
		$('#regist_username').bind('blur','#regist_username',checkval);
		$('#regist_password').bind('blur','#regist_password',checkval);
		$('#final_password').bind('blur','#final_password',checkval);
	});
	
	function regAction(){
		console.log("regAction()");
		var name=$('#regist_username').val();
		var nick=$('#nickname').val();
		var password=$('#regist_password').val();
		var confirm=$('#final_password').val();		
		var n=checkval('#regist_username')+checkval('#regist_password')+checkval('#final_password');
		if(n!=3){
			return;
		}
		if(password!=confirm){
			$('#final_password').next().show().html("验证密码不一致");
			return;
		}else{
			$('#final_password').next().hide();
		}
		
		var data={name:name,nick:nick,password:password,confirm:confirm}
		$.ajax({
			url:'user/reg.do',
			type:'post',
			data:data,
			dataType:'json',
			success:function(result){
				console.log(result);
				if(result.state==0){
					alert('注册成功！');
					location.href='log_in.html';
				}else{
					if(result.state==1){
						console.log(result);
						$('#regist_username').next().show().html(result.message);
						//$('#warning_1').html(result.message);
					}else if(result.state==2){
						console.log(result);
						$('#regist_password').next().show().html(result.message);
						//$('#warning_2').html(result.message);
					}else if(result.state==3){
						console.log(result);
						$('#final_password').next().show().html(result.message);
						//$('#warning_3').html(result.message);
					}else if(result.state==-1){
						console.log(result);
						alert('通信失败！');
					}					
				}
			},
			error:function(){
				alert('通信失败！');
			}
		});
	}
		
	function checklogin(e){
		id=e.data
		var val=$(id).val();
		var rule=/^\w{4,10}$/;
		if(!rule.test(val)){
			$(id).next().html("4-10个字符");
			return false;
		}
		$(id).next().empty();
		return true;
	}
		
	function checkval(e){
		var id=e.data;
		var name=$(id).val();
		var rule=/^\w{4,10}$/;
		if(rule.test(name)){
			$(id).next().hide();
			return true;
		}
		$(id).next().show().find('span').html("4-10个字符");
		return false;
	}
	
	function loginAction(){
		var name=$('#count').val();
		var password=$('#password').val();
		var data={"name":name,"password":password}
		var n=checklogin('#count')+checklogin('#password');
		console.log(n);
		if(n!=2){
			return;
		}
		$.ajax({
			url:'user/login.do',
			type:'post',
			data:data,
			dataType:'json',
			success:function (result){
				if(result.state==0){
					setCookie("userid",result.data.id,1);
					location.href='edit.html';
				}else if(result.state==1){
					$('#count').next().html(result.message);
				}else if(result.state==2){
					$('#password').next().html(result.message);
				}
			},
			error:function(){
				alert("通信失败！");
			}
		});
	}