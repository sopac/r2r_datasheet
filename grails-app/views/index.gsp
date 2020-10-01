<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>

<body>
<content tag="nav">

    <li class="dropdown">
        <a href="#"><b>State of Coast Data Sheet Register</b><br/>
            Pacific Ridge to Reef Programme
        </a>
    </li>

</content>

<div class="svg" role="presentation">
    <div class="grails-logo-container">
        <asset:image src="r2r.png" class="Ridge to Reef"/>
    </div>
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Data Register</h1>

        <div style="text-align: center">
            The Data Register forms an integral part of the State of the Coast Information Management System, which as a whole is envisioned as a decision-making tool for supporting national ICM/IWRM reforms and investment plans, and socio-economic and environmental improvements including poverty reduction, sustainable livelihoods and disaster and climate resilience.
            <br/><br/>
            The current version of the data register enables the management and analysis of environmental and socio-economic data that has been captured on the ground and mined through secondary data sources by the Pacific Ridge to Reef Programme and STAR IW Project. These datasets include forestry surveys, water quality assessments, creel surveys and so forth. To compliment the Pacific Ridge to Reef Science-Policy Approach, stakeholders are encouraged to take ownership to maximise existing data through contribution of data and assets.

            <!--
            <a href="https://www.pacific-r2r.org/r2r-science-portal" style="text-decoration: none">www.pacific-r2r.org/r2r-science-portal</a>
            -->
            <br/><br/>

            <h2>Data Types</h2>

            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
                <g:if test="${!c.name.toLowerCase().contains("template")}">
                    <g:if test="${!c.name.toLowerCase().equals("init")}">
                        <g:if test="${!c.name.toLowerCase().equals("site")}">
                            <g:link controller="${c.logicalPropertyName}">${org.apache.commons.lang3.StringUtils.join(org.apache.commons.lang3.StringUtils.splitByCharacterTypeCamelCase(c.name), ' ')}</g:link> |
                        </g:if>
                    </g:if>
                </g:if>
            </g:each>

            <h2>Data Actions</h2>
            <a class="btn btn-primary" style="text-decoration: none" href="${createLink(controller: 'exportTemplate')}"
               role="button">Export Templates</a>
            <a class="btn btn-success" style="text-decoration: none" href="${createLink(controller: 'importTemplate')}"
               role="button">Import Data Templates</a>
            <a class="btn btn-danger" style="text-decoration: none" href="${createLink(controller: 'analysis')}" role="button">Analytics</a>

        </div>

        <!--
        <div id="controllers" role="navigation">
            <h2>Available Controllers:</h2>
            <ul>
                <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
            <li class="controller">
            <g:link controller="${c.logicalPropertyName}">${c.name}</g:link>
            </li>
        </g:each>
            </ul>
        </div>
        -->
        <br/><br/>

    </section>
</div>

</body>
</html>
