<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New bet</title>
<spring:url value="/resources" var="resourceUrl"/>
<link media="screen" rel="stylesheet" href="${resourceUrl}/css/style.css" type="text/css" />
<script type="text/javascript" src="${resourceUrl}/js/jquery.js"></script>
<script type="text/javascript" src="${resourceUrl}/js/myjs.js"></script>
</head>
<body>
	<div id="stylized" class="myform">
		<form:form name="form" method="post" action="saveBet" modelAttribute="bet">
			<h1>New Pick</h1>
			<p>Form to add bets into database</p>

			<div style="float:left;margin-right:20px;">
			<form:label path="sport">Sport 
				<span class="small">Select sport</span>
			</form:label> 
			<form:input path="sport" id="sportId"/> 
			</div>

			<div style="float:left;margin-right:20px;">
			<form:label path="tournament">Tournament
				<span class="small">ATP / Challenger</span>
			</form:label> 
			<input id="filterTournament" name="filterTournament" /> 
			<form:select id="tournament" path="tournament">
				<form:option value="Nothing selected" />
			</form:select>
			</div>
			
			<div style="float:left;margin-right:20px;">
			<form:label path="playerOne">Player 1
				<span class="small">Select player</span>
			</form:label> 
			<input id="filterPlayerOne" name="filterPlayerOne"/> 
			<%-- <form:select path="playerOne" items="${playerList }" itemLabel="name" itemValue="id"/> --%> 
			<form:select id="playerOne" path="playerOne">
				<form:option value="Nothing selected" />
			</form:select>
			
			
			</div>
			
			<div style="float:left;margin-right:20px;">
			<form:label path="playerTwo">Player 2
				<span class="small">Select player</span>
			</form:label> 
			<input id="filterPlayerTwo" name="filterPlayerTwo"/> 
			<form:select id="playerTwo" path="playerTwo">
				<form:option value="Nothing selected" />
			</form:select>
			
			</div>
 			
 			<div style="float:left;margin-right:20px;">
			<button type="submit">Insert pick</button>
			<div class="spacer"></div>
			</div>

		</form:form>
	</div>
</body>
</html>