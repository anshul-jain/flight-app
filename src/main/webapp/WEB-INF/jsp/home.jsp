<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/js/readDetails.js"></script>
    <title>Home</title>
</head>
<body>
<form>
    Origin : <input type="text" name="origin" id="origin" maxlength="3"/>
    Destination : <input type="text" name="destination" id="destination" maxlength="3"/>
    <button id="search" type="button">Search</button>
    <div id="flightdetails" style="padding:20px 10px 20px 50px">
        <ul class="list-group">
        </ul>
    </div>
</form>
</body>
</html>
