angular
    .module('FormsApp', ['ngMaterial'])
    .config(function ($mdThemingProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('purple')
            .accentPalette('purple');
    })
    .controller('QuizController', FormsController);

function FormsController($scope) {
    $scope.answers = [];

    $scope.sendForm = function () {
        if (!$scope.quiz_form.$valid) {
            alert("Form fill not correct");
        } else {
            $.ajax({
                url: "/answer",
                type: 'post',
                data: JSON.stringify(convertAnswers()),
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                dataType: 'json'
            });
        }
    };

    function convertAnswers() {
        var convertedAnswers = [];
        $scope.answers.forEach(function (answer, index) {
            if (answer.options !== undefined) {
                for (var option in answer.options) {
                    convertedAnswers.push({
                        question: {questionId: index},
                        answerOption: {answerOptionId: option}
                    });
                }
            } else if (answer.text !== undefined) {
                convertedAnswers.push({
                    question: {questionId: index},
                    simpleAnswer: answer.text
                });
            } else {
                convertedAnswers.push({
                    question: {questionId: index},
                    answerOption: {answerOptionId: answer}
                });
            }
        });

        return convertedAnswers;
    }

    $.get("/data" + window.location.pathname.replace("quiz", "form"), function (data) {
        $scope.$apply(function () {
            $scope.form = data;
        });
    }).fail(function () {
        alert("error");
    });
}