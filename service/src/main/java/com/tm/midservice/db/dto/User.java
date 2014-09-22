package com.tm.midservice.db.dto;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Nihal on 9/10/14.
 */
@Entity
@Table(name="user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String emailId;

    @Column(name = "encrypted_password")
    private String password;

    @Column(name = "website")
    private String website;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "coupon")
    private String coupon;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @Column(name = "unconfirmed_email")
    private String unconfirmedEmail;

    @Column(name = "authentication_token")
    private String authenticationToken;

    @Column(name = "current_sign_in_ip")
    private String currentSignInIp;

    @Column(name = "last_sign_in_ip")
    private String lastSignInIp;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    @Column(name="approved")
    private boolean approved;

    @Column(name="superAdmin")
    private boolean superAdmin;

    @Column(name="terms_accept")
    private boolean termsAccept;

    @Column(name = "sign_in_count")
    private Integer signInCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reset_password_sent_at")
    private DateTime resetPasswordSentAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "remember_created_at")
    private DateTime rememberCreatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "current_sign_in_at")
    private DateTime currentSignInAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_sign_in_at")
    private DateTime lastSignInAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "confirmed_at")
    private DateTime confirmedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "confirmation_sent_at")
    private DateTime confirmationSentAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private DateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private DateTime updatedAt;

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

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}
