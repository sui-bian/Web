<%--
  Created by IntelliJ IDEA.
  User: simonliu
  Date: 14-11-1
  Time: 下午4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="headerfooter/header.jsp" %>

<style>
    .slotMachineBox { padding: 150px 0px; text-align: center;}
    .slotMachineButton { width: 100px; height: 100px; overflow: hidden; display: inline-block; text-align: center; }
    .slotMachineButton { -moz-box-shadow: inset 0px 1px 0px 0px #fce2c1; -webkit-box-shadow: inset 0px 1px 0px 0px #fce2c1; box-shadow: inset 0px 1px 0px 0px #fce2c1; background: -webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ffc477), color-stop(1, #fb9e25) ); background: -moz-linear-gradient( center top, #ffc477 5%, #fb9e25 100% );  filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffc477', endColorstr='#fb9e25');
        background-color: #ffc477; border-radius: 75px; text-indent: 0px; border: 6px solid #eeb44f; display: inline-block; color: #ffffff; font: 30px/100px "Microsoft Yahei"; height: 100px; line-height: 100px; width: 100px; text-align: center; text-shadow: 1px 1px 0px #cc9f52; margin-left: 50px; cursor: pointer; }
    .slotMachineButton:hover { background: -webkit-gradient( linear, left top, left bottom, color-stop(0.05, #fb9e25), color-stop(1, #ffc477) ); background: -moz-linear-gradient( center top, #fb9e25 5%, #ffc477 100% );  filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#fb9e25', endColorstr='#ffc477');
        background-color: #fb9e25; }
    .slotMachineButton:active { position: relative; top: 1px; }
    #slotMachineButtonPrev { margin: 0 50px 0 0;}
    .slotMachine { max-width: auto; height: 400px; overflow: hidden; display: inline-block; text-align: center; border: 5px solid #000; background-color: #ffffff; }
    .slotMachine .slot { height:400px;max-width: auto;}

    img {
        width: 350px;
        height : auto;
        max-height: 400px;
        max-width: 100%;
    }
</style>

<div class="container">
    <div class="row demo-row">
        <div class="col-xs-4"></div>
        <div class="col-xs-6">
            <form action="<%=request.getContextPath()%>/imgpk/oneround" id="oneround" class="form-inline" role="form">
                <div class="form-group"><h2>年龄</h2></div>
                <div class="form-group">

                    <select type="select" name="age" id="age" class="form-control">
                        <option value="1">14-18</option>
                        <option value="2">19-23</option>
                        <option value="3">24-28</option>
                        <option value="4">29-32</option>
                        <option value="5">32+</option>
                    </select>

                </div>

                <div class="form-group"><h2>&nbsp&nbsp</h2></div>

                <div class="form-group"><h2>星座</h2></div>

                <div class="form-group">
                    <select type="select" name="birth" id="birth" class="form-control">
                        <option value="1">摩羯座</option>
                        <option value="2">水瓶座</option>
                        <option value="3">双鱼座</option>
                        <option value="4">白羊座</option>
                        <option value="5">金牛座</option>
                        <option value="6">双子座</option>
                        <option value="7">巨蟹座</option>
                        <option value="8">狮子座</option>
                        <option value="9">处女座</option>
                        <option value="10">天秤座</option>
                        <option value="11">天蝎座</option>
                        <option value="12">射手座</option>
                    </select>
                </div>

            </form>
        </div>
        <div class="col-xs-2"></div>
    </div>
    <div class="row demo-row">
        <div class="col-xs-1"></div>
        <div class="col-xs-5">
            <div id="left" class="slotMachine">
                <c:forEach var="img" items="${requestScope.left}" varStatus="status">
                    <div class="slot">
                        <img src="<%=request.getContextPath() %>/images/${img}"/>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="col-xs-1"></div>
        <div class="col-xs-5">
            <div id="right" class="slotMachine">
                <c:forEach var="img" items="${requestScope.right}" varStatus="status">
                    <div class="slot">
                        <img src="<%=request.getContextPath() %>/images/${img}"/>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function(){
        var left = $("#left").slotMachine({
            active  : 0,
            delay : 5000,
            repeat  : false
        });

        var right = $("#right").slotMachine({
            active  : 0,
            delay : 5000,
            repeat  : false
        });

        /*    $("#slotMachineButtonPrev").click(function(){
         machine7.prev();
         });*/

        $("#left .slot img").click(function(){
            right.next();
        });

        $("#right .slot img").click(function(){
            left.next();
        });
    });
</script>
<%@include file="headerfooter/footer.jsp" %>

