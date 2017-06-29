import {Pipe, PipeTransform} from '@angular/core';
import {FotoComponent} from './foto.component';

@Pipe({
    name: 'filtroPorTitulo'
})
export class FiltroPorTitulo implements PipeTransform{

    transform(fotos:FotoComponent,digitado:string){
        console.log(fotos);
        console.log(digitado);
    }
}