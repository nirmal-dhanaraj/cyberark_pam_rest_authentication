
package com.pam.authentication.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AuthRequest { 

private String username;

private String password;

private String newpassword;

private String type;

private String additionalInfo;

private Boolean secureMode;

private String concurrentSession;


}

/*
 * @JsonProperty("username") public String getusername() { return username; }
 * 
 * @JsonProperty("username") public void setusername(String username) {
 * this.username = username; }
 * 
 * @JsonProperty("password") public String getpassword() { return password; }
 * 
 * @JsonProperty("password") public void setpassword(String password) {
 * this.password = password; }
 * 
 * @JsonProperty("Newpassword") public String getNewpassword() { return
 * newpassword; }
 * 
 * @JsonProperty("Newpassword") public void setNewpassword(String newpassword) {
 * this.newpassword = newpassword; }
 * 
 * @JsonProperty("Type") public String getType() { return type; }
 * 
 * @JsonProperty("Type") public void setType(String type) { this.type = type; }
 * 
 * @JsonProperty("AdditionalInfo") public String getAdditionalInfo() { return
 * additionalInfo; }
 * 
 * @JsonProperty("AdditionalInfo") public void setAdditionalInfo(String
 * additionalInfo) { this.additionalInfo = additionalInfo; }
 * 
 * @JsonProperty("SecureMode") public Boolean getSecureMode() { return
 * secureMode; }
 * 
 * @JsonProperty("SecureMode") public void setSecureMode(Boolean secureMode) {
 * this.secureMode = secureMode; }
 * 
 * @JsonAnyGetter public Map<String, Object> getAdditionalProperties() { return
 * this.additionalProperties; }
 * 
 * @JsonAnySetter public void setAdditionalProperty(String name, Object value) {
 * this.additionalProperties.put(name, value); }
 * 
 * @JsonProperty("concurrentSession") public String getconcurrentSession() {
 * return concurrentSession; }
 * 
 * @JsonProperty("concurrentSession") public void setconcurrentSession(String
 * concurrentSession) { this.concurrentSession = concurrentSession; }
 */
