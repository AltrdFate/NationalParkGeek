<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<section  class="parkDetail">
		<c:url value="img/parks/${park.parkImageName}.jpg" var="parkImgURL"/>
		<img src="${parkImgURL}" alt="${park.parkName}"/>
		<div>
			<h1><c:out value="${park.parkName}"/></h1>
			<c:out value="${park.parkDescription}"/>
		</div>
		<ul>
			<li>Year Founded: <c:out value="${park.yearfounded}"/></li>
			<li><c:out value="${park.annualvisitorcount} annual visitors"/></li>
			<li><c:out value="Climate: ${park.climate}"/></li>
			<li><c:out value="${park.numberofcampsites} campsites"/></li>
			<li><c:out value="${park.milesoftrail} miles of trail"/></li>
			<li><c:out value="${park.elevation} foot elevation"/></li>
			<li><c:out value="${park.acerage} acres"/></li>
			<li><c:out value="Located in ${park.state}"/></li>
			<li><c:out value="Entry fee: $ ${park.entryfee}.00"/></li>
		</ul>
		<i><q><c:out value="${park.inspirationalquote}"/></q></i> - ${park.inspirationalQuoteSource}
		<div>
			<c:url value="/viewWeather" var="weatherHref">
				<c:param name="parkcode" value="${park.parkCode}"/>
			</c:url>
			<a href="${weatherHref}"><c:out value="View weather for this park"/></a>
		</div>
	</section>
	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />