<?php
// Start the session
session_start();
// must start the session before anything else including html tags
require_once "db.php";		//connect to the database using external file
// $db is the name of the database connection from db.php
include "header_alt.php";	// add the external header to the page
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<style>
		<?php include "css/style.css"?>
	</style>
	<title>Log In</title>
</head>
<body>
<div id="main">
	<section id="login">
	<h2>Log In</h2>
	<form method="post">
	<p>Userame:</p>
	<p><input type="text" name="username"></p>
	<p>Password:</p>
	<p><input type="password" name="password"></p>
	<p><input type="submit" name="log_in" value="Log In"/></p>
	</form>

	<?php
	//check the form has been submitted
	if(isset($_POST["log_in"]))
	{	
		//this wont run until the values are set (the form is completed)
		if(!$_POST['username'] || !$_POST['password'])
		{
			echo '<span>Incorrect log in details. Please try again</span>';
		}
		else
		{
			$username = mysqli_real_escape_string($db, $_POST['username']);		// whatever characters are entered will be taken as one string
			$password = mysqli_real_escape_string($db, $_POST['password']);
			
			$result = mysqli_query($db,"SELECT Username, Password FROM Users");
			while($row = mysqli_fetch_row($result)) 
			{
				//check if the username and password matches data in the database
				if(htmlentities($row[0])==$username)
				{
					if(htmlentities($row[1])==$password)
					{	
						//set a session variable. this will be stored until the session ends (user logs out) and can be used over multiple pages
						$_SESSION["username"] = $username;
						echo '<script>window.location.replace("home.php")</script>';	//redirect to homepage
					}//end inner if
				}//end if
			}//end while
			
			//if username or password does not match one in the database this will print
			echo '<span>Incorrect log in details. Please try again</span>';
		}//end else
	}//end if

	mysqli_close($db);

	// http://localhost/WebD/Assignment/login.php
	?>
	</section>
	
	<section id="register">
	<h2>Register</h2>
	<p>Please register to avail of this service</p>
	<br>
	<a href="register.php"><button type="button">Register</button></a>
	</section>
</div>	<!--end main-->
<?php
include "footer.php";	// add the external footer to the page
?>
</body>
</html>