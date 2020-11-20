(function () {
    "use strict";

    angular.module('autoLocadoraApp')
        .service('autoLocadoraService', autoLocadoraService);

    autoLocadoraService.$inject = ['$http', 'constantes', 'helperFactory'];

    function autoLocadoraService($http, constantes, helper) {

        return {
            listar: listar,
            cadastrar: cadastrar,
            listaCliente : listaCliente,
            buscarCep: buscarCep,
            deletar: deletar,
            buscaCliente : buscaCliente,
            editar: editar
        }

        function listar() {
            return $http.get(constantes.URL_BASE + '/carro')
                .then(function (response) {
                    return response.data;
                })
                .catch(helper.sendError);
        }

        function editar(id, _param){
            return $http.put(constantes.URL_BASE + '/cliente/'+id , _param)
                .then(function (response) {
                    helper.path('/clientes');
                })
                .catch(helper.sendError);
        }

        function cadastrar(_param){
            return $http.post(constantes.URL_BASE + '/cliente', _param)
                .then(function (response) {
                    helper.path('/clientes');
                })
                .catch(helper.sendError);
        }

        function deletar(_params){
            return $http.delete(constantes.URL_BASE + '/cliente/'+ _params)
                .then(function (response) {
                    helper.path('/clientes');
                })
                .catch(helper.sendError);
        }

        function listaCliente() {
            return $http.get(constantes.URL_BASE + '/cliente')
                .then(function (response) {
                    return response.data;
                })
                .catch(helper.sendError);
        }

        function buscaCliente(_params) {
            return $http.get(constantes.URL_BASE + '/cliente/'+_params)
                .then(function (response) {
                    return response.data;
                })
                .catch(helper.sendError);
        }

        function buscarCep(cep){
            return $http.get('http://viacep.com.br/ws/' + cep + '/json')
                .then(function (response) {
                    return response.data;
                })
                .catch(helper.sendError);
        }

    }


})();