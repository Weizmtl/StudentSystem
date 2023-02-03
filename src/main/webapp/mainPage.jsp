
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
    <style>
        #head_{
            height: 100px;
            width: 100%;
            background-color: slategray;
        }
        #personFile{
            width: 120px;
            height: 50px;
            padding-top: 25px;
            margin-left: 90%;
        }
        #search{
            height: 70px;
            width: 100%;
            background-color: cornflowerblue;
        }
        #inner_s{
            /*width: 200px;
            height: 40px;
            padding-right: 70%;
            padding-top: 50%;*/
            width: 30%;
            padding-top:25px;
            padding-left: 45%;
        }
        #table{
            margin-left: 30%;
            margin-top: 30px;
        }
        td{
            text-align: center;
            height: 20px;
            width: 150px;
            border: black 1px solid;
            padding:1px;

        }

    </style>

    <script>
        function search() {
            let v = document.getElementById("fileId").value;
            window.location.href = "mainServlet?v="+v+"&id=${User.getU_id()}";
        }

        function goShow(v){
            window.location.href = "show?v="+v+"&id=${User.getU_id()}";
        }

        function del(v,name){
            let isdelete = confirm("Are you sure you want to delete " + v +"'s information?");
            if(isdelete){
                window.location.href = "del?v="+v+"&id=${User.getU_id()}";
            }else{
                return;
            }
        }

        function update(v){
            window.location.href = "update?stuId="+v+"&admId=${User.getU_id()}";
        }

    </script>

</head>
<body>

<div id="head_">
    <div id="personFile">
        Name:<span style="color: red">${User.getU_name()}</span><br>
        ID:<span style="color: red">${User.getU_id()}</span>
    </div>
</div>


<div id="search">
    <div id="inner_s">
        <input type="text" style="font-size: 20px; height: 26px;width: 190px" id="fileId">&nbsp;&nbsp;
        <button  style="font-size: 18px; height: 28px;" onclick="search()">Search</button>
    </div>
</div>

<div>
    <table id="table" style="height: 30px;width: 700px;border: black 1px solid;border-collapse:collapse;">
        <tr >
            <td>ID</td>
            <td>Name</td>
            <td>Phone</td>
            <td>Grade</td>
            <td>Operation</td>
        </tr>
        <c:forEach items="${arr}" var="item">
            <tr>
                <td>${item.getU_id()}</td>
                <td>${item.getU_name()}</td>
                <td>${item.getU_phone()}</td>
                <td><button style="color: chocolate" onclick="goShow(${item.getU_id()})">Show Grade</button></td>
                <td><button style="color: chocolate" onclick="update(${item.getU_id()})">Modify</button>
                    <button style="color: chocolate" onclick="del(${item.getU_id()})">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
</div>
</body>
</html>


