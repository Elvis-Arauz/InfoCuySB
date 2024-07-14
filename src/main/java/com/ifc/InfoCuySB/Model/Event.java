package com.ifc.InfoCuySB.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    @ManyToOne
    @JoinColumn(name = "event_type_id", nullable = false)
    private EventType eventType;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDateTime starDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    private String openingHours;
    private String phoneNumber;
    private String email;
    private String websiteUrl;

    @Column(insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean isDeleted;
}
