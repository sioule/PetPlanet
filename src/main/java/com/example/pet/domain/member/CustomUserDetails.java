package com.example.pet.domain.member;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class CustomUserDetails implements UserDetails, OAuth2User {
    private Member member;
    private Map<String, Object> attributes;

    public CustomUserDetails(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getRole().toString();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return member.getKakaoEmail();
    }

    @Override
    public String getUsername() {
        return member.getKakaoNickname();
    }

    // 계정 만료됐는지 확인 -> true 면 아니요.
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    // 계정 잠겼는지 확인 -> true 면 아니요.
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    // 계정 만료됐는지 확인 -> true 면 아니요.
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    // 계정 만료됐는지 확인 -> true 면 아니요.
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        return null;
    }
}
