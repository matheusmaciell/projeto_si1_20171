app.controller("searchAverageCtrl", function ($scope, $http) {

    $scope.average = null;

    $scope.searchAveragePerPatient = function (id) {
        $http.get("http://localhost:5000/SpringBootRestApi/unidadeSaude/mediaPacienteMedicoPorDia/" + id).then(function successCallback(response) {
            $scope.average = response.data.obj;
        }, function errorCallback(error) {
            console.log("Unidade Não Encontrada");
        });
    }
});

app.controller("searchHealthUnitCtrl", function ($scope, $http) {

    $scope.units = [];

    $scope.searchHU = function (neighborhood) {
        $http.get("http://localhost:5000/SpringBootRestApi/unidadeSaude/unidadesSaudeBairro/busca?bairro=" + neighborhood)
            .then(function success(response) {
                $scope.units = [];
                $scope.units.push(response.data);
                console.log("Foram encontradas Unidades de saúde");
                console.log(response.data);
            }, function failed(error) {
                console.log("Erro na busca de unidades");
                console.log(error.data.errorMessage);
            });
    }
});

app.controller("addHealthUnitCtrl", function ($scope, $http, toastr, $location) {

    $scope.addHU = function (healthunit) {
        $http.post("http://localhost:5000/SpringBootRestApi/unidadeSaude/incluirUnidade/" + JSON.stringify(healthunit))
            .then(function success(response) {
              toastr.success("Unidade adicionada com sucesso!");
              $location.path('/adminArea');
              response.addHeader("Access-Control-Allow-Origin", "http://localhost:8000");
              console.log(healthunit);
            }, function failed(error) {
                console.log("Erro ao adicionar unidades");
                console.log(error.data.errorMessage);
            });
    }
});
