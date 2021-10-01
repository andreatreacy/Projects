<!DOCTYPE html>
<html lang="en">
<head>
	<style>
		<?php include "css/style.css" ?>
	</style> 
</head>
<body>
<header>
<img src="images/header.jpg" alt="Dublin Library icon" class="headerimg">
	<nav>
		<ul>
		  <li><a href="logout.php"><img src="images/x.png" alt="logout icon" class="navlogout">Log Out</a></li>
		  <li><a href="reserved_books.php"><img src="images/user.png" alt="user icon" class="navuser"> <?php echo $username;?></a></li>
		  <li><a href="home.php"><img src="images/home.png" alt="home icon" class="navhome"> Home</a></li>
		</ul>
	</nav>
</header>

<!--  http://localhost/WebD/Assignment/header.php -->
</body>
</html>