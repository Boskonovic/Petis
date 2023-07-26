package org.rami.petis.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.rami.petis.base.ReviewGrade;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "ps_review")
public class Review {
    @Id
    @SequenceGenerator(
            name = "seq_review_id",
            sequenceName = "seq_review_id",
            allocationSize = 1

    )
    @GeneratedValue(
            generator = "seq_review_id",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "review_id")
    private Long id;
    @Size(max = 500)
    private String details;
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private ReviewGrade reviewGrade;
    @ManyToOne
    @JoinColumn(name = "response_id",nullable = false)
    private Response response;
    @ManyToOne
    @JoinColumn(name = "response_id",nullable = false)
    private Request request;

    public Review() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) && Objects.equals(details, review.details) && reviewGrade == review.reviewGrade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, details, reviewGrade);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ReviewGrade getReviewGrade() {
        return reviewGrade;
    }

    public void setReviewGrade(ReviewGrade reviewGrade) {
        this.reviewGrade = reviewGrade;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
