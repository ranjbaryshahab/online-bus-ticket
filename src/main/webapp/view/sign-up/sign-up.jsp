<%--
  Created by IntelliJ IDEA.
  User: shahab
  Date: 2/3/20
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/sign-up.css">
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Sign up</title>

</head>
<body>
<div class="container mt-3" style="max-width: 23rem">
    <div class="row">
        <div class="col">
            <div class="card border-warning mb-3">
                <div class="card-header text-center">
                    <h2>Sign In</h2>
                </div>
                <div class="card-body text-warning">
                    <div class="form-group">
                        <form class="text-center" action="signUp" method="post">

                            <div class="row">
                                <div class="col">
                                    <label for="first-name"></label>
                                    <input type="text" id="first-name" name="first-name" class="form-control mb-2"
                                           placeholder="First Name">

                                    <label for="username"></label>
                                    <input type="text" id="username" name="username" class="form-control mb-2"
                                           placeholder="Username"></div>
                                <div class="col">
                                    <label for="last-name"></label>
                                    <input type="text" id="last-name" name="last-name" class="form-control mb-2"
                                           placeholder="Last name">

                                    <label for="password"></label>
                                    <input type="password" id="password" name="password" class="form-control mb-2"
                                           placeholder="Password"></div>
                            </div>

                            <button class="btn btn-info btn-block" type="submit">Sign up</button>
                        </form>
                    </div>
                    <h6 class="text-center"><a href="../login/login.jsp">Login</a></h6>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="../../resources/js/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="../../resources/js/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="../../resources/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
