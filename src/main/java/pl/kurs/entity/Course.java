package pl.kurs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private Set<CourseModule> courseModules = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "course")
    private Set<Opinion> opinions = new HashSet<>();

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
