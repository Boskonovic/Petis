package org.rami.petis.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.rami.petis.base.RequestStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ps_request")
public class Request {
    @Id
    @SequenceGenerator(
            name = "seq_request_id",
            sequenceName = "seq_request_id",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "seq_request_id",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "request_id")
    private Long id;
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "start_at",nullable = false)
    private LocalDate startAt;
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "start_at",nullable = false)
    private LocalDate endAt;
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
    @Size(max = 500)
    private String details;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    @OneToMany(mappedBy = "request")
    private Set<Pet> pets = new HashSet<>();
    @OneToMany(mappedBy = "request", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Response> responses = new HashSet<>();

    public Request() {
        super();
    }

    public void addResponse(Response response){
        responses.add(response);
        //response.setRequest(this);
    }

    public void removeResponse(Response response){
        responses.remove(response);
        //response.setRequest(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return Objects.equals(id, request.id) && Objects.equals(startAt, request.startAt) && Objects.equals(endAt, request.endAt) && requestStatus == request.requestStatus && Objects.equals(details, request.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startAt, endAt, requestStatus, details);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDate startAt) {
        this.startAt = startAt;
    }

    public LocalDate getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDate endAt) {
        this.endAt = endAt;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<Response> getResponses() {
        return responses;
    }

    public void setResponses(Set<Response> responses) {
        this.responses = responses;
    }
}
