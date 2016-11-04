<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<section id="main-content">
		<div>
			<c:forEach items="${parks}" var="park">
			<div id="parkSection" class="parkImage">
				<c:url value="img/parks/${park.parkImageName}.jpg" var="parkImgURL"/>
				<c:url value="/parkDetail" var="parkDetailURL">
					<c:param name="parkcode" value="${park.parkCode}"/>
				</c:url>
				<div><a href="${parkDetailURL}"><img alt="${park.parkName} picture" src="${parkImgURL}"/></a></div>
				<h3><c:out value="${park.parkName}"/></h3>
				<h5>Location: <c:out value="${park.state}"/></h5>
				<p><c:out value="${park.parkDescription}"/></p>
		
			</div>
			</c:forEach>
		</div>
	</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />