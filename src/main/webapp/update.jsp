<%--
  Created by IntelliJ IDEA.
  User: weizm
  Date: 2023/1/19
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>I will save you</title>
</head>
<style>
  #a{
    width:70%;
    height:600px;
    background-color: lemonchiffon;
    margin-left: 240px;
    margin-top:50px;
    position:absolute;
  }

  #b{
    margin-left:300px;
    margin-top:100px;
  }
  input{
    margin-top: 15px;
    margin-left: 70px;
    font-size: 30px;
    color: red;
    font-family: Arial, serif;

  }
  button{
    background-color: azure;
    width:100px;
    height:25px;
    font-size:20px;
    font-family: Arial, serif;
    margin-left:110px;
  }
  span{
    margin-left: 100px;
    color:red;
  }

</style>
<script>
    function backMainPage(){
        window.location.href = "backMainPage?admId=${admId}"
    }

</script>

<body>
<div id="a">

  <div style="font-size: 40px; margin-top: 40px; margin-left:70px"> Modify score </div>
  <span> Student: &nbsp;${stuId}</span><br>
  <span> Professor: &nbsp;${admId}</span>
  <div id="b">
        Java:&nbsp;&nbsp;<input type="text"><br>
        <br>
        Operation System:&nbsp;&nbsp;<input type="text"><br>
        <br>
        Database:&nbsp;&nbsp;<input type="text"><br>
        <br>
        JavaScrip:&nbsp;&nbsp;<input type="text"><br>
        <br>
        <button onclick="backMainPage()"> Back</button>&nbsp;&nbsp;
        <button>Confirm</button>
  </div>
</div>
</body>
</html>
