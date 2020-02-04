<%@ page import="ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Ticket" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shahab
  Date: 2/3/20
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="../../../resources/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Search Ticket</title>
    <script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<% if (request.getSession().getAttribute("user_data") != null) {%>
<% if (request.getAttribute("purchase") != null) { %>

<div class="alert alert-success alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Success!</strong> <%=request.getAttribute("pre") + " " + request.getAttribute("customerName") + " Your ticket purchase was successful !" + "        Ticket Id: " + request.getAttribute("ticketId") %>
</div>
<% } %>
<div class="container">
    <div class="row mt-5">
        <div class="alert alert-warning" role="alert" style="width: 100%">
            <div><h4>Search Box</h4></div>
            <form class="form-inline" method="get" action="ticketSearch">
                <div class="form-group  mx-sm-3 mb-0">
                    <label for="origin"></label>
                    <input type="text" id="origin" name="origin" class="form-control"
                           placeholder="Origin">
                </div>
                <div class="form-group mx-sm-3 mb-0">
                    <label for="destination"></label>
                    <input type="text" id="destination" name="destination" class="form-control"
                           placeholder="Destination">
                </div>

                <div class="form-group mx-sm-3 mb-0">
                    <label for="departure-date"></label>
                    <input type="date" id="departure-date" name="departure-date" class="form-control"
                           placeholder="Departure Date">
                </div>

                <button type="submit" class="btn btn-primary w-25 mx-sm-5 mb-0 ">Search
                </button>
            </form>
        </div>
    </div>

    <div class="row ">
        <div class="col">
            <div class="table-responsive" style="margin-top: 30px">
                <table class="table table-bordered table-dark">
                    <thead>
                    <tr>
                        <th scope="col">Route
                            : <%=request.getParameter("origin") + " - " + request.getParameter("destination")%>
                        </th>
                        <th scope="col"></th>
                        <th scope="col">Departure Date : <%=request.getParameter("departure-date")%>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Travel ID</th>
                        <th scope="col">Departure Time</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if (request.getParameter("origin") != null) {
                            List<Ticket> ticketList;
                            for (int i = 0, j = 1; i < (ticketList = (List<Ticket>) request.getAttribute("ticketList")).size(); i++, j++) {
                    %>
                    <tr>
                        <td><%=j%>
                        </td>
                        <td><%=ticketList.get(i).getTravelId()%>
                        </td>
                        <td><%=ticketList.get(i).getDepartureTime().getHours() + ":" + ticketList.get(i).getDepartureTime().getMinutes()%>
                        </td>

                        <td>

                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#buy"
                                    onclick="setId(<%=ticketList.get(i).getId()%>)">
                                Buy
                            </button>

                            <div class="modal fade" id="buy" tabindex="-1" role="dialog" aria-labelledby="buyTitle"
                                 aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="buyTitle" style="color: black">Customer
                                                Info</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group">
                                                <form class="text-center" action="purchaseTicket" method="get">
                                                    <label for="customerName"></label>
                                                    <input type="text" id="customerName" name="customerName"
                                                           class="form-control mb-2"
                                                           placeholder="Customer Name">

                                                    <label style="color: black">Gender :</label>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio"
                                                               name="gender" id="male"
                                                               value="male">
                                                        <label class="form-check-label" for="male" style="color: black">Male </label>

                                                        <input class="form-check-input" type="radio"
                                                               name="gender" id="female"
                                                               value="female">
                                                        <label class="form-check-label" for="female"
                                                               style="color: black">Female </label>
                                                        <input id="ID" name="ID" hidden>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary"
                                                                data-dismiss="modal">
                                                            Cancel
                                                        </button>
                                                        <button type="submit" class="btn btn-primary">Save</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <% }
                    }%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<% } else {
    response.sendError(HttpServletResponse.SC_FORBIDDEN);
}%>
<script src="../../../resources/js/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="../../../resources/js/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="../../../resources/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>

