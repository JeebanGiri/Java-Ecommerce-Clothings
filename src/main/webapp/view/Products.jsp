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
    .line {
      height: 1px;
      width: 1px;
      background-color: #6c6c6c;
      width: 100%;
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
    form {
      color: #555;
      display: flex;
      padding: 2px;
      border: 1px solid #f0f0f0;
      border-radius: 23px;
      margin: 0 0 30px;
      margin-left: auto;
      width: 400px;
    }

    input[type="search"] {
      border: none;
      background: transparent;
      margin: 0;
      padding: 10px 18px;
      font-size: 14px;
      color: inherit;
      border-radius: 23px;
      height: 45px;
      font-size: 13px;
      font-style: italic;
      width: 380px;
      background-color: #f0f0f0;
    }

    input[type="search"]::placeholder {
      border: 1px solid transparent;

      color: #bbb;
    }

    button[type="submit"] {
      text-indent: -999px;
      overflow: hidden;
      width: 40px;
      padding: 0;
      margin: 0;
      border: 1px solid transparent;
      border-radius: inherit;
      background: transparent
        url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='16' height='16' class='bi bi-search' viewBox='0 0 16 16'%3E%3Cpath d='M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z'%3E%3C/path%3E%3C/svg%3E")
        no-repeat center;
      cursor: pointer;
      opacity: 0.7;
      margin-left: auto;
    }

    button[type="submit"]:hover {
      opacity: 1;
    }

    button[type="submit"]:focus,
    input[type="search"]:focus {
      border-color: none;
      outline: none;
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
    .drop-down {
      display: none;
      position: absolute;
      z-index: 1;
      border: 1px solid #6bce04;
      width: 263px;
      margin-left: -49px;
      margin-top: -15px;
      font-size: 13px;
      background-color: #fff;
    }
    .drop-down li {
      border-bottom: 1px solid #dddddd;
      color: #6c6c6c;
    }
    .drop-down li:hover {
      box-shadow: #6c6c6c;
      color: #6bce04;
      box-shadow: rgba(0, 0, 0, 0.1) 0px 4px 12px;
    }
    .show {
      display: block;
    }
    .slide {
      background: #f2f2f2;
      padding-bottom: 80px;
    }
    .footer_head {
      height: 60px;
      background-color: #6bce04;
      display: flex;
      justify-content: center;
      align-items: center;
      font-size: 30px;
      text-transform: uppercase;
      color: #ffffff;
    }
    .footer_end {
      height: 60px;
      background-color: #222222;
      display: flex;
      justify-content: center;
      align-items: center;
      color: #6c6c6c;
      font-size: 14px;
    }
    footer .row {
      height: 400px;
      align-items: center;
    }
    .flexbox {
      display: flex;
      gap: 80px;
    }
    .social {
      display: flex;
    }
    .social i {
      font-size: 25px;
    }
    .box li {
      font-size: 18px;
      gap: 15px;
      margin-bottom: 10px;
    }
    .box i {
      font-size: 16px;
    }

    p.product_head {
      margin-top: 0em;
      text-transform: uppercase;
      font-size: 30px;
      font-weight: 900;
      margin-left: 20px;
      padding-top: 20px;
    }
    .products {
      display: flex;
      gap: 50px;
    }
    /* for each product */
    .product {
      height: 320px;
      width: 300px;
      border: 1px solid green;
    }
    .product .image {
      height: 250px;
      width: 200px;
      border: 1px solid green;
      justify-content: center;
    }
    .product .detail {
      height: 36px;
      margin-left:30px;
      margin-top:10px;
      font-size:13px;
      
      
    }
    .product .price {
      height: 30px;
    }
    .product .resp {
      display: flex;
      justify-content: center;
    }
    /* hiding add to cart */
    .addtocartbtn {
      bottom: 20px;
      height: 55px;
      width: 120px;
      overflow:visible;
      margin-top:0px;
      margin-left: 100px;
      background-color: #6bce04;
      border: none;
      color: #f0f0f0;
      font-weight: bold;
      cursor: pointer;
    }

    /* displaying add to cart on hover */
    .product:hover .addtocartbtn {
      display: block;
        z-index: 1;
    }
    .addtocartbtn:hover {
      background-color: #222222;
    }

    @keyframes fadeIn {
      0% {
        opacity: 0;
      }
      100% {
        opacity: 1;
      }
    }

    
  </style>
  <body>
    <nav>
      <div class="container">
        <div class="row">
          <div class="left">
            <p>Support: 9825013777</p>
            <a href="mailto:khadkanripesh@gmail.com">khadkanripesh@gmail.com</a>
          </div>
          <div class="right">
            <a href="./Cart.jsp">
              <li><i class="fa-solid fa-cart-shopping"></i>Cart</li>
            </a>
            <a href="./view/Register.jsp">
              <li><i class="fa-solid fa-user"></i>Create Account</li>
            </a>
            <a href="./view/Login.jsp">
              <li><i class="fa-solid fa-right-to-bracket"></i>Login</li>
            </a>
          </div>
        </div>
      </div>
    </nav>
    <div class="line"></div>
    <div class="bottom">
      <div class="container">
        <div class="row">
          <img alt="" src="./image/LOGO.png" height="70px">
          <form action="${pageContext.request.contextPath}/search" method="post">
            <input type="search" name="search" placeholder="Search..." />
            <button type="submit">Search</button>
          </form>
        </div>
      </div>
    </div>
    <div class="menu">
      <div class="container">
        <div class="row">
          <div class="left" onclick="myFunction()">
            <i class="fa-solid fa-bars"></i>
            <div class="dropdown">
              <p class="category">Category</p>
              <div class="drop-down" id="drop">
                <a href="#">
                  <li>T-Shirt</li>
                </a>
                <a href="#">
                  <li>Pant</li>
                </a>
                <a href="#">
                  <li>Shoe</li>
                </a>
                <a href="#">
                  <li>Fashion</li>
                </a>
              </div>
            </div>
          </div>
          <div class="right">
            <a href="./view/Index.jsp">
              <li><i class="fa-solid fa-house"></i>Home</li>
            </a>
            <a href="products">
              <li>Products</li>
            </a>
          </div>
        </div>
      </div>
    </div>
    <div class="slide">
      <div class="container">
        <p class="product_head">Product List</p>
        <div class="products">
        <c:forEach items="${productList}" var="product">
          <div class="product">
              <div class="resp">
                <div class="image">
                <img src="Images/Product/${product.imageName}" height="250px" width="200px" />
                <a href="cart?id=${product.productID}">
                  <button class="addtocartbtn">
                    <i class="fa-solid fa-cart-shopping"></i> Add to cart
                  </button>
                </a>
                </div>
              </div>
              <div class="detail">${product.productName}</div>
              <div class="price"> Price : Rs. ${product.productPrice}</div>

          </div>
          </c:forEach>
        </div>
      </div>
    </div>
    <footer>
      <div class="footer_head">
        <div class="text">Buy best outfit at your choices</div>
      </div>
      <div class="container">
        <div class="row">
          <div class="flexbox">
            <div class="box">
              <h1>About Lugaharu</h1>
              <a href="#">
                <li><i class="fa-solid fa-location-dot"></i> Nepal</li>
              </a>
              <a href="#">
                <li>
                  <i class="fa-solid fa-envelope"></i>khadkanripesh@gmail.com
                </li>
              </a>
              <a href="#">
                <li><i class="fa-solid fa-phone"></i>9825013777</li>
              </a>
            </div>
            <div class="box1">
              <h1>Find us on:</h1>
              <div class="social">
                <a href="#">
                  <li>
                    <i class="fa-brands fa-facebook"></i>
                  </li>
                </a>
                <a href="#">
                  <li>
                    <i class="fa-brands fa-whatsapp"></i>
                  </li>
                </a>
                <a href="#">
                  <li>
                    <i class="fa-brands fa-twitter"></i>
                  </li>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="footer_end">
        <div class="container">
          <p>
            &copy; <a href="#"><strong>Lugaharu.com</strong> </a>-All Rights
            Reserved.
          </p>
        </div>
      </div>
    </footer>
    <script>
      function myFunction() {
        document.getElementById("drop").classList.toggle("show");
      }

    </script>
  </body>
</html>