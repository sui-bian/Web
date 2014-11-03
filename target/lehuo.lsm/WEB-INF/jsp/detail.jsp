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
<script>
    $(function(){
        $('input').on('change', function(){
            $.get("<%=request.getContextPath() %>/rank/score",{Action:"get",data:this.id,score:$(this).val()});
            $(".rating-input").hide();

        });

        $('#commitsubmit').on("click",function(){
            $.get("<%=request.getContextPath() %>/rank/comment",{Action:"get",linkId:$('#comment').data('imgid'),comment:$('#comment').val()});
        });
    });
</script>
<div id="container" class="container">
    <div class="row">
        <div class="col-xs-8">
            <h1>${link.title}</h1>
            <div class="content-meta">
                <span title="作者" class="icon-user"></span> <a href="${link.authorlink}">楼主</a>
                <span title="发帖时间" class="icon-time ml5"></span>${link.posttime}
                <span title="原链接" class="icon-arrow-right ml5"></span> <a href="${link.link}" target="_blank">原链接</a>
            </div>
            <div class="content">
                <span>${link.content}</span>
                <c:forEach var="img" items="${requestScope.images}">

                    <div class="image">
                        <img src="${img}" class="img-responsive img-rounded" style="max-width: 800px;height: auto"/>
                        <input type="number" name="your_awesome_parameter" id="rating:${img}" class="rating" data-caption="['负分', '不中', '不错哟', '一级棒', '女神']" value="" data-min="1" data-max="5" />
                        <div class="star_bg star_1_s star_margin" id="rating:${img}1" style="display: none"></div>
                        <div class="star_bg star_2_s star_margin" id="rating:${img}2" style="display: none"></div>
                        <div class="star_bg star_3_s star_margin" id="rating:${img}3" style="display: none"></div>
                        <div class="star_bg star_4_s star_margin" id="rating:${img}4" style="display: none"></div>
                        <div class="star_bg star_5_s star_margin" id="rating:${img}5" style="display: none"></div>
                    </div>

                </c:forEach>
            </div>
        </div>
        <div class="col-xs-4">
             <div class="comment">
                 <c:forEach var="comment" items="${requestScope.comment}">
                    ${comment}
                 </c:forEach>
             </div>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <div class="col-xs-12">
                <textarea id="comment" data-imgid="${link.id}" data-valtype="checkbox" class="valtype col-xs-6" >
                </textarea>
                <input type="submit" value="提交" id="commitsubmit"/>
            </div>
        </div>
    </div>
</div>
<%@include file="headerfooter/footer.jsp" %>