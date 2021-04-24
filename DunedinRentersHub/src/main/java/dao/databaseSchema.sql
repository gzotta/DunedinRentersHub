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

