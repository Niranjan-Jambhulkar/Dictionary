<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forget Password</title>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<!-- CSS -->
<link rel="stylesheet" href="Source/css/Dictionary-style.css">

<!-- Java Script -->
<script src="Source/js/Dictionary.js"></script>
</head>
<body class="background-forget">
<h1 class="forget-heading">Dictionary</h1>

<form class="forget-container" action="EmailCheck" method="post">
    <p>Reset Password</p>
    <label class="form-label">Enter Register Email ID</label>
    <input type="email" name="email" class="form-control" placeholder="Enter Email" required>
    <input type="submit" value="Submit" class="login-btn">
</form>

</body>
</html>