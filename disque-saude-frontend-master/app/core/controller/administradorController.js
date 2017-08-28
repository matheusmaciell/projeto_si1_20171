app.controller("AdmCtrl", function($scope, $http){
  $scope.logado = false;
  $scope.actualAdm;


  $scope.situacaoPrefeitura = function(estado){
    console.log(estado);



    $http.post("http://localhost:5000/SpringBootRestApi/queixa/situacaoPrefeitura",estado).then(function (response) {
              alert("Prefeitura modificada para " + estado + " com sucesso")

              // console.log(response)
          }, function (response) {
                console.log(response)

          });
  }
  $scope.cadastrar = function(complaint){
    if ($scope.logado === false) {
      var promise = $http.post("http://localhost:5000/SpringBootRestApi/administrador/cadastrar", JSON.stringify(complaint)).then(function(response) {
         console.log(response)
        if (response.config.data === "") {
          alert("Email ja cadastrado!");
        } else {
          $scope.actualAdm = response.config.data;
          $scope.logado = true;
          alert("Email cadastrado com sucesso!")
          window.location.assign("http://localhost:8000/#!/home");
        }
      }, function error (error) {

          //console.log(error);
      });
    }
  }

  $scope.login = function (userEmail, userPassword) {
    if ($scope.logado === false) {
      var promise = $http.post("http://localhost:5000/SpringBootRestApi/administrador/login", userEmail).then(function(response) {
        if(response.data.senha === userPassword){
          alert("Logado")
          $scope.actualAdm = response.data;
        $scope.logado = true;
        window.location.assign("http://localhost:8000/#!/adminArea");
        }
      }, function error (error) {
        alert("Login incorreto!");
        console.log(error);
      });
    }
  }


  $scope.deslogar = function() {
    if (confirm("DESLOGAR?")) {
    $scope.actualAdm = null;
    $scope.logado = false;
 }
}
});
