package com.restapi.request;

import com.restapi.model.AppUser;
import com.restapi.model.BookingStatus;
import com.restapi.model.Tour;
import com.restapi.model.UserDetails;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HistoryRequest {

    private Long user_id;
    private Long tour_id;

}
