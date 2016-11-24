<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="img/icon_web_mini.png" type=""/>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="css/plugins/datatables/dataTables.bootstrap.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="css/dist/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="css/dist/skin/skin-green-light.min.css">

    <title>Document</title>
</head>
<body class="hold-transition skin-blue sidebar-mini" style="background-color: #ECF0F5">

<div class="container">

	<c:forEach items="${consulting }" var="item">
		<div class="row">
        <div class="col-md-10">
            <!-- Box Comment -->
            <div class="box box-widget">
            <div class="box-header with-border">
              <div class="user-block">
                <img class="img-circle" src="../dist/img/user1-128x128.jpg" alt="User Image">
                <span class="username"><a href="#">${item.user.username }</a></span>
                <span class="description">${item.ctime }</span>
              </div>
              <!-- /.user-block -->
              <div class="box-tools">
                <button type="button" class="btn btn-box-tool" data-toggle="tooltip" title="Mark as read">
                  <i class="fa fa-circle-o"></i></button>
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
              <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body">
            <!-- 问题描述图片 -->
              <img class="img-responsive pad" src="../dist/img/photo2.png" alt="Photo">

              <p>${item.ccontent }</p>
              <span class="pull-right text-muted">n个回复</span>
            </div>
            
            <!-- /.box-footer -->
            <div class="box-footer">
              <form action="#" method="post">
                <img class="img-responsive img-circle img-sm" src="../dist/img/user4-128x128.jpg" alt="Alt Text">
                <!-- .img-push is used to add margin to elements next to floating images -->
                <div class="img-push">
                  <input onkeydown='if(event.keyCode==13){answer(${item.cid})} else{return;}' id="answer${item.cid }" type="text" class="form-control" placeholder="按下回车键提交回复.." />
                </div>
              </form>
            </div>
            <!-- /.box-footer -->
          </div>
            <!-- /.box -->
        </div>
    </div>
	</c:forEach>
	
    
</div>

<!-- jQuery 2.2.3 -->
<script src="js/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="js/bootstrap/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="js/dist/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="js/dist/demo.js"></script>
<!-- page script -->
<script>
    /* $("#answer").click(function () {
        if ($("#comment").is(":hidden")) {
            $("#comment").show();    //如果元素为隐藏,则将它显现
            $("#answer").html("<i class='fa fa-sticky-note-o'></i>收起");
        } else {
            $("#comment").hide();     //如果元素为显现,则将其隐藏
            $("#answer").html("<i class='fa fa-sticky-note-o'></i>解答");
        }
    }); */
    
    function answer(obj) {
    	var content = $("#answer"+obj).val();
    	if(content == undefined || content == "") {
    		return;
    	}
    	$.post("../consultServlet?op=answer", {cid:obj,content:content}, function() {
    		alert("success");
    	});
    }
</script>
</body>
</html>