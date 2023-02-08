package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Countries;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Enumerated(EnumType.STRING)
    private Countries countries;
    private String description;
    @OneToMany(mappedBy = "country",cascade = {CascadeType.DETACH,
    CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Address> addresses;

    public Country(Countries countries, String description) {
        this.countries = countries;
        this.description = description;
    }
}
