(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .controller('ListaController', listaController);

    listaController.$inject = ['helperFactory', 'autoLocadoraService', '$rootScope'];

    function listaController(helper, service, $rootScope) {
        var vm = this;
        /* ***************    INIT VARIÁVEIS    *********************************** */

        /* ***************    FUNÇÕES EXECUTADAS NA VIEW (HMTL)    **************** */
        vm.go = helper.go;
        vm.iniciar = iniciar;
        vm.alterar = alterar;
        vm.deletar = deletar;

        function iniciar() {
            
            //limpar escopo
            limpar();

            return vm.listarCliente();
        }

        /* ***************    FUNÇÕES ADD 'VM' PARA TESTES     **************** */
        vm.listarCliente = listarCliente;

        /* ***************    FUNÇÕES INSTERNAS    ******************************** */
        function listarCliente() {

            return service.listaCliente()
            .then(function (response) {
                vm.listarCliente = response;
                console.log(response);
            });
        }

        function alterar(_params){
            
            console.log(_params);
            return service.buscaCliente(_params)
            .then(function (response) {
                console.log(response);
                console.log(response.nome);
                $rootScope.bairro = response.bairro;
                $rootScope.cep = response.cep;
                $rootScope.cidade = response.cidade;
                $rootScope.complemento = response.complemento;
                $rootScope.contato = response.contato;
                $rootScope.cpf = response.cpf;
                $rootScope.email = response.email;
                $rootScope.logradouro = response.logradouro;
                $rootScope.nome = response.nome;
                $rootScope.uf = response.uf;

                helper.path('/clientes/Cadastro');
            });
        }

        function deletar(_params){
            return service.deletar(_params)
            .then(function(){
                listarCliente();
            });
        }

        function limpar(){
            $rootScope.bairro = "";
                $rootScope.cep =  "";
                $rootScope.cidade =  "";
                $rootScope.complemento =  "";
                $rootScope.contato =  "";
                $rootScope.cpf =  "";
                $rootScope.email =  "";
                $rootScope.logradouro =  "";
                $rootScope.nome =  "";
                $rootScope.uf =  "";
        }

    }

})();