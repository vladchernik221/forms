angular
    .module('FormsApp', ['ngMaterial'])
    .config(function($mdThemingProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('purple')
            .accentPalette('purple');
    })
    .controller('LoginController', LoginController);

function LoginController($scope) {
    $scope.user = {};

    $scope.login = function() {
        if(!$scope.login_form.$valid) {
            alert("Form fill not correct");
        } else {
            $.post("/login", $scope.user, function () {
                alert("success");
            }).fail(function () {
                alert("error");
            });
        }
    }
}