package org.rami.petis.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.rami.petis.base.ResponseStatus;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "ps_response")
public class Response {
    @Id
    @SequenceGenerator(
            name = "seq_response_id",
            sequenceName = "seq_response_id",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "seq_response_id",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "response_id")
    private Long id;
    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "response_status")
    private ResponseStatus responseStatus;
    @Size(max = 500)
    private String details;
    @OneToMany
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    public Response() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Response)) return false;
        Response response = (Response) o;
        return Objects.equals(id, response.id) && responseStatus == response.responseStatus && Objects.equals(details, response.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, responseStatus, details);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
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

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
