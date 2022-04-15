package com.example.parkprjct.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")//db table명 "user"로 하니 오류뜸
public class Users implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_idx", nullable = false)
    private Long uIdx;

    @Column(name = "g_id", nullable = false)
    private String gId;

    @Column(name = "g_img")
    private String gImg;

    @Column(name = "u_nickname", nullable = false)
    private String uNickname;

    @Column(name = "u_date")
    @CreationTimestamp
    private Timestamp uDate;

    @Column(name = "u_isdel", nullable = false, columnDefinition = "boolean default false")
    private boolean uIsdel;

    @JsonIgnore
    @OneToMany(mappedBy = "uIdx")//mappedBy 연관관계 주인이 아님, 실제 db컬럼은 추가가 안됨
    //uIdx로 조인문을 작성해 값을 얻기위해 필요
    private List<Review> reviews;

    @Builder
    public Users(String gId, String gImg, String uNickname) {
        this.gId = gId;
        this.gImg = gImg;
        this.uNickname = uNickname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }
}