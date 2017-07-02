import {Component} from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'listagem',
    templateUrl: './listagem.component.html'
})
export class ListagemComponent{

    fotos: Object[] = [];

    constructor(){
        // http.get('v1/fotos')
        //     .map(res => res.json())
        //     .subscribe(
        //         fotos => this.fotos = fotos,
        //         erro => console.log(erro)
        //     );
    }
}