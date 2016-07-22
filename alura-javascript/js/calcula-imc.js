var peso = document.getElementById("peso-2").textContent;
var altura = document.getElementById("altura-2").textContent;

var pessoa2 = {
	peso : parseFloat(peso),
	altura : parseFloat(altura)
}

if(altura != 0){
	var imc_calculo = peso / (altura * altura);
	var $imc = document.getElementById("imc-2");
	$imc.textContent = imc_calculo;

}else{
	console.log("altura não pode ser 0!");
}
