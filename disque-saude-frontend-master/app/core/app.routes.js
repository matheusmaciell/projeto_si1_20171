app.config(function ($routeProvider) {
    $routeProvider.when("/",{
        templateUrl: "view/home.html",
        controller : "AdmCtrl",
    }).when("/cadastro",{
        templateUrl: "view/cadastro.html",
        controller : "AdmCtrl",
    }).when("/login",{
        templateUrl: "view/login.html",
        controller : "AdmCtrl",
    }).when("/complaint/register", {
        templateUrl: "view/registerComplaint.html",
        controller : "registerComplaintCtrl",
    }).when("/complaintAnimal/register", {
        templateUrl: "view/registerAnimalComplaint.html",
        controller : "registerComplaintCtrl",
    }).when("/searchcomplaint", {
        templateUrl : "view/search_complaint.html",
        controller: "searchComplaintCtrl"
    }).when("/search_health_unit", {
        templateUrl: "view/searchHealthUnit.html",
        controller : "searchHealthUnitCtrl",
    }).when("/searchaverage",{
        templateUrl : "view/search_average_per_patient.html",
        controller: "searchAverageCtrl"
    }).when("/createdcomplaint/:id", {
        templateUrl : "view/successPage.html",
        controller : "messageCreatedComplaintCtrl"
    }).when("/generalSituationComplaints", {
        templateUrl : "view/generalSituationComplaints.html",
        controller : "generalSituationComplaintsCtrl"
    }).when("/adminArea", {
        templateUrl: "view/adminArea.html",
        controller: "AdmCtrl"
    }).when("/analiseQueixa", {
        templateUrl: "view/analiseQueixa.html",
        controller: "listComplaints"
    }).when("/eficiencia", {
        templateUrl: "view/eficiencia.html",
        controller: "getOpenComplaints"
    }).when("/adicionarUnidade", {
        templateUrl: "view/adicionarUnidade.html",
        controller: "addHealthUnitCtrl"
    }).when("/modificarSituacao", {
        templateUrl: "view/modificarSituacao.html",
        controller: "AdmCtrl"
    }).otherwise({
        redirectTo: '/'
    });
});
