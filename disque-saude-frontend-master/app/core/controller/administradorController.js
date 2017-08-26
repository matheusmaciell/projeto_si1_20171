app.controller("AdmCtrl", function($scope, $http){
  $scope.logado = false;
  $scope.actualAdm;

  $scope.cadastrar = function(complaint){
    // var nomeCadastro = prompt("Name:", "Seu nome")
    // var emailCadastro = prompt("Email:", "email@email.com");    utilizar isto, caso o modal nao funcione corretamente
    // var senhaCadastro = prompt("Password:", "***********");
    
    //var admCadastrado = {"nome": nomeCadastro, "email": emailCadastro, "senha": senhaCadastro};

   

    //console.log(admCadastrado)
    
    var promise = $http.post("http://localhost:5000/SpringBootRestApi/administrador/cadastrar", JSON.stringify(complaint)).then(function(response) {
       console.log(response)
      if (response.config.data === "") {
        alert("Email ja cadastrado!");
      } else {
        $scope.actualAdm = response.config.data;
        $scope.logado = true;
        alert("Email cadastrado com sucesso!")
      }
    }, function error (error) {
       
        //console.log(error);
    });
  }

  $scope.login = function (userEmail, userPassword) {
  
    var promise = $http.post("http://localhost:5000/SpringBootRestApi/administrador/login", userEmail).then(function(response) {
      if(response.data.senha === userPassword){
        alert("Logado")
        $scope.actualAdm = response.data;
      $scope.logado = true;
      }  
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