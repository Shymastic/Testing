/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoalnd.Registration_CartObj;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class RegistrationInsertError implements Serializable{
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String confirmNotMatch;
    private String lastNameLengthErr;
    private String usernameIsExisted;

    public RegistrationInsertError() {
    }

    
    public RegistrationInsertError(String usernameLengthErr, String passwordLengthErr, String confirmNotMatch, String lastNameLengthErr, String usernameIsExisted) {
        this.usernameLengthErr = usernameLengthErr;
        this.passwordLengthErr = passwordLengthErr;
        this.confirmNotMatch = confirmNotMatch;
        this.lastNameLengthErr = lastNameLengthErr;
        this.usernameIsExisted = usernameIsExisted;
    }

    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    public String getLastNameLengthErr() {
        return lastNameLengthErr;
    }

    public void setLastNameLengthErr(String lastNameLengthErr) {
        this.lastNameLengthErr = lastNameLengthErr;
    }

    public String getUsernameIsExisted() {
        return usernameIsExisted;
    }

    public void setUsernameIsExisted(String usernameIsExisted) {
        this.usernameIsExisted = usernameIsExisted;
    }


    
    
}
