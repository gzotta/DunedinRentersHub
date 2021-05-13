"use strict";

// create a new module, and load the other pluggable modules
var module = angular.module('BookingApp', ['ngResource', 'ngStorage']);

//factory for the registerRenterAPI
module.factory('registerRenterAPI', function ($resource) {
    return $resource("/api/registerRenter");
});

//factory for the registerLandlordAPI
module.factory('registerLandlordAPI', function ($resource) {
    return $resource("/api/registerLandlord");
});

//factory for the registerServiceAPI
module.factory('registerServiceAPI', function ($resource) {
    return $resource("/api/registerService");
});

//Register controller
module.contoller('RegisterController', function (registerRenterApi, registerLandlord, registerService) {

});
