(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .controller('CadastroController', cadastroController);

    cadastroController.$inject = ['helperFactory', 'autoLocadoraService', '$rootScope'];

    function cadastroController(helper, service, $rootScope) {
        var vm = this;
        /* ***************    INIT VARIÁVEIS    *********************************** */
        
        /* ***************    FUNÇÕES EXECUTADAS NA VIEW (HMTL)    **************** */
        vm.go = helper.go;
        vm.iniciar = iniciar;
        vm.buscar = buscar;
        vm.salvar = salvar;
        vm.user = [];
        vm.editar  = false;

        function iniciar() {
            vm.go();
            vm.botao = "Cadastrar";
            
            console.log($rootScope.bairro);

            //preenche os campos para edição
            if($rootScope.bairro != null && $rootScope.bairro != "") {
                vm.user.bairro = $rootScope.bairro;
                vm.user.cep = parseInt($rootScope.cep,10);
                vm.user.cidade = $rootScope.cidade;
                vm.user.complemento = $rootScope.complemento;
                vm.user.contato = parseInt($rootScope.contato,10);
                vm.user.cpf = $rootScope.cpf;
                vm.user.email = $rootScope.email;
                vm.user.logradouro = $rootScope.logradouro;
                vm.user.nome = $rootScope.nome;
                vm.user.uf = $rootScope.uf;
                
                
                vm.botao = "Salvar";
                vm.editar = true;
            } 
        }

        function salvar(){
            if(vm.editar){
                alterar();
            } else {
                cadastrar();
            }
        }

        /* ***************    FUNÇÕES INTERNAS    ******************************** */

        function cadastrar() {
            var novoCliente = {

                bairro: vm.user.bairro,
                cep: vm.user.cep,
                cidade: vm.user.cidade,
                complemento: vm.user.complemento,
                contato: vm.user.contato,
                cpf: vm.user.cpf,
                email: vm.user.email,
                logradouro: vm.user.logradouro,
                nome: vm.user.nome,
                uf: vm.user.uf
            };

            return service.cadastrar(novoCliente);

        }

        function alterar() {
            var editarCliente = {

                bairro: vm.user.bairro,
                cep: vm.user.cep,
                cidade: vm.user.cidade,
                complemento: vm.user.complemento,
                contato: vm.user.contato,
                cpf: vm.user.cpf,
                email: vm.user.email,
                logradouro: vm.user.logradouro,
                nome: vm.user.nome,
                uf: vm.user.uf
            };

            return service.editar(vm.user.cpf, editarCliente );

        }

    

    function buscar(cep){
        return service.buscarCep(cep)
            .then(function (response) {
                console.log(response)
                vm.user.bairro = response.bairro;
                vm.user.cidade = response.localidade;
                vm.user.uf = response.uf;
                vm.user.logradouro = response.logradouro;
            });
    }

}

})();