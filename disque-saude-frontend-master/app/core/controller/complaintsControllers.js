app.controller("registerComplaintCtrl", function ($scope, $http, toastr, $location) {

    $scope.registerComplaint = function (complaint) {
        $http.post("http://localhost:5000/SpringBootRestApi/queixa/abrirQueixa/", JSON.stringify(complaint))
            .then(function success(response) {
                toastr.success("Queixa adicionada com sucesso!");
                $location.path('/createdcomplaint/' + response.data.id);
            }, function error(error) {
                console.log(error);
                console.log("Problemas ao tentar adicionar queixa.");
            });
    }
});

app.controller("generalSituationComplaintsCtrl", function ($scope, $http) {

    $scope.situation = "";

    var getGeneralSituationComplaints = function (neighborhood) {
        $http.get("http://localhost:5000/SpringBootRestApi/unidadeSaude/situacaoGeralQueixas/")
            .then(function success(response) {
<<<<<<< HEAD
                 $scope.situation = "";
                    $scope.situation = {
                        status: response.data.situacao,
                        color: response.data.cor}
=======
                console.log(response.data.obj);

                if(response.data.obj == 0){
                    $scope.situation = {
                        status: "RUIM",
                        color: "label-danger"
                    };

                } else if(response.data.obj == 1){

                    $scope.situation = {
                        status: "REGULAR",
                        color: "label-primary"
                    };
                } else {
                    $scope.situation = ""; // nao entendi esta declaracao aqui
                    $scope.situation = {
                        status: "BOM",
                        color: "label-success"
                    };

                }
>>>>>>> 25aea35923261d1062d052e225db1a283f4f463f
            }, function failed(error) {
                console.log("Erro na busca de unidades");
                console.log(error.data.errorMessage);
            });
    }

    getGeneralSituationComplaints();
});

app.controller("messageCreatedComplaintCtrl", function ($scope, $routeParams) {
    $scope.responseComplaintId = "";
    var showMessage = function () {
        $scope.responseComplaintId = $routeParams.id;
    }

    showMessage();
});

app.controller("searchComplaintCtrl", function ($scope, $http) {
    $scope.complaint;

    $scope.searchComplaint = function (id) {
        $http.get("http://localhost:5000/SpringBootRestApi/queixa/consultarQueixaID/" + id).then(function successCallback(response) {
            $scope.complaint = response.data;
        }, function errorCallback(error) {
            $scope.complaint = null;
            console.log(error);
        });
    }
});
