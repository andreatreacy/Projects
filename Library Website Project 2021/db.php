<!DOCTYPE html>
<html lang="en">
<head>
	<title>Dublin Library</title>
	<link rel="icon" type="image/x-icon" href="images/favicon.ico"> <!-- This will add a favicon -->
</head>
<body>

<?php
//make a connecton to the database
$db = mysqli_connect('localhost', 'root', '', 'library_db');
if($db === FALSE ) die('Fail message');	//if connection is unsuccessful print error message and end

// http://localhost/WebD/Assignment/db.php
?>

</body>
</html>