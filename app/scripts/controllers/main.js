'use strict';

angular.module('Beebot')

.controller('MainCtrl', ['$scope', '$location', 'version', '$resource', '$routeParams', function ($scope, $location, version, $resource, $routeParams) {

    $scope.$path = $location.path.bind($location);
    $scope.version = version;


    var E = $resource("http://192.168.13.100:8080/sensor/");

    $scope.sensors = E.query(function (data) {
        $scope.sensors = data;
    });

}]);