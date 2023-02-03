<%--
  Created by IntelliJ IDEA.
  User: weizm
  Date: 2023/1/4
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Interface</title>
    <style>
        #frame_{
            width: 500px;
            height:400px;
            margin-left: 600px;
            margin-top: 210px;
            background-color: azure;
            border: black solid 2px;
        }

        #inner_{
            margin-left: 160px;
            margin-top: 180px;

        }

    </style>
    <%--
       Here is to validate these logic statements

        is user id is null or ""
            get the value from the tage and determine if it is null

            if it is null or ""
                return and prompt the operation: user id can not be empty

       is password is null or ""
            get the value from the tage and determine if it is null

            if it is null or ""
                return and prompt the operation: passwordcan not be empty
    --%>


</head>
<body>

<div id="frame_">
    <div id="inner_">

    User ID: <input type="text" id="u_id"><br><br>
    Password: <input type="password" id="u_pwd"><br><br>

    <button id="btn01">Reset</button>
    <button style="margin-left: 20px" id="btn02">Login</button><br>

    <span id="error" style="=color: red" >${error}</span>

        <script>
           let btn001 = document.getElementById("btn02");
           btn001.onclick = function(){
               //1.get ID tag, to verify is null or empty
               let id_str = document.getElementById("u_id").value;
               if(id_str==null || id_str==""){
                   document.getElementById("error").innerHTML="please enter your username!!"
                   return;
               }
               let pwd_str=document.getElementById("u_pwd").value;
               if(pwd_str==null || pwd_str=="") {
                   document.getElementById("error").innerHTML = "please enter your password!!"
                   return;
               }
               //2, access server
               window.location.href = "./login?u_id=" + id_str + "&u_pwd=" + pwd_str;
           }
        </script>

</div>
</div>
</body>
</html>
