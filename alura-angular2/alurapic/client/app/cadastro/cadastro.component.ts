import {Component} from '@angular/core';
import {FotoComponent} from '../foto/foto.component';
import {Http,Headers} from '@angular/http';

@Component({
    moduleId: module.id,
    selector: 'cadastro',
    templateUrl: './cadastro.component.html'
})
export class CadastroComponent{

    foto: FotoComponent = new FotoComponent();
    http: Http;

    constructor(http:Http){
        this.http = http;
    }

    cadastrar(event){
        event.preventDefault();
        
        let header = new Headers();
        header.append('Content-Type','application/json');

        this.http.post('v1/fotos',JSON.stringify(this.foto),{headers:header})
            .subscribe(() => {
                this.foto = new FotoComponent();
                console.log("Foto cadastrada com sucesso.")
            }, erro => console.log(erro));
        
    }
}