<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>挑一个</title>
    <meta charset="utf-8">
    <title>Flat UI - Free Bootstrap Framework and Theme</title>
    <meta name="description" content="小鲜肉"/>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <!-- Loading Flat UI -->
    <link href="<%=request.getContextPath() %>/css/lsm.css" rel="stylesheet">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.jqzoom.css" type="text/css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/star-rating.css">

    <script src="<%=request.getContextPath() %>/js/jquery-1.8.3.min.js"></script>

    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>

    <script src="<%=request.getContextPath() %>/js/jquery.slotmachine.js"></script>

    <script src="<%=request.getContextPath() %>/js/jquery.jqzoom-core.js" type="text/javascript"></script>

    <script src="<%=request.getContextPath() %>/js/jquery.masonry.min.js" type="text/javascript"></script>

    <script src="<%=request.getContextPath() %>/js/bootstrap-rating-input.js"></script>

    <link rel="shortcut icon" href="img/favicon.ico">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->



    <script type="text/javascript">

        $(document).ready(function() {
            $('.jqzoom').jqzoom({
                zoomType: 'standard',
                lens:true,
                preloadImages: false,
                alwaysOn:false
            });

        });

    </script>
</head>
<body style="padding-top:70px">
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">挑妹子</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="<%=request.getContextPath() %>/imgpk/index" class="dropdown-toggle active" data-toggle="dropdown">挑妹子<span class="caret"/></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">猜打分</a></li>
                            <li><a href="#">我要PK</a></li>
                            <li class="divider"></li>
                            <li><a href="#">街拍一下</a></li>

                        </ul>
                    </li>
                    <li ><a href="<%=request.getContextPath() %>/rank/rankList">排行榜</a></li>
                    <li class=""><a href="#">组局蹭饭</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">休闲一下<span class="caret"/></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">段子党</a></li>
                            <li><a href="#">小游戏</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">关于我们</a>

                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </div>
</nav>