$(function() {
        draw(show_num);
        
        console.log('validate code:'+show_num);
        
        $('#canvas').on('click',function () {
            draw(show_num);
        })
        
        // 检视变量类型
        console.log('type of (show_num): '+typeof(show_num+''));
        
});

/* global variable */
var show_num=new Array();

/**
 * 绘制
 * 
 * @param show_num
 * @returns
 */
function draw(show_num) {
    var canvas_width=$('#canvas').width();
    var canvas_height=$('#canvas').height();
    
    var canvas=document.getElementById('canvas');
    
    var context=canvas.getContext("2d");// 获取canvas画图的环境
    
    canvas.width=canvas_width;
    canvas.height=canvas_height;
    
    var srcCode="A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z"+
    ",a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z"+
    ",1,2,3,4,5,6,7,8,9,0";
    
    var aloneCode=srcCode.split(',');
    var aloneCodeLen=aloneCode.length;
    
    for (var index = 0; index <= 4; index++) {
        var j=Math.floor(Math.random()*aloneCodeLen);// 得到随机的索引
        var txt=aloneCode[j];

        show_num[index]=txt;
        
        var deg=Math.random()*30*Math.PI/180;// 产生0~30的随机弧度
        
        var x=10+index*36;// 字符在canvas上的x坐标
        var y=20+Math.random()*8;// 字符在canvas上的y坐标
        
        context.font="bold 33px Consolas";
        context.translate(x+5,y+5);
        context.rotate(deg);
        context.fillStyle=randomColor();
        context.fillText(txt,0,0);
        context.translate(-x+10*1.5,-y+10*2.5);
        context.rotate(-deg);
    }
    
    // 验证码上显示线条
    for (var index = 0; index <= 5; index++) {
        context.strokeStyle=randomColor(); // stroke 一击,轻触,抚摸
        context.beginPath();
        context.moveTo(Math.random()*canvas_width,Math.random()*canvas_height);
        context.lineTo(Math.random()*canvas_width,Math.random()*canvas_height);
        context.stroke();
    }
    
    // 验证码上显示小点
    for (var index = 0; index < 60; index++) {
        context.strokeStyle=randomColor();
        context.beginPath();
        var x=Math.random()*canvas_width;
        var y=Math.random()*canvas_height;
        
        context.moveTo(x,y);
        context.lineTo(x+1,y+1);
        context.stroke();
    }
    
  
}

/**
 * 得到随机的颜色值
 * 
 * @returns
 */
function randomColor() {
    var r=Math.floor(Math.random()*256);
    var g=Math.floor(Math.random()*256);
    var b=Math.floor(Math.random()*256);
    
    return 'rgb('+r+','+g+','+b+','+')';
}

/**
 * 校验输入的验证码,返回真或假
 * 
 * @returns
 */    
function verifyValidateCode() {
     // 注意要选对表单ID
     var v=document.forms['form_usr_login']['validateCode'].value;
     if (v===''||v==null) {
    	 alert('验证码未输入');
         return;
     }
     v=v.toLowerCase();

     var vcStr=show_num+'';
           
     // 转为小写＆去除字符串中的所有逗号
     vcStr=vcStr.toLowerCase().replace(/,/g,'');

     console.log('类型of(vcStr):'+typeof(vcStr))
     console.log('生成的验证码: '+vcStr);
     console.log(v===vcStr);

     if (v===vcStr) {
          console.log('验证码正确')
          return true;
     }else{
          alert('输入的验证码有误');
          return false;
     }
}   

/**
 * sign in
 * 
 * @returns
 */
$(document).on('click','#commit_login',function () {
	// 选中当前表单中,标签input,类型type="text"的节点对象
	var selector = $('.input_txts');

	// 检查非空,返回开关量
	var booleans = verifyIsInputNullPlus(selector);
	if (booleans == false) {
		return;
	}

	var verifyCheck = verifyValidateCode();
	console.log(verifyCheck);
	if (verifyCheck === false) {
		return;
	}

	var url = 'account/login';
	var data = $('#form_usr_login').serialize();
				
	$.ajax({
		type : 'POST',
		url : url,
		data : data,
		dataType : 'json',
		success : function(rr) {
			if (rr.state == 200) {
				// alert('登录成功');
				// window.location.href = "cross/toTransfer";
				prompt('登录成功', 2000);
			} else {
				document.getElementById('info-tip').innerText = rr.message;
			}
		}
	});
});

/**
 * 弹出窗口
 * 
 * @param sentence
 * @param time
 * @param fn
 * @returns
 */
function prompt(sentence, time, fn) {
    var $div = $('<div></div>');

    $div.css({
        'position': 'fixed',
        'top': 0,
        'left': 0,
        'width': '100%',
        'height': '100%',
        'z-index': '200',
        'background-color': 'rgba(0,0,0,0.4)',
    });

    var $contentDiv = $('<div>' + sentence + '</div>');

    $contentDiv.css({
        'position': 'absolute',
        'top': '50%',
        'left': '56%',
        'font-size': '25px',
        'padding': '50px 100px',
        'border-radius': '5px',
        'background-color': '#fff',
        'color': '#000',
    });

    $div.append($contentDiv);
    $('body').append($div);

    // 获取创建的大小
    var newW = (parseInt($contentDiv.css('width')) + 200) / 2;
    var newH = (parseInt($contentDiv.css('height')) + 100) / 2;

    $contentDiv.css({
        'margin-top': -newH + 'px',
        'margin-left': -newW + 'px',
    });

    setTimeout(function() {
        $div.remove();

        window.location.href = "cross/toTransfer";
        
        if (fn) {
            fn(); // 回调函数
        }

    }, time);
}