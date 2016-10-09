<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | General Form Elements</title>
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
    <link rel="stylesheet" href="css/dist/skin/_all-skins.min.css">

    <title>Document</title>
</head>
<body class="hold-transition skin-blue sidebar-mini" style="background-color: #ECF0F5">

<div class="container">


    <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">搜索</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <div class="box-body">
            <form role="form" class="form-inline">


                 <div class="form-group col-md-4">
                     <label for="realname">姓名</label>
                     <input type="text" class="form-control" id="realname" placeholder="输入姓名">
                 </div>
                 <div class="form-group col-md-4">
                     <label for="phone">手机号</label>
                     <input type="text" class="form-control" id="phone" placeholder="输入地址">
                 </div>
                 <div class="form-group col-md-4">
                     <label>性别</label>
                     <select class="form-control">
                         <option>男</option>
                         <option>女</option>
                     </select>
                 </div>

                 <div class="form-group col-md-6">
                     <label for="address">地址</label>
                     <input type="text" class="form-control" id="address" placeholder="输入地址">
                 </div>


                 <div class="form-group col-md-3">
                     <label></label>
                     <br>
                     <button type="submit" class="btn btn-primary">搜索</button>
                 </div>

            </form>

        </div>

    </div>


    <!-- /.box-body -->

<br/>
<div class="box">
    <div class="box-header">
        <h3 class="box-title">Hover Data Table</h3>
    </div>
    <!-- /.box-header -->
    <div class="box-body">
        <div class="container">
            <a class="btn btn-default" href="addmachineowner.html">
                <i class="fa fa-edit"></i>&nbsp;新增
            </a>
            <a class="btn btn-default">
                <i class="fa fa-times"></i>&nbsp;删除
            </a>
            <a class="btn btn-default">
                <i class="fa fa-area-chart"></i>&nbsp;统计
            </a>
            <a class="btn btn-default">
                <i class="fa fa-check-square-o"></i>&nbsp;全选
            </a>
            <a class="btn btn-default">
                <i class="fa fa-square-o"></i>&nbsp;取消
            </a>
            <a class="btn btn-default">
                <i class="fa fa-save"></i>&nbsp;导出
            </a>
        </div>
        <div id="example2_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
            <div class="row">
                <div class="col-sm-6"></div>
                <div class="col-sm-6"></div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <table id="example2" class="table table-bordered table-hover dataTable" role="grid"
                           aria-describedby="example2_info">
                        <thead>
                        <tr role="row">
                            <!--<th class="sorting" tabindex="0" rowspan="1" colspan="1"></th>-->
                            <th rowspan="1" colspan="1"></th>
                            <th rowspan="1" colspan="1">姓名</th>
                            <th rowspan="1" colspan="1">性别</th>
                            <th rowspan="1" colspan="1">年龄</th>
                            <th rowspan="1" colspan="1">手机号</th>
                            <th rowspan="1" colspan="1">地址</th>
                            <th rowspan="1" colspan="1"></th>
                        </tr>
                        </thead>
                        <tbody>
                         <c:forEach items="${allMachiner }" var="item">
                        	<tr role="row" class="odd">
                            <td align="center"><input type="checkbox"></td>
                            <td class="">${item.username }</td>
                            <td class="sorting_1">${item.realname }</td>
                            <td>${item.sex }</td>
                            <td>${item.age }</td>
                            <td>${item.phone }</td>
                            <td>${item.address }</td>
                            <td>${item.credit }</td>
                            <td align="center"><a href="editorfarmer.html">详情</a>&nbsp;&nbsp;<a href="#">删除</a></td>
                        </tr>
                        </c:forEach>
                        </tbody>
                        <tfoot>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- /.box-body -->
</div>
</div>

<!-- jQuery 2.2.3 -->
<script src="js/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="js/bootstrap/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="js/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="js/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="js/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="js/plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="js/dist/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="js/dist/demo.js"></script>
<!-- page script -->
<script>
    $(function () {
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": true,
            "columns": [
                {"bSortable": false},
                {"bSortable": true},
                {"bSortable": true},
                {"bSortable": true},
                {"bSortable": true},
                {"bSortable": true},
                {"bSortable": false}
            ]
        });
    });
</script>
</body>
</html>
  