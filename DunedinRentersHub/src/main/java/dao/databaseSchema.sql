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
    renterPassword varchar(50) not null,
    username varchar (50) null unique,
    dateOfBirth Date not null,
    renterPhone varchar(50) not null,
    renterEmail varchar(50) not null,
    references varchar(80) not null,
    constraint Renter_PK primary key (renterId)
);

create table Landlord (
    landlordId int auto_increment (1000),
    landlordPassword varchar(50) not null,
    userName varchar (50) not null unique,
    landlordPhone varchar(50) not null,
    landlordEmail varchar (80) not null,
    constraint Landlord_PK primary key (landlordId)
);

create table Services (
    serviceId int auto_increment (1000),
    serviceType varchar(50) not null,
    servicePassword varchar(50) not null,
    username varchar (50)not null unique,
    servicePhone varchar (50)not null,
    serviceEmail varchar(80) not null,
    constraint Services_PK primary key (serviceId)
);

create table Property (
    propertyId int auto_increment (1000),
    landlordId int,
    bedrooms varchar (50)not null,
    address varchar(80) not null,
    status varchar (50)not null,
    constraint Property_PK primary key (propertyId),
    constraint Property_Landlord foreign key (landlordId) references Landlord
);

create table Wishlist (
    renterId int,
    propertyId int,
    constraint Wishlist_PK primary key (renterId, propertyId),
    constraint Wishlist_Renter foreign key (renterId) references Renter,
    constraint Wishlist_Property foreign key (propertyId) references Property
);

create table Booking (
    bookingId int auto_increment (1000),
    date DATE not null,
    landlordId int,
    propertyId int,
    renterId int,
    constraint Booking_PK primary key (bookingId),
    constraint Booking_Landlord foreign key (landlordId) references Landlord,
    constraint Booking_Property foreign key (propertyId) references Property,
    constraint Booking_Renter foreign key (renterId) references Renter
);

/* drop table statements 
drop table booking;
drop table wishlist;
drop table property;
drop table landlord;
drop table services;
drop table renter;
*/



    