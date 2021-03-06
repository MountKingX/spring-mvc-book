<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <%@ include file="fragment/_style-external-links.jsp" %>
   <link href='<spring:url value="/resources/css/my.css"/>' rel="stylesheet" />
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.1/angular.min.js"></script>
   <script src='<spring:url value="/resources/js/controller.js"/>'></script>
   <title>Cart</title>
</head>
<body>
   <%@ include file="fragment/_naviBar.jsp" %>
   <%@ include file="./fragment/_flash_message.jsp" %>
   <section>
      <div class="jumbotron">
         <div class="container">
            <h1>Cart</h1>
            <p>All the selected products in your cart</p>
         </div>
      </div>
   </section>

   <section class="container" ng-app="cartApp">
      <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">

         <div class="mb-3">
            <a class="btn btn-danger pull-left" ng-click="clearCart()">
               <span class="glyphicon glyphicon-remove-sign"></span> Clear Cart
            </a>
            <a href="#" class="btn btn-success pull-right">
               <span class="glyphicon-shopping-cart glyphicon"></span> Check out
            </a>
         </div>

         <table class="table table-hover">
            <tr>
               <th>Product</th>
               <th>Unit price</th>
               <th>Quantity</th>
               <th>Price</th>
               <th>Action</th>
            </tr>
            <tr ng-repeat="item in cart.cartItems">
               <td>{{item.product.productId}}-{{item.product.name}}</td>
               <td>{{item.product.unitPrice}}</td>
               <td>{{item.quantity}}</td>
               <td>{{item.totalPrice}}</td>
               <td><a href="#" class="label label-danger"
                      ng-click="removeFromCart(item.product.productId)">
                  <button class="btn btn-alert"> Remove</button>
               </a></td>
            </tr>
            <tr>
               <th></th>
               <th></th>
               <th>Grand Total</th>
               <th>{{cart.grandTotal}}</th>
               <th></th>
            </tr>
         </table>
         
         <a href="<spring:url value="/market/products" />" class="btn btn-default">
            <button class="btn btn-lg btn-primary"> Continue shopping </button>
         </a>
      </div>
   </section>
</body>
</html>
