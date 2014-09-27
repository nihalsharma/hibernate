package com.tm.mid.client.pojo;

import com.tm.mid.client.json.CustomJsonDateDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.Date;


/**
 * Created by Nihal on 9/16/14.
 */
public class User {

    private Integer id;
    private String name;
    private String emailId;
    private String password;
    private String website;
    private String phoneNumber;
    private String companyName;
    private String coupon;
    private String resetPasswordToken;
    private String unconfirmedEmail;
    private String authenticationToken;
    private String currentSignInIp;
    private String lastSignInIp;
    private String confirmationToken;
    private boolean approved;
    private boolean superAdmin;
    private boolean termsAccept;
    private Integer signInCount;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date resetPasswordSentAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date rememberCreatedAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date currentSignInAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date lastSignInAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date confirmedAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date confirmationSentAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date createdAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public String getUnconfirmedEmail() {
        return unconfirmedEmail;
    }

    public void setUnconfirmedEmail(String unconfirmedEmail) {
        this.unconfirmedEmail = unconfirmedEmail;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public String getCurrentSignInIp() {
        return currentSignInIp;
    }

    public void setCurrentSignInIp(String currentSignInIp) {
        this.currentSignInIp = currentSignInIp;
    }

    public String getLastSignInIp() {
        return lastSignInIp;
    }

    public void setLastSignInIp(String lastSignInIp) {
        this.lastSignInIp = lastSignInIp;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    public boolean isTermsAccept() {
        return termsAccept;
    }

    public void setTermsAccept(boolean termsAccept) {
        this.termsAccept = termsAccept;
    }

    public Integer getSignInCount() {
        return signInCount;
    }

    public void setSignInCount(Integer signInCount) {
        this.signInCount = signInCount;
    }

    public Date getResetPasswordSentAt() {
        return resetPasswordSentAt;
    }

    public void setResetPasswordSentAt(Date resetPasswordSentAt) {
        this.resetPasswordSentAt = resetPasswordSentAt;
    }

    public Date getRememberCreatedAt() {
        return rememberCreatedAt;
    }

    public void setRememberCreatedAt(Date rememberCreatedAt) {
        this.rememberCreatedAt = rememberCreatedAt;
    }

    public Date getCurrentSignInAt() {
        return currentSignInAt;
    }

    public void setCurrentSignInAt(Date currentSignInAt) {
        this.currentSignInAt = currentSignInAt;
    }

    public Date getLastSignInAt() {
        return lastSignInAt;
    }

    public void setLastSignInAt(Date lastSignInAt) {
        this.lastSignInAt = lastSignInAt;
    }

    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Date confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public Date getConfirmationSentAt() {
        return confirmationSentAt;
    }

    public void setConfirmationSentAt(Date confirmationSentAt) {
        this.confirmationSentAt = confirmationSentAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
