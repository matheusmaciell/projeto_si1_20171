app.controller("AdmCtrl", function($scope, $http){
  $scope.app = "SI-LAB03"; // mudar esta string
  $scope.logado = false;
  $scope.actualAdm;

  $scope.cadastrar = function(nomeCadastro, emailCadastro, senhaCadastro){
    // var nomeCadastro = prompt("Name:", "Seu nome")
    // var emailCadastro = prompt("Email:", "email@email.com");    utilizar isto, caso o modal nao funcione corretamente
    // var senhaCadastro = prompt("Password:", "***********");
    
    var admCadastrado = {"nome": nomeCadastro, "email": emailCadastro, "senha": senhaCadastro};

    console.log("aqui")
    
    var promise = $http.get("http://localhost:5000/SpringBootRestApi/administrador/cadastrar",admCadastrado).then(function(response) {
      if (response.data === "") {
        alert("Email ja cadastrado!");
      } else {
        $scope.actualAdm = response.data;
        $scope.logado = true;
      }
    }, function error (error) {
      console.log(error);
    });
  }

  $scope.login = function (emailLogin, senhaLogin) {
    // var emailLogin = prompt("Email:", "email@email.com");
    // var senhaLogin = prompt("Password:", "***********");     somente usar caso o modal nao funcione

    var admLogin = {nome: "", email: emailLogin, senha: senhaLogin};

    var promise = $http.post("/administrador/login", admLogin).then(function(response) {
      $scope.actualAdm = response.data;
      $scope.logado = true;
    }, function error (error) {
      alert("Login incorreto!");
      console.log(error);
    });
  }


  $scope.deslogar = function() {
    if (confirm("DESLOGAR?")) {
    $scope.actualAdm = null;
    $scope.logado = false;
 }
}
});