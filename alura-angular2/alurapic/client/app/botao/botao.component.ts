import {Component, Input} from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'botao',
    templateUrl : './botao.component.html'
})
export class BotaoComponent{

    @Input() nome: string = 'Ok';
    @Input() estilo: string = 'btn-default';
    @Input() tipo: string = 'buttom';
    @Input() desabilitado: boolean = false;
}