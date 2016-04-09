'use strict';

angular.module('gatsbimantico.Beebot')

  .controller('MainCtrl', function($scope, $location, version) {

    $scope.$path = $location.path.bind($location);
    $scope.version = version;

  });
