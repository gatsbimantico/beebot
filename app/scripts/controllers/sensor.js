'use strict';

angular.module('Beebot')

.controller('sensorController', ['$scope', '$location', 'version', '$resource', '$routeParams', '$timeout', function ($scope, $location, version, $resource, $routeParams, $timeout) {
    console.log($scope);

    $scope.$path = $location.path.bind($location);
    $scope.version = version;
    $scope.serie = [];
    $scope.myJson = {
        type: "area",
        utc: true,
        /* Forces UTC time. */
        plotarea: {
            adjustLayout: true /* attribute for automatic margin adjustment. */
        },
        "plot": {
            "aspect": "spline"
        },
        scaleX: {
            minValue: 1460221184947,
            /* Unix timestamp for January 1, 2015.*/
            step: "second",
            transform: { /* converts Unix timestamps to a more readable format. */
                type: "date",
                /*Set your transform type to "date"*/
                all: "%h:%m:%s %d/%M" /* Specify how you want your date/time formatted*/
            }
        },
        series: [{
            "values": $scope.serie
        }]
    };

    var E = $resource("http://192.168.13.100:8080/sensor/" + $scope.sensor.id + "/historic");

    E.query(function (data) {
        /*
            date:1460211238368
            id:1
            sensor:2
            tipo:2
            value:25
        */
        data.sort(function (a, b) {
            return a.date - b.date;
        });
        $scope.serie = data.map(function (d) {
            return [d.date, d.value];
        });

        window.console.log($scope.sensor.description, $scope.sensor.id, data.length, data);
        if ($scope.serie.length > 0) {
            $timeout(function () {
                $scope.myJson.scaleX.minValue = $scope.serie[0][0];
                $scope.myJson.scaleX.maxValue = $scope.serie[$scope.serie.length - 1][0];
                $scope.myJson.scaleY = {
                    minValue: Math.min.apply(this, $scope.serie.map(function (d) {
                        return d[1];
                    })),
                    maxValue: Math.max.apply(this, $scope.serie.map(function (d) {
                        return d[1];
                    }))
                };
                $scope.myJson.series[0].values = $scope.serie;
                $scope.$apply();
                zingchart.render({
                    id: 'chart-' + $scope.sensor.id,
                    data: $scope.myJson,
                    height: "100%",
                    width: "100%"
                });
            }, 10);
        }
    })
            }]).directive('sensorInfo', function () {
    return {
        templateUrl: 'views/features.html',
        scope: {
            sensor: '='
        },
        controller: 'sensorController'
    };
});;