'use strict';

angular.module('Beebot', ['ngAnimate', 'ngResource', 'ngRoute', 'zingchart-angularjs'])

.constant('version', 'v0.1.0')

.config(function ($locationProvider, $routeProvider) {

    $routeProvider
        .when('/sensors/', {
            templateUrl: 'views/home.html'
        })
        .when('/contact', {
            templateUrl: 'views/contact.html'
        })
        .otherwise({
            redirectTo: '/sensors/'
        });

    $locationProvider.html5Mode(false);
});