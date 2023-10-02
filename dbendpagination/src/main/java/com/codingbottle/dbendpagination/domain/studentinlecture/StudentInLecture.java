package com.codingbottle.dbendpagination.domain.studentinlecture;

import com.codingbottle.dbendpagination.domain.lecture.Lecture;
import com.codingbottle.dbendpagination.domain.student.Student;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class StudentInLecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 어떤 학생이 어떤 강의를 듣는지에 대한 정보.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // 연관 객체가 필요할 때만 EAGER로 가져오게 하는 방법
    // FETCH JOIN

    // EAGER로 깔아둔 다음에, 필요할 때만 LAZY

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

    private Integer penalty;



    @Builder    //빌더 패턴으로만 생성자 사용해라.
    private StudentInLecture(Student student, Lecture lecture) {
        this.student = student;
        this.lecture = lecture;
        this.penalty = Penalty.NONE.getValue();
    }

    //penalty가 null로 나와서 추가한 코드(db에는 0으로 나왔었음)
    public void setPenalty(Penalty penalty) {
        if (penalty != null) {
            this.penalty = penalty.getValue();
        } else {
            this.penalty = Penalty.NONE.getValue();
        }
    }

}














