/**
 * This javascript code will link the car models to the model page in
 * order to display it there
 */

function displayModel (e) {
	window.location.href = `/model.jsp?id=${this.getAttribute('model')}`;
}

window.onload = () => {
	
	var carModels = document.getElementsByClassName('resultimg');
	
	for(var i = 0; i < carModels.length; i++){
		carModels[i].addEventListener('click', displayModel);
	}
}