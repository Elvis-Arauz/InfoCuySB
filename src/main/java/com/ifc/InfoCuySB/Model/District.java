package com.ifc.InfoCuySB.Model;

import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "districts")
public class District {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    private Long districtId;
    
    @Column(name = "district_name", nullable = false, length = 100)
    private String districtName;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
