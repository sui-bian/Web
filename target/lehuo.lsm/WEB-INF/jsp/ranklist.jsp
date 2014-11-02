<%--
  Created by IntelliJ IDEA.
  User: simonliu
  Date: 14-11-2
  Time: 下午3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="headerfooter/header.jsp" %>
<div id="containera" class="container">

    <c:forEach var="img" items="${requestScope.list}" varStatus="status">
        <div class="item">
            <a href="<%=request.getContextPath() %>/images/${img}" class="jqzoom" rel='gal1'  title="triumph">
                <img src="<%=request.getContextPath() %>/images/${img}" class="img-responsive img-rounded" style="vertical-align: bottom;width: 250px;height: auto;"/>
            </a>
            <hr style="clear: both;margin-bottom: 10px">
               <a href="#"><h4>###</h4></a>
        </div>
    </c:forEach>

</div>
<script>
    $(function(){
        var $container = $('#containera');

        $container.imagesLoaded( function(){
            $container.masonry({
                itemSelector : '.item'
            });
        });

    });
</script>
<style>
    .item {
        width:272px;
        margin: 5px;
        padding:5px;
        float: left;
        border: 1px solid #ccc;
        background: #eee;
    }


    #containera {
        padding: 10px;
        background-color: #ccc;
    }

    #containera,
    .item {
        -webkit-transition-duration: 0.7s;
        -moz-transition-duration: 0.7s;
        -ms-transition-duration: 0.7s;
        -o-transition-duration: 0.7s;
        transition-duration: 0.7s;
    }

    #containera {
        -webkit-transition-property: height, width;
        -moz-transition-property: height, width;
        -ms-transition-property: height, width;
        -o-transition-property: height, width;
        transition-property: height, width;
    }

    .item {
        -webkit-transition-property: left, right, top;
        -moz-transition-property: left, right, top;
        -ms-transition-property: left, right, top;
        -o-transition-property: left, right, top;
        transition-property: left, right, top;
    }

</style>
<%@include file="headerfooter/footer.jsp" %>