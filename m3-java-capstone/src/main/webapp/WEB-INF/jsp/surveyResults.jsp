<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<section>
		<h1>Survey Results</h1>
		<c:url value="survey" var="surveyURL"/>
		<h2><a href="${surveyURL}">Take Survey</a></h2>
		<c:forEach items="${posts}" var="post">
			<div>
				<ul>
					<li><c:out value="${post.parkcode}"/></li>
				</ul>
			</div>
		</c:forEach>
		
	</section>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />