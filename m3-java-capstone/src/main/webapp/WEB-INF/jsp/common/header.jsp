<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/css/nationalparklist.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/img/logo.png" var="logoSrc" />
        <a href="${parksHref}">
        		<img src="${logoSrc}" alt="National Park Geek logo" />
        </a>
        <h1>National Parks</h1>
    <nav>
    	<c:url value="/" var="parksHref" />
        <ul>
    		<li><a href="${parksHref}">Home</a></li>
    			<c:url value="/surveyResults" var="surveyHref"/>
    		<li><a href="${surveyHref}">Survey</a></li>
        </ul>
    </nav>
    </header>