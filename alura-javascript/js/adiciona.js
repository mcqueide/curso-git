var $pacienteNovo = document.querySelector('.paciente');
var $table = document.querySelector('table');
var $botaoAdicionar = document.querySelector('#adicionar-paciente');

$botaoAdicionar.addEventListener('click',function(event) {
  event.preventDefault();
  $table.innerHTML += $pacienteNovo.innerHTML;
});
