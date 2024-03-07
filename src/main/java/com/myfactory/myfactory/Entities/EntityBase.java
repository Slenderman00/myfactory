package com.myfactory.myfactory.Entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.myfactory.myfactory.Documentation.Documentation;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityBase {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Documentation(description = "The unique identifier for this entity.")
        public Long id;
        @CreationTimestamp
        public LocalDateTime created;
        @UpdateTimestamp
        public LocalDateTime updated;
}
