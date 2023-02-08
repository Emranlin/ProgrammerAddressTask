package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Countries;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "addreses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "region_name")
    private String regionName;
    private String street;
    @Column(name = "home_number")
    private int homeNumber;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    private Country country;

    public Address(String regionName, String street, int homeNumber) {
        this.regionName = regionName;
        this.street = street;
        this.homeNumber = homeNumber;

    }
}
