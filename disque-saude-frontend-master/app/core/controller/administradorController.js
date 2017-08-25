angular.module("vs").controller("catalogoSeriesCtrl", function($scope, $http){
  $scope.app = "SI-LAB03";
  $scope.logado = false;
  $scope.actualUser;

  $scope.cadastrar = function(userName, userEmail, userPassword){
    if(existeUsuario(userEmail)){
      alert("User already exists!");
    }
    else {
      var user = new Object();
      user.name = userName;
      user.email = userEmail;
      user.password = userPassword;

      $scope.administradores.put(user); // colocar o novo usuario no map, atraves de requiçao

      alert("Successful Registration!");
    }
  }

  var existeUsuario = function(userEmail) {
        for(var i = 0; i < $scope.administradores.length; i++) {
          if($scope.administradores[i].email == userEmail) { // pegar no mapa do service por meio de requisiçao
            return true;
          }
        }
        return false;
  };

  $scope.login = function (userEmail, userPassword) {
    if($scope.actualUser == null) {
      if(getUsuario(userEmail).password == userPassword){
        $scope.actualUser = getUsuario(userEmail); // colocar no atual, buscado por requisição do mapa do service
        alert("Successful login!");
      }
      else {
        alert("Wrong password! Try again!");
      }
    }
    else {
      alert("User already logged! Try to logout first!");
    }
  }

  var getUsuario = function(userEmail) {
        for(var i = 0; i < $scope.administradores.length; i++) {
          if($scope.administradores[i].email == userEmail) { // pegar no mapa do service por meio de requisiçao
            return $scope.users[i];
          }
        }
        return null;
  };

  $scope.logout = function () {
    if($scope.actualUser != null) {
      $scope.actualUser = null;

      alert("Successful logout!");
    }
    else {
      alert("No user logged! Try to loggin first!");
    }
  }
