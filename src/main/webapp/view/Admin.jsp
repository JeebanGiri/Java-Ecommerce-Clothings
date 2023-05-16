<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <script
      src="https://kit.fontawesome.com/dca5378fb4.js"
      crossorigin="anonymous"
    ></script>
</head>
<style>
    body {
      box-sizing: border-box;
      font-family: Poppins, sans-serif;
      font-size: 13px;
    }
    .row {
      display: flex;
    }
    .container {
      padding-right: 15px;
      padding-left: 15px;
      margin-right: auto;
      margin-left: auto;
      width: 1200px;
    }
    nav,
    .left,
    .right {
      display: flex;
      color: #6c6c6c;
      justify-content: center;
      align-items: center;
    }
    .left {
      gap: 10px;
    }
    .right {
      margin-left: auto;
    }
    li {
      list-style-type: none;
      padding-inline: 10px;
      display: flex;
      gap: 5px;
      align-items: center;
    }
    a {
      text-decoration: none;
      color: #6c6c6c;
    }

    i {
      font-size: 10px;
    }
    a:hover {
      color: #6bce04;
    }
    .bottom {
      padding: 24px 0;
    }

    .menu {
      background-color: #333;
      height: 55px;
    }
    .menu .left i {
      color: white;
      font-size: 17px;
    }
    .category {
      color: white;
      display: flex;
      font-size: 15px;
    }
    .menu .left {
      color: #fff;
      background: #6bce04;
      font-size: 14px;
      font-weight: 700;
      font-family: Poppins, sans-serif;
      text-transform: uppercase;
      cursor: pointer;
      line-height: 55px;
      height: 55px;
      width: 215px;
      justify-content: flex-start;
      padding-inline: 25px;
    }
    .menu .right a {
      color: #fff;
      text-transform: uppercase;
      line-height: 55px;
      padding: 16px 18px;
      font-weight: 600;
      font-size: 14px;
      font-family: Poppins, sans-serif;
      cursor: auto;
    }
    .menu .right li:hover {
      color: #6bce04;
      cursor: pointer;
    }
    .menu .row {
      height: 55px;
    }
    .menu .right i {
      font-size: 12px;
      margin-bottom: 2px;
    }
    .slide {
      background: #f2f2f2;
      padding-bottom: 40px;
      padding-top: 50px;
    }
    /* creating tables */
    .table thead.thead-primary {
      border-collapse: collapse;
      background: #008cba;
    }
    .table thead th {
      border: none;
      padding: 30px;
      font-size: 13px;
      font-weight: 500;
      color: white;
    }
    table {
      min-width: 1000px !important;
      width: 100%;
      background: #fff;
      -webkit-box-shadow: 0px 5px 12px -12px rgba(0, 0, 0, 0.29);
      -moz-box-shadow: 0px 5px 12px -12px rgba(0, 0, 0, 0.29);
      box-shadow: 0px 5px 12px -12px rgba(0, 0, 0, 0.29);
    }
    .table tbody tr {
      margin-bottom: 10px;
    }
    .table tbody th,
    .table tbody td {
      border: none;
      padding: 30px;
      font-size: 14px;
      background: #fff;
      border-bottom: 4px solid #f8f9fd;
      vertical-align: middle;
    }
    .table tbody td.quantity {
      width: 10%;
    }
    .table tbody td .img {
      width: 100px;
      height: 80px;
    }
    .table tbody td .email span {
      display: block;
    }
    .table tbody td .email span:last-child {
      font-size: 12px;
      color: rgba(0, 0, 0, 0.3);
    }
    .checkout {
      margin-top: 20px;
      margin-left: auto;
      bottom: 25px;
      height: 55px;
      width: 150px;
      background-color: #008cba;
      border: none;
      color: #f0f0f0;
      font-weight: bold;
      cursor: pointer;
    }
    .slide h2 {
      text-align: center;
      font-size: 32px;
    }
    .del {
      display: flex;
      justify-content: center;
      height: 30px;
    }
    button.close {
      height: 30px;
      width: 30px;
      cursor: pointer;
    }
  </style>
  <body>
    <div class="menu">
      <div class="container">
        <div class="row">
          <div class="left" onclick="myFunction()">
            <i class="fa-solid fa-bars"></i>
            <div class="dropdown">
              <p class="category">Category</p>
            </div>
          </div>
          <div class="right">
            <a href="">
              <li><i class="fa-solid fa-house"></i>Products</li>
            </a>
            <a href="./orderlist.html">
              <li>Orders</li>
            </a>
            <a href="./view/Login.jsp">
              <li>Logout</li>
            </a>
          </div>
        </div>
      </div>
    </div>
    <div class="slide">
      <div class="container">
        <h2>Product List</h2>
        <table class="table">
          <thead class="thead-primary">
            <tr>
              <th>Product ID</th>
              <th>Image</th>
              <th>Product</th>
              <th>Price</th>
              <th>Category</th>
              <th>&nbsp;</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items="${productList}" var="product">
            <tr>
              <td>${product.productID}</td>
              <td>
                <img src="Images/Product/${product.imageName}" height="50px" width="50px" />
              </td>
              <td>
                <div class="email">
                  <span>${product.productName}</span>
                  <span>${product.productDescripiton }</span>
                </div>
              </td>
              <td>${product.productPrice}</td>
              <td>${product.productCategory}</td>
              <td class="del">
              <a href="delete?id=${product.productID}">
                <button
                  type="button"
                  class="close"
                  data-dismiss="alert"
                  aria-label="Close"
                >
                  <span aria-hidden="true"><i class="fa fa-close"></i></span>
                </button>
                </a>
              </td>
            </tr>
             </c:forEach>
          </tbody>
        </table>
        <div class="row">
          <a href="./view/AddProduct.jsp"><button class="checkout" onclick="add()">Add Product</button></a>
        </div>
      </div>
    </div>

  </body>
</html>