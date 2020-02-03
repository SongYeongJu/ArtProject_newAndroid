package com.example.newartproject.Data;

import java.io.Serializable;
import java.net.URL;

public class User implements Serializable {
    private String email;
    private String nickname;
    private URL profilePotoUrl;

    public User(){}
    public User(String _email, String _nickname, URL url) {
        email=_email;
        nickname=_nickname;
        profilePotoUrl=url;
    }

    public void setEmail(String email) { this.email=email; }
    public void setNickname(String nickname) { this.nickname=nickname; }
    public void setProfilePotoUrl(URL profilePotoUrl) { this.profilePotoUrl=profilePotoUrl; }

    public String getEmail() { return email; }
    public String getNickname() { return nickname; }
    public URL getProfilePotoUrl() { return profilePotoUrl; }
}
