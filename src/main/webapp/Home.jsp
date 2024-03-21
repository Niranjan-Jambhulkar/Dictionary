<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<!-- CSS -->
<link rel="stylesheet" href="Source/css/Dictionary-style.css">

<!-- Java Script -->
<script src="Source/js/Dictionary.js"></script>
</head>
<body class="background-home">
<%! 
String a="Meaning"; 
%>
<div class="row">
	<h1 class="home-heading col-10">Dictionary</h1>
	
  	<div class="dropdown col">
  		<button onclick="myFunction()" class="dropbtn" >Hi <%=request.getAttribute("name")%></button>
  		<div id="myDropdown" class="dropdown-content">
    		<a href="">My Profile</a>
    		<a href="">Log Out</a>
  		</div>
	</div>
</div>

<div class="home-container">
    <form action="Search" method="post">
        <label for="word" class="form-label home-label row col-6">Search</label>
        <input type="text" name="word" id="" class="form-control col-6" placeholder="Enter Word" required>
        <textarea name="meaning" id="" cols="38" rows="5" class="form-control home-textarea"  readonly><%
        String meaning = (String)request.getAttribute("a"); 
        if(meaning!=null){
        	out.println(meaning);
        }
        %></textarea>
        <input type="submit" value="Search" class="home-submit-btn">
    </form>
    <div class="option row">
        <p class="option-text option-selection pointer col-6" onClick="Meaning()">Meaning</p>
        <p class="option-text pointer col-6" onClick="addWord()">Add Word</p>
    </div>
</div>

</body>
</html>