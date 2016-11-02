<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<section>
		<div>
			<c:forEach items="parks" var= "park">
				<h3><c:out value="${park.parkname}"/></h3>
			</c:forEach>
			
		</div>
	</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />