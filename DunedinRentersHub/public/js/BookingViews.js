"use strict";
// create a new module, and load the other pluggable modules
var module = angular.module('BookingApp', ['ngResource', 'ngStorage']);

//This is to ensure that the authentication token has been added to Authorization 
//header for every HTTP request
//module.config(function ($sessionStorageProvider, $httpProvider) {
//    // get the auth token from the session storage
//    let authToken = $sessionStorageProvider.get('authToken');
//
//    // does the auth token actually exist?
//    if (authToken) {
//        // add the token to all HTTP requests
//        $httpProvider.defaults.headers.common.Authorization = 'Basic ' + authToken;
//    }
//});



////////////////////////////////////////////////////////////////////////////////
/////////////////Register Factories/////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

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
////////////////////////////////////////////////////////////////////////////////
//////////////////End of register factories/////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////






////////////////////////////////////////////////////////////////////////////////
/////////////////Login Factories////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

//factory for the renterLoingAPI
module.factory('renterLoginAPI', function ($resource) {
    return $resource("/api/renters/:username");
});


//factory for the landlordLoingAPI
module.factory('landlordLoginAPI', function ($resource) {
    return $resource("/api/landlords/:username");
});


//factory for properties
module.factory('propertiesAPI', function ($resource) {
    return $resource("/api/properties");
});

////////////////////////////////////////////////////////////////////////////////
//////////////////End of login factories/////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

//Properties controller
module.controller('PropertiesController', function (propertiesAPI) {

    //load properties
    this.properties = propertiesAPI.query();
    
    
    this.getAllProperties = function(){
        this.properties = propertiesAPI.query();
    };





});












//Register controller
module.controller('RegisterRenterController', function (registerRenterAPI, renterLoginAPI, $window, $sessionStorage, $http) {

//This alert is to check if the controller is being used.
    //alert("in controller");


    //function for registering a renter
    this.registerRenter = function (renter) {
        registerRenterAPI.save(null, renter,
                // success callback
                        function () {
                            $window.location = 'login.html';
                        },
                        // error callback
                                function (error) {
                                    console.log(error);
                                }
                        );
                    };



            //message for users
            this.loginMessage = "Please login to continue.";
            // alias 'this' so that we can access it inside callback functions
            let ctrl = this;




            //login function
            this.login = function (username, password) {

                // generate authentication token
                let authToken = $window.btoa(username + ":" + password);
                // store token
                $sessionStorage.authToken = authToken;
                // add token to the HTTP request headers
                $http.defaults.headers.common.Authorization = 'Basic ' + authToken;
                // get customer from web service
                renterLoginAPI.get({'username': username},
                        // success callback
                                function (renter) {
                                    // also store the retrieved customer
                                    $sessionStorage.renter = renter;
                                    // redirect to home
                                    $window.location = '.';
                                },
                                // fail callback
                                        function () {
                                            ctrl.loginMessage = 'Login failed. Please try again.';
                                        }
                                );
                            };
                });







        //Landlord controller
        module.controller('RegisterLandlordController', function (registerLandlordAPI, landlordLoginAPI, $window, $sessionStorage, $http) {




            //function for registering a landlord
            this.registerLandlord = function (landlord) {
                registerLandlordAPI.save(null, landlord,
                        // success callback
                                function () {
                                    $window.location = 'login.html';
                                },
                                // error callback
                                        function (error) {
                                            console.log(error);
                                        }
                                );
                            };







                    //message for users
                    this.loginMessage = "Please login to continue.";
                    // alias 'this' so that we can access it inside callback functions
                    let ctrl = this;




                    //login function
                    this.login = function (username, password) {

                        // generate authentication token
                        let authToken = $window.btoa(username + ":" + password);
                        // store token
                        $sessionStorage.authToken = authToken;
                        // add token to the HTTP request headers
                        $http.defaults.headers.common.Authorization = 'Basic ' + authToken;
                        // get customer from web service
                        landlordLoginAPI.get({'username': username},
                                // success callback
                                        function (landlord) {
                                            // also store the retrieved customer
                                            $sessionStorage.landlord = landlord;
                                            // redirect to home
                                            $window.location = '.';
                                        },
                                        // fail callback
                                                function () {
                                                    ctrl.loginMessage = 'Login failed. Please try again.';
                                                }
                                        );
                                    };
                        });                      