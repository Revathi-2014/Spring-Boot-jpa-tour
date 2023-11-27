package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tourName;

    private String tourDescription;

    @Lob
    @Column( columnDefinition="BLOB")
    private byte[] tourPhoto;

    private String destination;

    private Integer totalSeats;

    private Integer balanceSeats;


    private Long price;

    private LocalDate departureDate;

    private Integer days;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Itinerary> itineraries = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private TourCategory category;

    @JsonIgnore
    @OneToMany(mappedBy = "tour")
    private List<Booking> bookingList=new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
