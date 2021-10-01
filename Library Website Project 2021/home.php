<?php
// Start the session
session_start();
// must start the session before anything else including html tags
require_once "db.php";		//connect to the database using external file
//if user is not logged in redirect to log in page
if(!isset($_SESSION["username"]))
{
	echo '<script>window.location.replace("login.php")</script>';
}
$username = $_SESSION['username'];	// rename the session variable for this page
include "header.php";
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<style>
		<?php include "css/style.css" ?>
	</style> 
	<title>Home</title>
</head>
<body>
<div id="main">
	<section id="search">
		<h2>Search for a Book</h2>

		<h3>Search by Title and Author</h3>
		<!-- the user can enter data into book title and/or author to search for results-->
		<form action="search_results.php" method="post">
		<p><label>Book Title:</label></p>
		<p><input type="text" name="title"></p>
		<p><label>Author:</label></p>
		<p><input type="text" name="author"></p>
		<p><input type="submit" name="search_a_t" value="Search"/></p>
		</form>
		
		<h3>Search by Category</h3>
		<form action="search_results.php" method="post">
		<p><label>Category:</label>
		
		<?php
		echo '<select name="category">';
		echo '<option value=0>-- Please Select --</option>';
		$i = 1;
		$result = mysqli_query($db,"SELECT CategoryID, CategoryDescription FROM Category ORDER BY CategoryID");
		//creating a drop down menu with all the CategoryDescriptions from the database 
		while($row = mysqli_fetch_array($result))
		{
			echo '<option value='.$i.'>'.(htmlentities($row['CategoryDescription'])).'</option>';
			$i++;
		}
		mysqli_close($db);
		?>
		<input type="submit" name="searchcategory" value="Search"/></p>
		</form>
	</section>

	<section id="view_reserved">
		<h2>View Reserved Books</h2>
		<a href="reserved_books.php">My Books</a>
	</section>
</div>
<?php
include "footer.php";
?>
<!--  http://localhost/WebD/Assignment/home.php -->
</body>
</html>