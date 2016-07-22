var $trPacientes = document.getElementsByClassName("paciente"); //Array de trs

for (var posicaoAtual = 0; posicaoAtual < $trPacientes.length; posicaoAtual++) {
	var $pacienteTr = $trPacientes[posicaoAtual];

	var $tdNome = $pacienteTr.getElementsByClassName("info-nome")[0];
	var $tdPeso = $pacienteTr.getElementsByClassName("info-peso")[0];
	var $tdAltura = $pacienteTr.getElementsByClassName("info-altura")[0];

	var paciente = {
		nome : $tdNome.textContent,
		peso : parseFloat($tdPeso.textContent),
		altura : parseFloat($tdAltura.textContent)
	};

	if(paciente.altura != 0){
		var imc_calculo = paciente.peso / (paciente.altura * paciente.altura);
		var $imc = $pacienteTr.getElementsByClassName("info-imc")[0];
		$imc.textContent = imc_calculo;
	}else{
		console.log("altura não pode ser 0!");
	}
}
