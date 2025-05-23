package pl.kurs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "opinions", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "course_id"})
})
@NoArgsConstructor
@Getter
@Setter
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "opinion_date", nullable = false)
    private LocalDateTime opinionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    public Opinion(User user, String content, Integer rating) {
        this.opinionDate = LocalDateTime.now();
        this.user = user;
        this.content = content;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Opinion{" +
               "opinionDate=" + opinionDate +
               ", user=" + user.getFirstName() +
               ", course=" + course.getName() +
               ", content='" + content + '\'' +
               ", rating=" + rating +
               '}';
    }
}
