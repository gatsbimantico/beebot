'use strict';

angular.module('gatsbimantico.Beebot')

.controller('MainCtrl', ['$scope', '$location', 'version', '$resource', function ($scope, $location, version, $resource) {

    $scope.$path = $location.path.bind($location);
    $scope.version = version;


    var E = $resource("http://192.168.13.100:8080/sensor/2/historic");

    window.console.log(E);
    var entries = E.query(function () {
        console.log(entries);
    });

    $scope.sensors = [
        {
            name: 'Sensor 1',
            t: 25,
            h: 0.8
        }
    ];

}]);