<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ビデオ作品リスト</title>
    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body>

<ul>
	<c:forEach var="video" items="${list}">
		<%-- 販売前・販売中なら表示 --%>
		<c:if test="${not empty video.getValidLicense() }">
			<li class="list-item">
				<p class="item-ttl">${video.title}</p>
				<div class="item-container">
					<div class="item-info">
						<p>${video.synopsisShort}</p>
						<dl>
							<div class="dl-item">
								<dt>販売期間</dt>
								<dd>
									${video.getValidLicense().getFormattedPurchaseStartDate()}～
									${video.getValidLicense().getFormattedPurchaseEndDate()}
									</dd>
							</div>
							<div class="dl-item">
								<dt>価格</dt>
								<dd>${video.getValidLicense().price}円</dd>
							</div>
						</dl>
					</div>
					<c:choose>
						<c:when test="${video.pcNg}">
							<p class="btn negative">PC視聴不可</p>
						</c:when>
						<c:when test="${video.getValidLicense().isBeforeSale()}">
							<p class="btn negative">販売予定</p>
						</c:when>
						<c:otherwise>
						<%-- PC視聴可能なら詳細ボタンを表示 --%>
							<a href="/VideoDetail?id=${video.id}" class="btn">詳細を見る</a>
						</c:otherwise>
					</c:choose>
				</div>
			</li>
		</c:if>
	</c:forEach>
</ul>

</body>
</html>

<%-- 販売前なら販売予定ボタンを表示 --%>
<%--
						<c:when test="${video.isBeforeSale()}">
						
							<p class="btn negative">販売予定</p>
						</c:when>

 --%>
						

						  

<!-- 
	<c:forEach var="video" items="${list}">
		<li class="list-item">
			<div class="list-item-ttl">
					<p class="item-ttl">${video.title }</p>
					<p>${video.synopsisShort }</p>
				</div>
		<div class="item-container">
						<c:choose>
								<c:when test="${video.pcNg}">
										<p class="btn negative">PC視聴不可</p>
								</c:when>

								<c:otherwise>
										<%-- PC視聴可能なら詳細ボタンを表示 --%>
										<a href="/VideoDetail?id=${video.id}　        　"  class="btn">詳細を見る</a>
								</c:otherwise>
						</c:choose>
				</div>
		</li>
	</c:forEach>
 -->
