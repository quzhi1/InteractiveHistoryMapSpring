<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Spring MVC hello world</title>
    <%-- CSS --%>
    <spring:url value="/resources/css/style.css" var="coreCss"/>
    <spring:url value="/resources/css/jquery-ui.css" var="jqueryUiCss"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <link href="${jqueryUiCss}" rel="stylesheet">
</head>

<%-- Script lib --%>
<spring:url value="/resources/lib/jquery-3.1.1.min.js" var="jQueryMin"/>
<spring:url value="/resources/lib/jquery-ui.js" var="jQueryUi"/>
<spring:url value="/resources/lib/jquery.zoom.js" var="jQueryZoom"/>
<script src="${jQueryMin}"></script>
<script src="${jQueryUi}"></script>
<script src="${jQueryZoom}"></script>

<body>

<spring:url value="/" var="root"/>
<a href="${root}">主页</a>
<h1>交互中国历史地图</h1>
<br/>
<p id="imageLookupTableJson" hidden="">${imageLookupTable}</p>

<!-- Map renderer-->
<img src="" id="map"/>
<br/>
<br/>

<!-- Slide bar-->
<div id="slider-bar"></div>

<!-- Year renderer-->
<p id="amount"></p>
<div id="output"></div>
<br/><br/>
<p>图片源：布哈林的历史地图。</p>
<p>布哈林的主页：<a href="http://www.acfun.cn/u/350475.aspx#" target="_blank">A站链接</a></p>
<p>后端支持:<a href="mailto:quzhi65222714@gmail.com?Subject=屈直个人工具%20Support%20Request" target="_blank">屈直</a></p>

<%-- Script --%>
<spring:url value="/resources/javascript/InteractiveMap.js" var="interactiveMapJs"/>
<script src="${interactiveMapJs}"></script>

</body>
</html>
