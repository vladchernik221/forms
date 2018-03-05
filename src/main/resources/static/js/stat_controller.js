google.setOnLoadCallback(function () {
    angular.bootstrap(document.body, ['FormsApp']);
});
google.load('visualization', '1', {
    packages: ['corechart']
});

angular.module('FormsApp', ['ngMaterial'])

    .config(function($mdThemingProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('purple')
            .accentPalette('purple');
    })

    .controller('StatController', function StatController($scope) {
        $scope.form = {
            name: "Form number one",
            description: "Form number one Form number one Form number one Form number one Form number one Form number one",
            questions: [{
                quest: "Lead Sources",
                data: [
                    ['Ad Flyers', 11],
                    ['Web (Organic)', 4],
                    ['Web (PPC)', 4],
                    ['Yellow Pages', 7]
                ]
            }, {
                quest: "Lead Sources",
                data: [
                    ['Ad Flyers', 11],
                    ['Web (Organic)', 4],
                    ['Web (PPC)', 4],
                    ['Yellow Pages', 7]
                ]
            }]
        };
    })

    .directive('pieChart', function ($timeout) {
        return {
            restrict: 'EA',
            scope: {
                title: '@title',
                width: '@width',
                height: '@height',
                data: '=data',
                selectFn: '&select'
            },
            link: function ($scope, $elm, $attr) {

                // Create the data table and instantiate the chart
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Label');
                data.addColumn('number', 'Value');
                var chart = new google.visualization.PieChart($elm[0]);

                draw();

                // Chart selection handler
                google.visualization.events.addListener(chart, 'select', function () {
                    var selectedItem = chart.getSelection()[0];
                    if (selectedItem) {
                        $scope.$apply(function () {
                            $scope.selectFn({
                                selectedRowIndex: selectedItem.row
                            });
                        });
                    }
                });

                function draw() {
                    if (!draw.triggered) {
                        draw.triggered = true;
                        $timeout(function () {
                            draw.triggered = false;
                            var label, value;
                            data.removeRows(0, data.getNumberOfRows());
                            angular.forEach($scope.data, function (row) {
                                label = row[0];
                                value = parseFloat(row[1], 10);
                                if (!isNaN(value)) {
                                    data.addRow([row[0], value]);
                                }
                            });
                            var options = {
                                'title': $scope.title,
                                'width': $scope.width,
                                'height': $scope.height
                            };
                            chart.draw(data, options);
                            // No raw selected
                            $scope.selectFn({
                                selectedRowIndex: undefined
                            });
                        }, 0, true);
                    }
                }
            }
        };
    });