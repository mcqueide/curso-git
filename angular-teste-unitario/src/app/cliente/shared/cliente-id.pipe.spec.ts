import { ClienteIdPipe } from './';

describe('Suíte de testes de formatação do id do cliente', () => {

    let clienteIdPipe: ClienteIdPipe;

    beforeEach(() => {
        clienteIdPipe = new ClienteIdPipe();
    });

    it('deve retornar o valor do id formatado como ####-#######/##', () => {
        expect(clienteIdPipe.transform('1234567890123')).toEqual('1234-5678901/23');
    });

    it('deve retornar o mesmo valor quando id não conter 13 digitos', () => {
        expect(clienteIdPipe.transform('12345')).toEqual('12345');
        expect(clienteIdPipe.transform('12345678901234')).toEqual('12345678901234');
    });
});