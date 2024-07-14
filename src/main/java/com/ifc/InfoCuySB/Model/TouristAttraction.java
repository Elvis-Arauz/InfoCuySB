package com.ifc.InfoCuySB.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "touristattractions")
public class TouristAttraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long touristAttractionId;

    @Column(name = "district_id", nullable = false)
    private Long districtId;

    @Column(name = "tourist_attraction_type_id", nullable = false)
    private Long touristAttractionTypeId;

    @Column(name = "touristAttractionName", nullable = false, length = 100)
    private String touristAttractionName;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "photo", nullable = false, length = 255)
    private String photo;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "openingHours", columnDefinition = "json", nullable = false)
    private String openingHours;

    @Column(name = "phoneNumber", length = 12)
    private String phoneNumber;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "websiteUrl", length = 255)
    private String websiteUrl;

    @Column(name = "isDeleted", nullable = false)
    private boolean isDeleted = false;

    @Column(name = "createdAt", nullable = true, updatable = false, insertable = false)
    private Timestamp createdAt;

    @Column(name = "updatedAt", nullable = true, insertable = false)
    private Timestamp updatedAt;
}
