window.onload = newCard;
var colPlace = [0,0,0,0,0,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4];
var usedNum = new Array(76);
function newCard(){
    for(var i = 0; i< 24; i++){
        setSquare(i);
    };
    
    $('.table-bordered1 tr td').removeClass('clicked');
}
function setSquare(thisSquare){
    var currentSquare = "square" + thisSquare;
    var newNum= getNewNum(thisSquare);

    document.getElementById(currentSquare).innerHTML = newNum;
}

function getNewNum(thisSquare){
    var newNum=(colPlace[thisSquare] * 15) + Math.floor(Math.random()*15) + 1;

    for(var i=0; i<76; i++){
        if(usedNum[i] == newNum)
        {
            newNum=(colPlace[thisSquare]*15)+ Math.floor(Math.random()*15) + 1;
        }

    }
    usedNum[thisSquare]=newNum;
    return newNum;
}

function start(){
	
	var visi =  document.getElementById("grille");
	
	visi.style.visibility = "visible";
}

$(document).ready(function(){
	$('.table-bordered1 tr td').on('click', function(){
		if($(this).html()!= "Free")
			$(this).toggleClass('clicked');
	});	
});

/********** Import ***********/

function affichage(){
	var nom=getParameterByName();
	document.getElementById('welcome').innerHTML=nom;
	newCard();
}

function getParameterByName()	{
	ref= window.location.search;
	var nom=ref.substr((ref.lastIndexOf('?')+1));
	
	return nom;
}

function cocher(el) {
	
	if (el.style.backgroundColor != "yellow"){
		el.style.backgroundColor = "yellow";
		win ++;
	}
	else{
		el.style.backgroundColor = "white";
		win --;
	}
}