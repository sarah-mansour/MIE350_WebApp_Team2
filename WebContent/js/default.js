/**
 * This javascript code controls the dropdown boxes
 * It will hide the  model dropdown when the brand dropdown is selected
 *  and vice versa
 */


function updateBrand (e){
	
	var modelInput = document.getElementById('model');
	
	if(this.value == 'null'){
		modelInput.style.display = 'inline';
	}else{
		modelInput.style.display = 'none';
	}
}

function updateModel (e) {
	
	var brandInput = document.getElementById('brand');
	
	if(this.value == 'null'){
		brandInput.style.display = 'inline';
	}else{
		brandInput.style.display = 'none';
	}
	
}

window.onload = () => {
	
	var brandInput = document.getElementById('brand');
	var modelInput = document.getElementById('model');
	
	brandInput.onchange = updateBrand;
	modelInput.onchange = updateModel;
	
}

window.onpageshow = () => {

	var brandInput = document.getElementById('brand');
	var modelInput = document.getElementById('model');
	
	brandInput.onchange();
	modelInput.onchange();
}