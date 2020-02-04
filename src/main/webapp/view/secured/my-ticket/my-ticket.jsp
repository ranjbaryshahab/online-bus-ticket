<%@ page import="ir.maktab.java32.projects.servlet.onlinebusticket.features.ticketmanagement.models.Ticket" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shahab
  Date: 2/4/20
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/my-ticket.css">
    <link rel="stylesheet" href="../../../resources/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>My Ticket</title>
    <script type="text/javascript" src="js/my-ticket.js"></script>
</head>
<body>
<% if (request.getSession().getAttribute("user_data") != null) {%>
<% if (request.getAttribute("cancel") != null) { %>
<div class="alert alert-success alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Success!</strong> <%=request.getAttribute("pre") + " " + request.getAttribute("customerName") + " your ticket cancel was successful !" + "        Ticket Id: " + request.getAttribute("ticketId") %>
</div>
<% } %>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand" href="#">Online Bus Ticket</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="../buy-tickets/index.jsp">Search</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="my-ticket.jsp">My Ticket<span
                            class="sr-only">(current)</span></a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="row ">
        <div class="col">
            <div class="table-responsive" style="margin-top: 30px">
                <table class="table table-bordered table-dark">
                    <thead>
                    <tr>
                        <th>
                            <div class="row">
                                <div class="col">
                                    <h3>My Purchased Ticket</h3>
                                </div>
                                <div class="col">
                                    <form method="post" action="myTicketList">
                                        <button class="btn btn-primary btn-sm" type="submit">Show List</button>
                                    </form>
                                </div>
                            </div>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Ticket ID</th>
                        <th scope="col">Departure Date</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if (request.getAttribute("myTicketList") != null) {
                            List<Ticket> ticketList;
                            for (int i = 0, j = 1; i < (ticketList = (List<Ticket>) request.getAttribute("myTicketList")).size(); i++, j++) {
                    %>
                    <tr>
                        <td>
                            <%=j%>
                        </td>
                        <td>
                            <%=ticketList.get(i).getId()%>
                        </td>
                        <td>
                            <%=ticketList.get(i).getDepartureDate()%>
                        </td>

                        <td>

                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#show"
                                    onclick="setTicket('<%=ticketList.get(i).getId()%>',
                                            '<%=ticketList.get(i).getCustomerList().get(0).getCustomerName()%>',
                                            '<%=ticketList.get(i).getCustomerList().get(0).getGender()%>',
                                            '<%=ticketList.get(i).getOrigin()%>',
                                            '<%=ticketList.get(i).getDestination()%>',
                                            '<%=ticketList.get(i).getDepartureDate()%>',
                                            '<%=ticketList.get(i).getDepartureTime()%>',
                                            '<%=ticketList.get(i).getTravelId()%>',
                                            '<%=ticketList.get(i).getCustomerList().get(0).getId()%>',
                                            )">
                                Show
                            </button>

                            <div class="modal fade" id="show" tabindex="-1" role="dialog" aria-labelledby="showTicket"
                                 aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered" role="document">
                                    <div class="modal-content  bg-dark">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="showTicket">Ticket
                                                Info</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group">
                                                <form class="text-center" action="cancelTicket" method="get">

                                                    <label for="ticketId">Ticket Id :</label>
                                                    <input type="text" id="ticketId" name="ticketId"
                                                           class="form-control mb-2" readonly="readonly"
                                                    >

                                                    <label for="customerName">Customer Name :</label>
                                                    <input type="text" id="customerName" name="customerName"
                                                           class="form-control mb-2" readonly="readonly"
                                                    >

                                                    <label for="gender">Gender :</label>
                                                    <input type="text" id="gender" name="gender"
                                                           class="form-control mb-2" readonly="readonly"
                                                    >

                                                    <label for="origin">Origin :</label>
                                                    <input type="text" id="origin" name="origin"
                                                           class="form-control mb-2" readonly="readonly"
                                                    >

                                                    <label for="destination">Destination :</label>
                                                    <input type="text" id="destination" name="destination"
                                                           class="form-control mb-2" readonly="readonly"
                                                    >

                                                    <label for="departureDate">Departure Date :</label>
                                                    <input type="text" id="departureDate" name="departureDate"
                                                           class="form-control mb-2" readonly="readonly"
                                                    >


                                                    <label for="departureTime">Departure Time :</label>
                                                    <input type="text" id="departureTime" name="departureTime"
                                                           class="form-control mb-2" readonly="readonly"
                                                    >


                                                    <label for="travelId">Travel Id :</label>
                                                    <input type="text" id="travelId" name="travelId"
                                                           class="form-control mb-2" readonly="readonly"
                                                    >

                                                    <input id="customerId" name="customerId" hidden>

                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary"
                                                                data-dismiss="modal">
                                                            Cancel
                                                        </button>
                                                        <button type="submit" class="btn btn-primary">Cancel Ticket
                                                        </button>
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
<% } %>
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
