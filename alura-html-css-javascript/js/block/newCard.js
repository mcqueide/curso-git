var $newCard = document.querySelector('.newCard');
var $newCardContent = $newCard.querySelector('.newCard-content');
var $newCardAction = $newCard.querySelector('.newCard-action');

$newCardContent.addEventListener('input',function() {
  $error = document.querySelector('.error');

  if($error != null){
    $error.remove();
  }
})

$newCard.addEventListener('submit',function(event) {
  event.preventDefault();
  if ($newCardContent.value == '') {

    if (document.querySelector('.error') == null) {
      var $error = document.createElement('span');
      $error.classList.add('error');
      $error.textContent = 'Por favor, preencha o campo acima.';

      $newCard.insertBefore($error, $newCardAction);
    };
  }else {
    var $card = document.querySelector('.card');
    var $copyCard = $card.cloneNode(true);
    $copyCard.querySelector('.card-content').textContent = $newCardContent.value;

    $card.parentNode.insertBefore($copyCard, $card);
  }
});
