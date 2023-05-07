<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
    .slide form {
      max-width: 600px;
      margin: 0 auto;
    }
    .slide h2 {
      text-align: center;
    }
    .slide .form-group {
      margin-bottom: 20px;
    }
    label {
      display: block;
      margin-bottom: 5px;
    }
    input[type="text"],
    input[type="email"],
    input[type="password"],
    textarea {
      width: 100%;
      padding: 10px;
      border-radius: 5px;
      border: 1px solid #ccc;
      font-size: 16px;
    }
    input[type="tel"] {
      width: 100%;
      padding: 10px;
      border-radius: 5px;
      border: 1px solid #ccc;
      font-size: 16px;
    }
    button[type="submit"] {
      display: block;
      margin: 0 auto;
      padding: 10px 20px;
      background-color: #008cba;
      color: #fff;
      border-radius: 5px;
      border: none;
      font-size: 16px;
      cursor: pointer;
      margin-top: 51px;
    }
    .slide h2 {
      margin-block-start: 0em;
      padding-top: 50px;
    }

    /* rating */
    .rate {
      float: left;
      height: 46px;
      padding: 0 10px;
    }
    .rate:not(:checked) > input {
      position: absolute;
      top: -9999px;
    }
    .rate:not(:checked) > label {
      float: right;
      width: 1em;
      overflow: hidden;
      white-space: nowrap;
      cursor: pointer;
      font-size: 30px;
      color: #ccc;
    }
    .rate:not(:checked) > label:before {
      content: "★ ";
    }
    .rate > input:checked ~ label {
      color: #ffc700;
    }
    .rate:not(:checked) > label:hover,
    .rate:not(:checked) > label:hover ~ label {
      color: #deb217;
    }
    .rate > input:checked + label:hover,
    .rate > input:checked + label:hover ~ label,
    .rate > input:checked ~ label:hover,
    .rate > input:checked ~ label:hover ~ label,
    .rate > label:hover ~ input:checked ~ label {
      color: #c59b08;
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
            <a href="../admin">
              <li><i class="fa-solid fa-house"></i>Products</li>
            </a>
            <a href="./orderlist.html">
              <li>Orders</li>
            </a>
            <a href="./login.html">
              <li>Logout</li>
            </a>
          </div>
        </div>
      </div>
    </div>
    <div class="slide">
      <div class="container">
        <form action="${pageContext.request.contextPath}/addProduct" method="post" enctype="multipart/form-data">
        <h1>${sessionScope.registeredmessage }</h1>
          <h2>Enter Products Detail</h2>
          <div class="form-group">
            <label for="pid">Product ID</label>
            <input type="text" id="pid" name="pid" required />
          </div>
          <div class="form-group">
            <label for="name">Product Name</label>
            <input type="text" id="pname" name="pname" required />
          </div>
          <div class="form-group">
            <label for="pdesc">Product Description</label>
            <input type="text" id="pdesc" name="pdesc" required />
          </div>
          <div class="form-group">
            <label for="price">Product Price</label>
            <input type="text" id="price" name="price" required />
          </div>
          <div class="form-group">
            <label for="category">Product Category</label>
            <input type="text" id="pcategory" name="pcategory" required />
          </div>

          <div class="form-group">
            <label for="product_image">Product Image</label>
            <input type="file" id="product_image" name="product_image" required/>
          </div>
          <div class="form-group">
            <label for="category">Product Rating</label>
            <div class="rate">
              <input type="radio" id="star5" name="rate" value="5" />
              <label for="star5" title="text">5 stars</label>
              <input type="radio" id="star4" name="rate" value="4" />
              <label for="star4" title="text">4 stars</label>
              <input type="radio" id="star3" name="rate" value="3" />
              <label for="star3" title="text">3 stars</label>
              <input type="radio" id="star2" name="rate" value="2" />
              <label for="star2" title="text">2 stars</label>
              <input type="radio" id="star1" name="rate" value="1" />
              <label for="star1" title="text">1 star</label>
            </div>
          </div>
          <button type="submit">Add Product</button>
          <p><a href="../admin">Go back</a></p>
        </form>
      </div>
    </div>
  </body>
</html>