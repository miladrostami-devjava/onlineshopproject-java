<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0 ,maximum-scale=1.0">
    <title>Online Shop App | Login</title>
    <link href="libs/bootstrap-4.5.2-dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="libs/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script src="libs/angular-cookies.js"></script>
    <script src="libs/bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
    <script src="libs/angular.min.js"></script>
    <link href="libs/fontawesome-free-5.14.0-web/css/all.min.css"  rel="stylesheet">
    <script src="scripts/app.js"></script>
    <link href="styles/panel1.css"  rel="stylesheet">
    <script src="scripts/controllers/panelController.js"></script>
    <script src="scripts/services/ApiHandler.js"></script>
</head>
<body ng-app="onlineShopApp">
<div class="container-fluid" ng-controller="panelCtrl">
    <div class="row">
        <div class="col p-0">
        <div class="panel-header">
            <a href="/logout" class="btn btn-danger btn-sm ">Logout</a>
        </div>
        </div>
    </div>
    <div class="row">
       <div class="col-2 p-0">
           <div class="side-nav">
               <div class="text-center p-3">
                   <img src="images/useravatar.webp" width="100px">
                   <span>{{user.fullName}}</span>
               </div>
               <ul>
                   <li>
                       <a href="#">
                         <i class="fa fa-link"></i>
                         <span>Navigations</span>
                       </a>
                   </li>
                   <li>
                       <a href="#">
                           <i class="fa fa-file"></i>
                           <span>Content</span>
                       </a>
                   </li>
                   <li>
                       <a href="#">
                           <i class="fa fa-photo-video"></i>
                           <span>Sliders</span>
                       </a>
                   </li>
                   <li>
                       <a href="#">
                           <i class="fa fa-newspaper"></i>
                           <span>Blog</span>
                       </a>
                   </li>
                   <li>
                       <a href="#">
                           <i class="fa fa-cubes"></i>
                           <span>Products</span>
                       </a>
                   </li>
                   <li>
                       <a href="#">
                           <i class="fa fa-users"></i>
                           <span>Users</span>
                       </a>
                   </li>
                   <li>
                       <a href="#">
                           <i class="fa fa-shopping-bag"></i>
                           <span>Customers</span>
                       </a>
                   </li>
               </ul>
           </div>
       </div>
       <div class="col p-0">
<div class="main-container">

</div>
       </div>

    </div>
</div>

</body>
</html>