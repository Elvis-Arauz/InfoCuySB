package com.ifc.InfoCuySB.Model;

import java.sql.Timestamp;
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
    @Column(name = "districtId")
    private Long districtId;
    
    @Column(name = "districtName", nullable = false, length = 100)
    private String districtName;
    
    @Column(name = "createdAt")
    private Timestamp createdAt;
    
    @Column(name = "updatedAt")
    private Timestamp updatedAt;
}