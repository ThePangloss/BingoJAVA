beginTimer();


function beginTimer()  {
	myVar = setInterval(loadDoc, 1000);
}



function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
     document.getElementById("derniernumero").innerHTML = xhttp.responseText;
    }
  };
//  xhttp.open("GET", "numero.txt", true);
   xhttp.open("GET", "TimerBingo", true); 
  xhttp.send();
}