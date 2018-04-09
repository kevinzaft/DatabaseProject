<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <content tag="nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Environment: ${grails.util.Environment.current.name}</a></li>
                <li><a href="#">App profile: ${grailsApplication.config.grails?.profile}</a></li>
                <li><a href="#">App version:
                    <g:meta name="info.app.version"/></a>
                </li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Grails version:
                    <g:meta name="info.app.grailsVersion"/></a>
                </li>
                <li><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>
                <li><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
                <li><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
                <li><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
                <li><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                    <li><a href="#">${plugin.name} - ${plugin.version}</a></li>
                </g:each>
            </ul>
        </li>
    </content>


    <div class="carouselS">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active">
                    <asset:image src="carousel_food/Cake.jpg" class="grails-logo"/>
                </div>

                <div class="item">
                    <asset:image src="carousel_food/Chicken.jpg" class="grails-logo"/>
                </div>

                <div class="item">
                    <asset:image src="carousel_food/Pasta.jpg" class="grails-logo"/>
                </div>

                <div class="item">
                    <asset:image src="carousel_food/Kebab.jpg" class="grails-logo"/>
                </div>

                <div class="item">
                    <asset:image src="carousel_food/Rice.jpg" class="grails-logo"/>
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <div class="card">
        <div id="content" role="main">
            <section class="row colset-2-its">
                <h1>Welcome to Food Critic</h1>
                <p>
                    Food Critic is dedicated to bringing you honest restaurant reviews from a wide selection of people. This website includes
                    ratings and thoughts from many local and not local restaurants. The raters are people who are all intermittent and
                    frequent restaurant goers and their experience and knowledge is shared here with you.
                    Enjoy and Bon Apetit.
                </p>
                <div class="containercard">
                    <button ><g:link controller="Location">Locations</g:link> </button>
                    <button ><g:link controller="MenuItem">Menu Items</g:link> </button>
                    <button ><g:link controller="Rater">Raters</g:link> </button>
                    <button ><g:link controller="Rating">Ratings</g:link></button>
                    <button ><g:link controller="RatingItem">Rating Items</g:link> </button>
                    <button ><g:link controller="Restaurant">Restaurants</g:link> </button>
                </div>

            </section>
        </div>
    <div>

</body>
</html>
