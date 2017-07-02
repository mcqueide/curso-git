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
    service: FotoService;

    constructor(service: FotoService){
        this.service = service;
        this.service.listar()
            .subscribe(
                fotos => this.fotos = fotos,
                erro => console.log(erro)
            );
    }

    remover(foto:FotoComponent){
        this.service.remover(foto)
            .subscribe(
                () => {
                    console.log("Removida com sucesso");
                    let novasFotos = this.fotos.slice(0);

                    let indice = novasFotos.indexOf(foto);
                    novasFotos.splice(indice,1);

                    this.fotos = novasFotos;
                },
                (erro) => console.log(erro)
            );
    }
}