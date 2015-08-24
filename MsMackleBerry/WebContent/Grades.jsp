<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Example of Bootstrap 3 Vertical Form Layout</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<style type="text/css">
    .bs-example{
    	margin-top: 10%;
    	margin-left: 40%;
    	margin-right: 20%;
    	marfin-bottom: 40%;
    }
</style>
 
<body>
	<div class="bs-example">
    <form action="GradeEntry" method="POST" id="id_div">
    	<h3>Grade inputs</h3>
        <div class="form-group" style="width:30%">
            <label for="assignment">Assignment</label>
            <input type="text" class="form-control" name="assignment" placeholder="assignment">
        </div>
        <div class="form-group" style="width:30%">
            <label for="grade">Grades</label>
            <input type="text" class="form-control" name="grade" placeholder="grades">
        </div>
       
        <input type="submit" value="submit" name="actSubmit" >        
    </form>
    
   </div>
</body>

</html>


	<!-- 
<form action="GradeEntry" method="GET">
     <table class="table table-striped"  style=width:60%>
			<tr> 
     			<th>id</th>
     			<th>first name</th> <br>
     			
     			</tr>
     			</table>
     		
     			+"<th>" + "last name" + "</th><br>"
     			+"<th>" + "city" + "</th><br>"
     			+"<th>" + "postal code" + "</th><br>"
     			+"<th>" + "address line 1" + "</th><br>"
     			+"<th>" + "address line2" + "</th><br>"
     			+"<th>" + "email" + "</th><br>"
     			+ "</tr>"
     			;
			
	        while(result.next()){
	        	line += "<tr>" 
	        			+ "<td>" +result.getString("CUSTOMER_ID") + "</td>"
	        			+"<td>" + result.getString("CUST_FIRST_NAME") + "</td>"
	        			+"<td>" + result.getString("CUST_LAST_NAME") + "</a></td>"
	        			+"<td>" + result.getString("CUST_CITY")+ "</td>"
	        			+"<td>" + result.getString("CUST_POSTAL_CODE")+ "</td>"
	        			+"<td>" + result.getString("CUST_STREET_ADDRESS1")+ "</td>"
	        			+"<td>" + result.getString("CUST_STREET_ADDRESS2")+ "</td>"
	        			+"<td>" + result.getString("CUST_EMAIL")+ "</td>"
	        			+"</tr>"
	        	        ;

	        }
	       
    </form>
     -->