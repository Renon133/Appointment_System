package peoplestrong.team7.appointmentApp.Models;

public class PasswordObject {
    private String oldPassword;
    private String newPassword;
    private String emailID;

    public PasswordObject(String oldPassword, String newPassword, String emailID) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.emailID = emailID;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }




}
