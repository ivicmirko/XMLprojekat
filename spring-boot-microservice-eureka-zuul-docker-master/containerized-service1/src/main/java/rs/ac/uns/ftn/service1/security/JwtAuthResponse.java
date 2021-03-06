package rs.ac.uns.ftn.service1.security;

import rs.ac.uns.ftn.service1.dto.ProfileDTO;

public class JwtAuthResponse {

	private ProfileDTO profile;
    private String accessToken;

    public JwtAuthResponse(ProfileDTO profile, String accessToken) {
    	this.profile = profile;
        this.accessToken = accessToken;
    }
    
    public ProfileDTO getProfile() {
		return profile;
	}
    
    public void setProfile(ProfileDTO profile) {
		this.profile = profile;
	}

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
