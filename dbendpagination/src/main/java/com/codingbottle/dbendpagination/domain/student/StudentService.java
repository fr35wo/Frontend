package com.codingbottle.dbendpagination.domain.student;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public Student getById(Long studentId) {
        return studentRepository.findById(studentId)
                //최신 문법
                .orElseThrow(() -> new IllegalArgumentException("해당 학생이 존재하지 않습니다."));
    }

    public Page<Student> findAll(Pageable pageable) {
        // List<Student>
        // Page<Student>
        return studentRepository.findAll(pageable);
    }

    public Slice<Student> findAllSlice(Pageable pageable) {
        // List<Student>
        // Page<Student>
        return studentRepository.findAll(pageable);
    }
}
