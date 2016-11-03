<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section>
	<div>
		<section>
				<h1>Today's Forecast</h1>
				<c:url value="img/weather/${weather[0].forecast}.png" var="imgURL"/>
				<c:set value="partly cloudy" var="pc"/>
				<c:if test="${weather[0].forecast == pc}" >
					<c:url value="img/weather/partlyCloudy.png" var="imgURL"/>
				</c:if>
				<p><img src="${imgURL}"/></p>
				<p>${weather[0].high}</p>
				<p>${weather[0].low}</p>
				<p>${weather[0].forecast}</p>
				<p>${weather[0].forecastRecomendation}</p>
				<c:if test="${weather[0].high >= 75 }">
					<p> Bring an Extra Gallon of Water</p>
				</c:if>
				<c:if test="${weather[0].high - weather[0].low >= 20 }">
					<p> Wear Breathable Layers</p>
				</c:if>
				<c:if test="${weather[0].low <= 20 }">
					<p>Be ware of frigid temperatures</p>
				</c:if>
		</section>
		<section>
			<h2>Five Day Forecast</h2>
			<c:forEach items="${weather}" var="weather">
				<div class="weatherContainer">
				<c:url value="img/weather/${weather.forecast}.png" var="imgURL"/>
				<c:set value="partly cloudy" var="pc"/>
				<c:if test="${weather.forecast == pc}" >
					<c:url value="img/weather/partlyCloudy.png" var="imgURL"/>
				</c:if>
					<p><img src="${imgURL}"/></p>
					<p><c:out value="Low ${weather.low}"/></p>
					<p><c:out value="High ${weather.high}"/></p>
					<p><c:out value="Forecast ${weather.forecast}"/></p>
				</div>
			</c:forEach>
		</section>
		
	</div>
</section>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />