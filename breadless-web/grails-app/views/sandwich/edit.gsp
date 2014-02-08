<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
      <title>Build a sandwich</title>
    </head>
    <body>
    <r:script disposition='head'>
        //window.eventShortName = '${eventShortName}';
        //window.rootURL = '${attendeesListLink}';
        window.appModule = 'SandwichBuilder'; //The app module to initialize on the client side.
    </r:script>
    <r:require modules="sandwichBuilderApp"/>
    </body>
</html>