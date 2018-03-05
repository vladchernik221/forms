angular
    .module('FormsApp', ['ngMaterial'])
    .config(function ($mdThemingProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('purple');
    })
    .controller('FormsController', FormsController);

function FormsController($scope) {
    $scope.form = {
        name: "",
        description: "",
        questions: []
    };

    $scope.addOption = function (question) {
        question.answerOptions.push({answer: "New option"});
    };

    $scope.removeOption = function (question, option) {
        question.answerOptions.splice(question.answerOptions.indexOf(option), 1);
    };

    $scope.addQuestion = function () {
        $scope.form.questions.push({text: "New question", type: "", answerOptions: []});
    };

    $scope.saveForm = function () {
        if (!$scope.form_name.$valid) {
            alert($scope.form_name.$valid);
        } else {
            $.ajax({
                url: "/data" + window.location.pathname,
                type: 'post',
                data: JSON.stringify($scope.form),
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                dataType: 'json'
            });
        }
    };

    if (window.location.href.indexOf("new") === -1) {
        $.get("/data" + window.location.pathname, function (data) {
            $scope.$apply(function () {
                $scope.form = data;
            });
        }).fail(function () {
            alert("error");
        });
    }
}