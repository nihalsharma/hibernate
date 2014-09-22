package com.tm.mid.client.pojo;

import com.tm.mid.client.json.CustomJsonDateDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.joda.time.DateTime;


/**
 * Created by BigP on 9/16/14.
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
    private DateTime resetPasswordSentAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private DateTime rememberCreatedAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private DateTime currentSignInAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private DateTime lastSignInAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private DateTime confirmedAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private DateTime confirmationSentAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private DateTime createdAt;

    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private DateTime updatedAt;

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

    public DateTime getResetPasswordSentAt() {
        return resetPasswordSentAt;
    }

    public void setResetPasswordSentAt(DateTime resetPasswordSentAt) {
        this.resetPasswordSentAt = resetPasswordSentAt;
    }

    public DateTime getRememberCreatedAt() {
        return rememberCreatedAt;
    }

    public void setRememberCreatedAt(DateTime rememberCreatedAt) {
        this.rememberCreatedAt = rememberCreatedAt;
    }

    public DateTime getCurrentSignInAt() {
        return currentSignInAt;
    }

    public void setCurrentSignInAt(DateTime currentSignInAt) {
        this.currentSignInAt = currentSignInAt;
    }

    public DateTime getLastSignInAt() {
        return lastSignInAt;
    }

    public void setLastSignInAt(DateTime lastSignInAt) {
        this.lastSignInAt = lastSignInAt;
    }

    public DateTime getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(DateTime confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public DateTime getConfirmationSentAt() {
        return confirmationSentAt;
    }

    public void setConfirmationSentAt(DateTime confirmationSentAt) {
        this.confirmationSentAt = confirmationSentAt;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
