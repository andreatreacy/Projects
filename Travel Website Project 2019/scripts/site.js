//checking if js is linked
console.log("Hello world!");

var europe_array = ["europe8.jpg","europe7.jpg","europe6.jpg","europe5.jpg","europe4.jpg","europe3.jpg","europe2.jpg","europe1.jpg"];
var usa_array = ["usa7.jpg","usa8.jpg","usa6.jpg","usa5.jpg","usa4.jpg","usa3.jpg","usa2.jpg","usa1.jpg"];
var asia_array = ["asia3.jpg","asia7.jpg","asia6.jpg","asia5.jpg","asia4.jpg","asia8.jpg","asia2.jpg","asia1.jpg"];
var africa_array = ["africa2.jpg","africa7.jpg","africa6.jpg","africa5.jpg","africa4.jpg","africa3.jpg","africa8.jpg","africa1.jpg"];
var world_array = ["europe8.jpg","usa7.jpg","asia3.jpg","africa8.jpg"];

var image_path = "images/";
			
var counter = 0;

//World 
function worldCarousel()
{
	console.log('World!!');
	path = image_path + world_array[counter];		
	console.log(path);
	counter = counter + 1;
			   
	if(counter > world_array.length-1) 
	{
		counter = 0;
	}
			   
	setTimeout(worldCarousel, 5000);
	transition(path);
}

//Europe 
function europeCarousel()
{
	console.log('Europe!!');
	path = image_path + europe_array[counter];		
	console.log(path);
	counter = counter + 1;
			   
	if(counter > europe_array.length-1) 
	{
		counter = 0;
	}
			   
	setTimeout(europeCarousel, 5000);
	transition(path);
}
		

//Asia 
function asiaCarousel()
{
	console.log('Asia!!');
	path = image_path + asia_array[counter];		
	console.log(path);
	counter = counter + 1;
			   
	if(counter > asia_array.length-1) 
	{
		counter = 0;
	}
			   
	setTimeout(asiaCarousel, 5000);
	transition(path);
}


//USA 
function usaCarousel()
{
	console.log('USA!!');
	path = image_path + usa_array[counter];		
	console.log(path);
	counter = counter + 1;
			   
	if(counter > usa_array.length-1) 
	{
		counter = 0;
	}
			   
	setTimeout(usaCarousel, 5000);
	transition(path);
}


//Africa 
function africaCarousel()
{
	console.log('Africa!!');
	path = image_path + africa_array[counter];		
	console.log(path);
	counter = counter + 1;
			   
	if(counter > africa_array.length-1) 
	{
		counter = 0;
	}
			   
	setTimeout(africaCarousel, 5000);
	transition(path);
}			



	
function transition(path) 
{
	$('#carousel').fadeOut(500, function() {
	$('#carousel').attr("src",path).stop().fadeIn(700);	//fade in the new content to the div
	});
}


//Form

function validate() 
{
	var phone = document.getElementById("phone").value;
	var phone = phone * 1;

	var email = document.getElementById("email").value;
	

	if(document.bookingForm.firstname.value == "")
	{
		document.getElementById("firstnameMessage").innerHTML = " (This field can't be blank!!)";
		alert("All required fields must be filled!!");
		return false;
	}
	
	if(document.bookingForm.lastname.value == "")
	{
		document.getElementById("lastnameMessage").innerHTML = " (This field can't be blank!!)";
		alert("All required fields must be filled!!");
		return false;
	}
	
	if(document.bookingForm.phone.value == "")
	{
		document.getElementById("phoneMessage").innerHTML = " (This field can't be blank!!)";
		alert("All required fields must be filled!!");
		return false;
	}
	
	//Validate number
	if(isNaN(phone))
	{
		//tell the user its not a number
		alert('Phone is not a number!!');
		return false;
	}
	
	if(document.bookingForm.email.value == "")
	{
		document.getElementById("emailMessage").innerHTML = " (This field can't be blank!!)";
		alert("All required fields must be filled!!");
		return false;
	}
	
	//Validate email
	if(validateEmail(email)==false)
	{
		//tell the user its not an email
		alert('Email is not valid!!');
		return false;
	}
	
	if(document.bookingForm.address1.value == "")
	{
		document.getElementById("address1Message").innerHTML = " (This field can't be blank!!)";
		alert("All required fields must be filled!!");
		return false;
	}
	
	if(document.bookingForm.cityTown.value == "")
	{
		document.getElementById("cityTownMessage").innerHTML = " (This field can't be blank!!)";
		alert("All required fields must be filled!!");
		return false;
	}
	
	if(document.bookingForm.countyState.value == "")
	{
		document.getElementById("countyStateMessage").innerHTML = " (This field can't be blank!!)";
		alert("All required fields must be filled!!");
		return false;
	}
	
	if(document.bookingForm.country.value == "")
	{
		document.getElementById("countryMessage").innerHTML = " (This field can't be blank!!)";
		alert("All required fields must be filled!!");
		return false;
	}
	
	if(document.bookingForm.cardholder.value == "")
	{
		document.getElementById("cardholderMessage").innerHTML = " (This field can't be blank!!)";
		alert("All required fields must be filled!!");
		return false;
	}
	
	if(document.bookingForm.cardNumber.value == "")
	{
		document.getElementById("cardNumberMessage").innerHTML = " (This field can't be blank!!)";
		alert("All required fields must be filled!!");
		return false;
	}
	
	if(document.bookingForm.cvv.value == "")
	{
		document.getElementById("cvvMessage").innerHTML = " (This field can't be blank!!)";
		alert("All required fields must be filled!!");
		return false;
	}
	
	if(document.bookingForm.date.value == "")
	{
		document.getElementById("dateMessage").innerHTML = " (This field can't be blank!!)";
		alert("All required fields must be filled!!");
		return false;
	}
	
	alert("Form submitted successfully!!");
	return true;
}



function validateEmail(email)
{
		var	re	= /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		return re.test(email);
}


var review_array = ["Trailblazer Tours is awesome ★★★★★","I saw all of Europe in 30 days! ★★★★★","That was the best holiday ever ★★★★★","The guides are so knowledgeable ★★★★★","The hotels are beautiful ★★★★★","The bus is very comfy ★★★★★"];

var reviewCounter = 0;


function nextReview() {
	document.getElementById("message").innerHTML = review_array[reviewCounter];
	reviewCounter++;
	
	$("#message").fadeOut(function() {
	$(this).text(review_array[reviewCounter])
	}).fadeIn(3000);
	
	setTimeout(nextReview,3000);
		
	if(reviewCounter==review_array.length) {
		reviewCounter = 0;
	}
}

