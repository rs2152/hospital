package com.angry.hospital.clinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;


@Table(name = "users")
@Entity
@Data
@RequiredArgsConstructor
@SuperBuilder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = true)
public class Users extends BaseEntity {

    @Column(name = "phone")
    private String phone;

    @Column(name = "name")
    private String name;

    @Builder.Default
    @Column(name = "israting_active")
    private boolean isRatingActive = true;

    @Builder.Default
    @Column(name = "verified")
    private boolean verified = false;

    @Builder.Default
    @Column(name = "registered")
    private boolean registered = false;

    @Column(name = "access_token")
    private String accessToken;

    @JsonIgnore
    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "country_code")
    private String country_code;

    @Column(name = "promotion_code")
    private String promotionCode;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @Builder.Default
    @Column(name = "count")
    private int count = 0;

}
