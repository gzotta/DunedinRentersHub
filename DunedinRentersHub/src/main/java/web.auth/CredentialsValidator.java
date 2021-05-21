/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.auth;

/**
 * @author Mark George <mark.george@otago.ac.nz>
 *
 * License: FreeBSD (https://opensource.org/licenses/BSD-2-Clause)
 */
public interface CredentialsValidator {
 
	Boolean validateCredentials(String username, String password);
 
}