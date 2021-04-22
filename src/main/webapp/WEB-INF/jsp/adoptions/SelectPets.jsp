<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<petclinic:layout pageName="owners">

    <h2><fmt:message key="selectPets"/></h2>
    
	<table class="table table-striped">
       

            
          <tr>
          
            <th><fmt:message key="name"/></th>
            <th><fmt:message key="birthDate"/></th>
            <th><fmt:message key="type"/></th>
            <th><fmt:message key="givePet"/></th>
 		
        </tr>
        
         <c:forEach var="pet" items="${pets}">
         
         <td>
         <c:out value="${pet.name}"/>
         </td>
          <td>
         <petclinic:localDate date="${pet.birthDate}" pattern="yyyy-MM-dd"/>
         </td>
         <td>
         <c:out value="${pet.type.name}"/>
         </td>
         <td>
         <spring:url value="/adoptions/new/{petId}" var="petUrl">
                                    <spring:param name="petId" value="${pet.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(petUrl)}"><fmt:message key="givePet"/></a>
         </td>
         </c:forEach>
                
        
     </table>


<td valign="top">
                    <dl class="dl-horizontal">
                        <dt><fmt:message key="name"/></dt>
                        <dd><c:out value="${pet.name}"/></dd>
                        <dt><fmt:message key="birthDate"/></dt>
                        <dd><petclinic:localDate date="${pet.birthDate}" pattern="yyyy-MM-dd"/></dd>
                        <dt><fmt:message key="type"/></dt>
                        <dd><c:out value="${pet.type.name}"/></dd>
                    </dl>

</petclinic:layout>
