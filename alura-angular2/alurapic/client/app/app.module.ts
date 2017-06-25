import 'rxjs/add/operator/map';
import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpModule} from '@angular/http';

import {FotoModule} from './foto/foto.module';
import {PainelModule} from './painel/painel.module';

import {AppComponent} from './app.component';
import {ListagemComponent} from './listagem/listagem.component';
import {CadastroComponent} from './cadastro/cadastro.component';

@NgModule({
    imports: [BrowserModule,FotoModule,HttpModule,PainelModule],
    declarations: [AppComponent,ListagemComponent,CadastroComponent],
    bootstrap: [AppComponent]
})
export class AppModule {}