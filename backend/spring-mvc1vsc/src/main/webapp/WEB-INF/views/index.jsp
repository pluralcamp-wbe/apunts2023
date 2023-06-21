<html>

<body>
    <h3>Spring MVC example</h3>
    <form action="/hello" method="get">
        <p>What is your name?</p>
        <input type="text" name="name" />
        <input type="submit" />
    </form>
    <br />
    <hr />
    <br />
    <form action="/servertime" method="get">
        <label for="checktime">What time is it now?</label>
        <input id="checktime" type="submit" value="Check time">
    </form>
</body>

</html>