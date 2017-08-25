angular.module("vs").controller("catalogoSeriesCtrl", function($scope, $http){
  $scope.app = "SI-LAB03";
  $scope.logado = false;
  $scope.usuario;

   $scope.cadastrar = function() {
     var nomeCadastro = prompt("Name:", "Seu nome")
     var emailCadastro = prompt("Email:", "email@email.com");
     var senhaCadastro = prompt("Password:", "***********");
     var admCadastrado = {"nome": nomeCadastro, "email": emailCadastro, "senha": senhaCadastro};
     var promise = $http.post("/administrador/", usuarioCadastrado).then(function(response) {
       if (response.data === "") {
         alert("Email ja cadastrado!");
       } else {
         $scope.usuario = response.data;
         $scope.logado = true;
       }
     }, function error (error) {
       console.log(error);
     });
   };

   $scope.logar = function(nome, email, senha) {
     var emailLogin = prompt("Email:", "email@email.com");
     var senhaLogin = prompt("Password:", "***********");
     var admLogin = {nome: "", email: emailLogin, senha: senhaLogin};
     var promise = $http.post("/administrador/login/", admLogin).then(function(response) {
       $scope.usuario = response.data;
       $scope.logado = true;
       $scope.loadSeries();
     }, function error (error) {
       alert("Incorrect.");
       console.log(error);
     });
   };

  $scope.deslogar = function() {
    if (confirm("DESLOGAR?")) {
      $scope.usuario = undefined;
      $scope.logado = false;
    }
  };
