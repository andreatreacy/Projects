<?php
// Start the session
session_start();
// must start the session before anything else including html tags
require_once "db.php";
if(!isset($_SESSION["username"]))
{
	echo '<script>window.location.replace("login.php")</script>';
}
$username = $_SESSION['username'];
include "header.php";
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<style>
		<?php include "css/style.css" ?>
	</style>
  <title>Log Out</title>
</head>
<body>
<div id="logout">
<h1>Log Out</h1>

<?php
if(isset($_POST['logout'])) 
{
	session_destroy();	//end the session and delete session variables
	echo '<script>window.location.replace("login.php")</script>';	//redirect to log in page
}

//create a form to confirm log out
echo "<p>Are you sure you wish to log out?</p>\n";
echo('<form method="post">');
echo('<input type="submit" value="Log Out" name="logout">');
echo('<a href="home.php"> Cancel</a>');
echo("\n</form>\n");

// http://localhost/WebD/Assignment/logout.php
mysqli_close($db);
?>
</div>
<?php
include "footer.php";
?>
</body>
</html>