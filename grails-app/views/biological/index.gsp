<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'biological.label', default: 'Biological')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-biological" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                 default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-biological" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <div align="center">
        <a href="#">Coral</a><br/>
        <a href="#">Invertebrates</a><br/>
        <a href="#">Mangroves</a><br/>
        <a href="#">Intertidal</a><br/>
        <a href="#">Fish Species</a><br/>
    </div>

    <f:table collection="${biologicalList}"/>

    <div class="pagination">
        <g:paginate total="${biologicalCount ?: 0}"/>
    </div>
</div>
</body>
</html>