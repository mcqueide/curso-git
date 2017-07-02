import {Component} from '@angular/core';
import {FotoComponent} from '../foto/foto.component';
import {FormGroup,FormBuilder,Validators} from '@angular/forms';

@Component({
    moduleId: module.id,
    selector: 'cadastro',
    templateUrl: './cadastro.component.html'
})
export class CadastroComponent{

    foto: FotoComponent = new FotoComponent();
    meuForm: FormGroup;

    constructor(fb: FormBuilder){
        this.meuForm = fb.group({
            titulo: ['', Validators.compose([Validators.required,Validators.minLength(4)])],
            url: ['', Validators.required],
            descricao: ['']
        });
    }

    cadastrar(event){
        event.preventDefault();
        
        let header = new Headers();
        header.append('Content-Type','application/json');

        // this.http.post('v1/fotos',JSON.stringify(this.foto),{headers:header})
        //     .subscribe(() => {
        //         this.foto = new FotoComponent();
        //         console.log("Foto cadastrada com sucesso.")
        //     }, erro => console.log(erro));
        
    }
}