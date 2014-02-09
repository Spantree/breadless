<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Breadless"/></title>
        <link type="text/css" href="${resource(file: 'bootstrap.css.map')}" />
        <g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
        <div class="container">
            <img src="/images/logo.png" style="height:40px; margin-bottom: 10px"/>
            <div class="masthead">
                <ul class="nav nav-justified">
                    <g:if test="${request.forwardURI == '/'}">
                        <li class="active">
                    </g:if>
                    <g:else>
                        <li>
                    </g:else>
                    <a href="/">Home</a></li>
                    <li><a href="#">Sign up</a></li>


                    <li><a href="#">Vote</a></li>

                    <g:if test="${request.forwardURI =~ /\/sandwich\/[0-9]*/}">
                        <li class="active">
                    </g:if>
                    <g:else>
                        <li>
                    </g:else>
                    <a href="/sandwich/">Make sammich!</a></li>
                </ul>
            </div>
            <g:layoutBody/>
            <div class="footer">
                <p>&copy; Breadless Heavy Industries 2014</p>
            </div>
        </div>
		<r:layoutResources />
	</body>
</html>
