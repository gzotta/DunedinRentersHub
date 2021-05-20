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

//factory for the serivcesLoingAPI
module.factory('servicesLoginAPI', function ($resource) {
    return $resource("/api/services/:username");
});


////////////////////////////////////////////////////////////////////////////////
//////////////////End of login factories/////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////////
/////////////////Property Factories////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

//factory for properties
module.factory('propertiesAPI', function ($resource) {
    return $resource("/api/properties");
});

//factory for number of bedrooms
module.factory('bedroomsAPI', function ($resource) {
    return $resource("/api/bedrooms");
});


//factory for filter by bedrooms
module.factory('filterBedroomsAPI', function ($resource) {
    return $resource("/api/bedrooms/:bedroom");
});

module.factory('wishlistAPI', function ($resource) {
    return $resource("/api/renters/wishlist/:username");
});



////////////////////////////////////////////////////////////////////////////////
//////////////////end of Property factories/////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////////
//////////////////Services factories/////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////


////////////////////

////////////////////////////////////////////////////////////////////////////////
//////////////////end of Services factories/////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////





//Service controller
module.controller('RegisterServiceController', function (registerServiceAPI, servicesLoginAPI, $window, $sessionStorage, $http) {

//This alert is to check if the controller is being used.
    //alert("in controller");






    //function for registering a renter
    this.registerService = function (service) {
        registerServiceAPI.save(null, service,
                // success callback
                        function () {
                            $window.location = 'loginS.html';
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
                servicesLoginAPI.get({'username': username},
                        // success callback
                                function (services) {
                                    // also store the retrieved customer
                                    $sessionStorage.services = services;
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












//Properties controller
        module.controller('PropertiesController', function (propertiesAPI, bedroomsAPI, filterBedroomsAPI, $window, $sessionStorage) {

//This alert is to check if the controller is being used.
            //alert("in controller");




            //load properties
            this.properties = propertiesAPI.query();

            //load the bedrooms
            this.bedrooms = bedroomsAPI.query();

            this.getAllProperties = function () {
                this.properties = propertiesAPI.query();
            };


            this.selectBedroom = function (selectedBedroom) {
                this.properties = filterBedroomsAPI.query({"bedroom": selectedBedroom});
            };


            this.addProperty = function (property) {
                property.landlordId = $sessionStorage.landlord.landlordId;
                propertiesAPI.save(null, property,
                        // success callback
                                function () {
                                    $window.location = 'index.html';
                                },
                                // error callback
                                        function (error) {
                                            console.log(error);
                                        }
                                );
                            };






                });












//Register Renter controller
        module.controller('RegisterRenterController', function (registerRenterAPI, wishlistAPI, renterLoginAPI, $window, $sessionStorage, $http) {

//This alert is to check if the controller is being used.
            //alert("in controller");

            //get a renters wishlist
            this.wishlist = wishlistAPI.query({"username": $sessionStorage.renter.username})


            //message for users
            this.loginMessage = "Please login to continue.";
            // alias 'this' so that we can access it inside callback functions
            let ctrl = this;


            //This function is called from the menu.html 
            this.checkSignIn = function () {
                // has the customer been added to the session?
                if ($sessionStorage.renter) {
                    this.signedIn = true;
                    this.welcome = "Welcome " + $sessionStorage.renter.username;
                } else {
                    this.signedIn = false;
                }
            };



            //signout function
            this.signOut = function () {
                $sessionStorage.$reset();
                $window.location = '.';
            };






            //function for registering a renter
            this.registerRenter = function (renter) {
                registerRenterAPI.save(null, renter,
                        // success callback
                                function () {
                                    $window.location = 'loginR.html';
                                },
                                // error callback
                                        function (error) {
                                            console.log(error);
                                        }
                                );
                            };








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





                    //This function is called from the menu.html 
                    this.checkSignIn = function () {
                        // has the customer been added to the session?
                        if ($sessionStorage.landlord) {
                            this.signedIn = true;
                            this.welcome = "Welcome " + $sessionStorage.landlord.userName;
                        } else {
                            this.signedIn = false;
                        }
                    };



                    //signout function
                    this.signOut = function () {
                        $sessionStorage.$reset();
                        $window.location = '.';
                    };








                    //function for registering a landlord
                    this.registerLandlord = function (landlord) {
                        registerLandlordAPI.save(null, landlord,
                                // success callback
                                        function () {
                                            $window.location = 'loginL.html';
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