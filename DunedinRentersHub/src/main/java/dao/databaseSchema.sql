/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  maxer
 * Created: 24/04/2021
 */

create table Renter (
    renterId int auto_increment (1000),
    renterPassword varchar not null,
    username varchar not null unique,
    dateOfBirth varchar not null,
    renterPhone varchar not null,
    renterEmail varchar not null,
    references varchar not null,
    constraint Renter_PK primary key (renterId)
);

create table Landlord (
    landlordId int auto_increment (1000),
    landlordPassword varchar not null,
    userName varchar not null unique,
    landlordPhone varchar not null,
    landlordEmail varchar not null,
    constraint Landlord_PK primary key (landlordId)
);

create table Services (
    serviceId int auto_increment (1000),
    serviceType varchar not null,
    servicePassword varchar not null,
    username varchar not null unique,
    servicePhone varchar not null,
    serviceEmail varchar not null,
    constraint Services_PK primary key (serviceId)
);


    