package pl.kurs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lessons")
@NoArgsConstructor
@Getter
@Setter
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lesson")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_module_id", nullable = false)
    private CourseModule courseModule;

    public Lesson(String name) {
        this.name = name;
    }

}
