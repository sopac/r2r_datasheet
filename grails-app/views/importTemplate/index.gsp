<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>

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

    <form>

        <div style="width: 120px">
            <b>Data Type</b>
            <br/>
            <br/>

            <div align="left">
                <input type="radio" id="Avifauna" name="a" value="Avifauna">
                <label for="Avifauna">Avifauna</label><br>
                <input type="radio" id="Biological" name="a" value="Biological">
                <label for="Biological">Biological</label><br>
                <input type="radio" id="FishingBentic" name="a" value="FishingBentic">
                <label for="FishingBentic">Fishing Bentic</label><br>
                <input type="radio" id="FishingCreel" name="a" value="FishingCreel">
                <label for="FishingCreel">Fishing Creel</label><br>
                <input type="radio" id="SocioEconomic" name="a" value="SocioEconomic">
                <label for="SocioEconomic">SocioEconomic</label><br>
                <input type="radio" id="Terrestrial" name="a" value="Terrestrial">
                <label for="Terrestrial">Terrestrial</label><br>
                <input type="radio" id="WaterQuality" name="a" value="WaterQuality">
                <label for="WaterQuality">Water Quality</label><br>
                <input type="radio" id="other" name="gender" value="other">
                <label for="other">Other</label>
            </div>
        </div>




        <br/>
        <label for="myfile">Select a file:</label>


        <input type="file" id="myfile" name="myfile">
        <button>Upload for Validation</button>
    </form>

</div>

</body>
</html>
