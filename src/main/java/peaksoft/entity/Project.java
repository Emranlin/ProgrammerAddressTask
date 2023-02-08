package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "project_name")
    private String projectName;
    private String description;
    @Column(name="date_of_start")
    private LocalDate dateOfStart;
    @Column(name = "date_of_finish")
    private LocalDate dateOfFinish;
    private int price;
    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
   @JoinTable(name = "project_id programmer_id")
    private List<Programmer> programmers;

    public Project(String projectName, String description, LocalDate dateOfStart, LocalDate dateOfFinish, int price) {
        this.projectName = projectName;
        this.description = description;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
        this.price = price;
    }

    public Project(String projectName, String description, LocalDate dateOfStart, LocalDate dateOfFinish, int price, List<Programmer> programmers) {
        this.projectName = projectName;
        this.description = description;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
        this.price = price;
        this.programmers = programmers;
    }
}
