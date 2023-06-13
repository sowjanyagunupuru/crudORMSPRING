<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Update</h1>
  <form action="updatenewem" method="post">
   <table style="with: 80%">
    <tr>
     <td>Emp No</td>
     <td><input type="text" name="empNo" /></td>
    </tr>
    <tr>
     <td> Name</td>
     <td><input type="text" name="eName" /></td>
    </tr>
    <tr>
     <td>Job</td>
     <td><input type="text" name="job" /></td>
    </tr>
    <tr>
     <td>Sal</td>
     <td><input type="text" name="salary" /></td>
    </tr>
    <tr>
     <td>Dept NO</td>
     <td><input type="text" name="deptNo" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
</body>
</html>