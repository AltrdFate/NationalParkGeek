<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<section>
		<c:url value="/survey" var = "formAction"/>
		
		<form action="${formAction}" method="POST">
			<select name="parkcode" id="parkcode">
				<option value="CVNP">Cuyahoga Valley National Park</option>
				<option value="ENP">Everglades National Park</option>
				<option value="GCNP">Grand Canyon National Park</option>
				<option value="GNP">Glacier National Park</option>
				<option value="GSMNP">Great Smokey Mountains National Park</option>
				<option value="GTNP">Grand Teton National Park</option>
				<option value="MRNP">Mount Rainier National Park</option>
				<option value="RMNP">Rocky Mountain National Park</option>
				<option value="YNP">Yellowstone National Park</option>
				<option value="YNP2">Yosemite National Park</option>
			</select>
			
			<label for="emailaddress">Enter your email address</label>
			<input type="text" name="emailaddress" id="emailaddress"/>
			
			<label for="state">Enter your state of residency</label>
			<input type="text" name="state" id="state"/>
			
			<select name="activitylevel" id="activitylevel">
				<option value="inactive">inactive</option>
				<option value="sedentary">sedentary</option>
				<option value="active">active</option>
				<option value="extremely_active">extremely active</option>
			</select>
			
			<input type="submit" value="submitSurvey" id="submitSurvey"/>
		</form>
	</section>
	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />