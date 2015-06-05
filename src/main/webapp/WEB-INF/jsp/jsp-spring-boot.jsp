<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="demo.PruebaFruta" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://maps.google.com/maps/api/js?sensor=false" 
          type="text/javascript"></script>
</head>
<body>

<h1>Hello Localizador</h1>


<% 
pageContext.setAttribute("frutasBean", new PruebaFruta());
%>
<c:forEach var="MV" items="${frutasBean.frutasVarias}">
<p>
${MV}
<c:set var="stringA" value="${fn:substring(MV, 34, 100)}" />
<c:set var="stringB" value="${fn:split(string2,',')}" />
<c:set var="stringC" value="${fn:split(string3[1],' ')}" />



</p>




</c:forEach>

<div id="map" style="width: 500px; height: 400px;"></div>

  
<% 
pageContext.setAttribute("frutasBean2", new PruebaFruta());
%>
        
  <script type="text/javascript">
  
  
  var locations = 
		[
		<c:forEach var="MR" items="${frutasBean2.frutasVarias}">
		<c:set var="string2" value="${fn:substring(MR, 34, 100)}" />
		<c:set var="string3" value="${fn:split(string2,',')}" />
		<c:set var="string4" value="${fn:split(string3[1],' ')}" />
		
			['<c:out value="${string4[1]}"/>',<c:out value="${string3[0]}"/>,<c:out value="${string4[0]}"/>,<c:out value="0"/>],
		</c:forEach>
		];   
  
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 10,
      
     
      center: new google.maps.LatLng(-33.44,-70.6),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;

    for (i = 0; i < locations.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        map: map
      });

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent(locations[i][0]);
          infowindow.open(map, marker);
        }
      })(marker, i));
    }
  </script>

<h1>FIN</h1>

 
</body>
</html>