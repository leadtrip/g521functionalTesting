<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Fish</title>
</head>

<body>
    <h3>Fish</h3>
    <g:submitToRemote
            value="Get all fish"
            id="allFish"
            name="allFish"
            action="allFish"
            update="allFishDiv" />

    <div id="allFishDiv"></div>
</body>
</html>