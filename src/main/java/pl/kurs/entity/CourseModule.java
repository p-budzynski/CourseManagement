package pl.kurs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course_modules")
@NoArgsConstructor
@Getter
@Setter
public class CourseModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course_modules")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "courseModule", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private Set<Lesson> lessons = new HashSet<>();

    public CourseModule(String name) {
        this.name = name;
    }
}
