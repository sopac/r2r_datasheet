<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />

    <title>Export Temlates</title>
</head>
<body>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>
<hr/>


<div align="center">
    <b>Download Data Template for Population and Submission</b>
    <br/><br/>
    <g:link action="export" params="[domainType: 'avifauna']">AviFauna Template</g:link><br/>
    <g:link action="export" params="[domainType: 'biological']">Biological Template</g:link><br/>
    <g:link action="export" params="[domainType: 'fishingbenthic']">Fishing Benthic Template</g:link><br/>
    <g:link action="export" params="[domainType: 'fishingcreel']">Fishing Creel Template</g:link><br/>
    <g:link action="export" params="[domainType: 'socioeconomic']">Socio-Economic Template</g:link><br/>
    <g:link action="export" params="[domainType: 'terrestrial']">Terrrestrial Template</g:link><br/>
    <g:link action="export" params="[domainType: 'waterquality']">Water Quality Template</g:link><br/>

</div>
<br/>
<br/>
<hr/>
</body>
</html>
