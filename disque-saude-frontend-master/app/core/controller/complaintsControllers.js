app.controller("registerComplaintCtrl", function ($scope, $http, toastr, $location) {

    $scope.registerComplaint = function (complaint) {
        $http.post("http://localhost:5000/SpringBootRestApi/queixa/abrirQueixa/", JSON.stringify(complaint))
            .then(function success(response) {
                toastr.success("Queixa adicionada com sucesso!");
                $location.path('/createdcomplaint/' + response.data.id);
                console.log(complaint);
            }, function error(error) {
                console.log(error);
                console.log("Problemas ao tentar adicionar queixa.");
            });
    }
});

app.controller("generalSituationComplaintsCtrl", function ($scope, $http) {

    $scope.situation = "";

    var getGeneralSituationComplaints = function (neighborhood) {
         $http.get("http://localhost:5000/SpringBootRestApi/queixa/situacaoGeralQueixas/")
            .then(function success(response) {
                console.log(response.data);

               $scope.situation = {
                    status: response.data.situacao,
                    color: response.data.cor}
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

app.controller("listComplaints", function($scope, $http) {
    $scope.complaints;

    $scope.getComplaints = function() {
        $http.get("http://localhost:5000/SpringBootRestApi/queixa/listarQueixa/").then(function successCallback(response) {
            console.log(response.data);
            $scope.complaints = response.data;
        }, function errorCallback(error) {
            $scope.complaints = 0;
            console.log(error);
        });
    }
});


app.controller("getOpenComplaints", function ($scope, $http) {

    $scope.openComplaints = 0;
    $scope.openComplaints = function () {
        $http.get("http://localhost:5000/SpringBootRestApi/queixa/queixasAbertas/").then(function successCallback(response) {
            $scope.openComplaints = response.data;
        }, function errorCallback(error) {
            $scope.openComplaints = 0;
            console.log(error);
        });
    }


    $scope.closedComplaints = 0;
    $scope.closedComplaints = function () {
        $http.get("http://localhost:5000/SpringBootRestApi/queixa/queixasFechadas/").then(function successCallback(response) {
            $scope.closedComplaints = response.data;
        }, function errorCallback(error) {
            $scope.closedComplaints = 0;
            console.log(error);
        });
     }
});
