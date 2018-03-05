angular
    .module('FormsApp', ['ngMaterial'])
    .config(function ($mdThemingProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('purple');
    })
    .controller('FormListController', FormListController);

function FormListController($scope) {
    $.get("/data/form", function (data) {
        $scope.$apply(function () {
            $scope.forms = data;
        });
    }).fail(function () {
        alert("error");
    });
}