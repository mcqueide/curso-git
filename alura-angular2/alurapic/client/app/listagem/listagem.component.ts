import {Component} from '@angular/core';
import {FotoService} from '../foto/foto.service';
import {FotoComponent} from '../foto/foto.component';

@Component({
    moduleId: module.id,
    selector: 'listagem',
    templateUrl: './listagem.component.html'
})
export class ListagemComponent{

    fotos: FotoComponent[] = [];

    constructor(service: FotoService){
        service.listar()
            .subscribe(
                fotos => this.fotos = fotos,
                erro => console.log(erro)
            );
    }

    remover(foto:FotoComponent){
        console.log(foto);
    }
}