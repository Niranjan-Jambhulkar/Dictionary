<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<!-- CSS -->
<link rel="stylesheet" href="Source/css/Dictionary-style.css">

<!-- Java Script -->
<script src="Source/js/Dictionary.js"></script>
</head>
<body class="background-home">
    <h1 class="home-heading col-10">Dictionary</h1>
    <form action="ProfileUpdate" method="post" class="profile-container">
        <p class="">My Profile</p>
        <input type="submit" name="" id="" value="Update" class="update-btn"><br>
        <label class="form-label label">First Name</label>
        <input type="text" class="form-control" value="<%=request.getAttribute("fname") %>">
        <label class="form-label label">Last Name</label>
        <input type="text" class="form-control" value="<%=request.getAttribute("lname") %>">
        <label class="form-label label">Email</label>
        <input type="email" class="form-control" value="<%=request.getAttribute("email") %>">
        <label class="form-label label">User Name</label>
        <input type="text" class="form-control" value="<%=request.getAttribute("user") %>" readonly>

    </form>

</body>
</html>