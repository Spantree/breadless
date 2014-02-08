<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Build a sandwich</title>
        <r:script disposition='head'>
            window.appModule = 'SandwichBuilder'; //The app module to initialize on the client side.
        </r:script>
        <r:require modules="sandwichBuilderApp, application"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <h2>Sandwich Builder</h2>
                </div>
            </div>
        </div>
    </body>
</html>