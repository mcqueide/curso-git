var peso = 80;
var altura = 1.80;

if(altura != 0){
	var imc = peso / (altura * altura);
	console.log(imc); // imprime 100
}else{
	console.log("altura não pode ser 0!");
}