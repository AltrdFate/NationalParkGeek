<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<section  class="parkDetail">
		<c:url value="img/parks/${park.parkImageName}.jpg" var="parkImgURL"/>
		<img src="${parkImgURL}" alt="${park.parkName}"/>
		<h1><c:out value="${park.parkName}"/></h1>
		<ul>
			<li><c:out value="${park.parkDescription}"/></li>
			<li>Year Founded: <c:out value="${park.yearfounded}"/></li>
			<li><c:out value="${park.annualvisitorcount}"/></li>
			<li><c:out value="${park.inspirationalquote}"/></li>
			<li><c:out value="${park.climate}"/></li>
			<li><c:out value="${park.numberofcampsites}"/></li>
			<li><c:out value="${park.milesoftrail}"/></li>
			<li><c:out value="${park.elevation}"/></li>
			<li><c:out value="${park.acerage}"/></li>
			<li><c:out value="${park.state}"/></li>
		</ul>
		
	</section>
	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />