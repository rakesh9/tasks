package chas.twitter.clone.service;

import chas.twitter.clone.domain.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class TwitterCloneUserDetails implements UserDetails {
    private final User user;

    public TwitterCloneUserDetails(User user) {
        this.user = user;
    }

    public User getuser() {
        return user;
    }

    //fixed form
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_" + this.user.getRoleName().name());
    }

    //Password used for authentication
    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    //UserId used for authentication
    @Override
    public String getUsername() {
        return this.user.getUserId();
    }

    // Account expiration function
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // account lock function
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // password expiration function
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Account invalidation function
    @Override
    public boolean isEnabled() {
        return true;
    }
}
