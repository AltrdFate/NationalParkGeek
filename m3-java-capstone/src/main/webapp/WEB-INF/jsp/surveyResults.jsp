<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<section>
		<h1>Survey Results</h1>
		<c:url value="survey" var="surveyURL"/>
		<h2><a href="${surveyURL}">Take Survey</a></h2>
		<table>
			<tr>
				<td>Park</td>
				<td>Votes</td>
			</tr>
			<c:forEach items="${parks}" var="park">
				<tr>
					<td><c:out value="${park.parkname}"/> </td>
					<td> <c:out value="${park.count}"/></td>
				</tr>
			</c:forEach>
		</table>
	</section>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />