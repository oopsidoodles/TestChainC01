var first;
var last;

function SubmitData()
{
	first = document.getElementById("firstname").value;
	last = document.getElementById("lastname").value;
	
	var request = new XMLHttpRequest();
	request.open("POST", "localhost:1337", true);
	request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	request.onreadystatechange = SentData;
	request.send("first=" + first + "&" + "last=" + last);
}

function SentData()
{
	var out = "";
	out += "First Name: ";
	out += first;
	out += "\n";
	out += "Last Name: ";
	out += last;
	out += "\n";
	//out += "Added to DB"
	
	alert(out);
}