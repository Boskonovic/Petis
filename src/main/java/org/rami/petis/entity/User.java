package org.rami.petis.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.rami.petis.base.AbstractEntity;
import org.rami.petis.base.UserType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ps_user")
public class User extends AbstractEntity {
    @Id
    @SequenceGenerator(
            name = "seq_user_id",
            sequenceName = "seq_user_id",
            allocationSize = 1)
    @GeneratedValue(
            generator ="seq_user_id" ,
            strategy = GenerationType.SEQUENCE)
    @Column(updatable = false,name = "user_id")
    private Double id;

    @NotEmpty
    @Column(nullable = false,unique = true)
    private String username;
    @NotEmpty
    @Column(nullable = false)
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    @NotEmpty
    @Column(unique = true,nullable = false)
    private String email;
    private Double rating;
    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;
    @OneToMany(mappedBy = "owner",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Pet> pets = new HashSet<>();
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Request> requests = new HashSet<>();
    @OneToMany(mappedBy = "user",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Response> responses = new HashSet<>();

    public User() {
        super();
    }

    public User(String username, String password, String firstName, String lastName, String address, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }
    public void addPet(Pet pet){
        pets.add(pet);
        pet.setOwner(this);
    }
    public void removePet(Pet pet){
        pets.remove(pet);
        pet.setOwner(null);
    }
    public void addRequest(Request request){
        requests.add(request);
    }

    public void addResponse(Response response){
        responses.add(response);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

    public Set<Response> getResponses() {
        return responses;
    }

    public void setResponses(Set<Response> responses) {
        this.responses = responses;
    }
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
