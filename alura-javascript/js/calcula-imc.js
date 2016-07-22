var $trPacientes = document.getElementsByClassName("paciente"); //Array de trs
var $botao = document.getElementById("calcula-imcs");
$botao.addEventListener("click",function(){
	percorreArray($trPacientes,modificaColunaImc);
});

function montaPaciente($pacienteTr){
	var $tdNome = $pacienteTr.getElementsByClassName("info-nome")[0];
	var $tdPeso = $pacienteTr.getElementsByClassName("info-peso")[0];
	var $tdAltura = $pacienteTr.getElementsByClassName("info-altura")[0];
	var $tdImc = $pacienteTr.getElementsByClassName("info-imc")[0];

	var paciente = {
		nome : $tdNome.textContent,
		peso : parseFloat($tdPeso.textContent),
		altura : parseFloat($tdAltura.textContent),
		pegaImc : function() {
			if(this.altura != 0){
				var imc_calculo = this.peso / (this.altura * this.altura);
				$tdImc.textContent = imc_calculo;
			}else{
				console.log("altura não pode ser 0!");
			}
		}
	};

	return paciente;
}

function percorreArray($trPacientes,comportamento){
    for (var posicaoAtual = 0; posicaoAtual < $trPacientes.length; posicaoAtual++) {
        comportamento($trPacientes[posicaoAtual]);
    }
}

var modificaColunaImc = function ($pacienteTr){
	var paciente = montaPaciente($pacienteTr);

	paciente.pegaImc();
}
