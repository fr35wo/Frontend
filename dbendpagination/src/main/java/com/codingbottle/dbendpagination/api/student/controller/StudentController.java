package com.codingbottle.dbendpagination.api.student.controller;

import com.codingbottle.dbendpagination.api.common.RspTemplate;
import com.codingbottle.dbendpagination.api.student.dto.StudentListRspDto;
import com.codingbottle.dbendpagination.domain.student.Student;
import com.codingbottle.dbendpagination.domain.student.StudentService;
import com.codingbottle.dbendpagination.global.util.PageableUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StudentController {
    private final StudentService studentService;

    /**
     * 4.
     *   어떻게 하냐? Spring Data JPA에서 자동화해줌. pageable
     *
     *   pageable을 Spring Data Jpa Repository method의 파라미터로 전달하는 것만으로 페이지네이션 쿼리가 가능
     *   pageable을 전달한 메서드의 반환값은 Page or Slice임
     *   Page란? 침하하. 전체 용량을 알아야 하고, count query가 필요함
     *   Slice란? 당근마켓. 전체 용량을 알 필요 없음. 현재 페이지가 끝인지 아닌지만 알면 됨. count query 필요없음
     *   불필요한 count query가 날라가지 않게끔, slice로 가능하면 Slice를 쓰는게 좋음.
     *
     *   그래서 Page extends Slice
     *   extends 이해하기 - 확장(extend)이라고 이해하자.. 딸 extends 아빠 하면 군대가야함
     *
     *   페이지네이션 예시(Slice랑 Page 둘다)를 보고,
     *   메인쿼리 카운트쿼리 날아가는거 보기.
     */
    // select ... from ... offset 10 limit 10
    // 100개 있을 때 10~19번째 데이터를 가져옴.
    // 이 작업을 간단하게 처리할 수 있게 도와주는 것이 Spring Data JPA에서 제공하는 Pageable 객체.

    // student 객체의 목록을 반환할 것.
    // 데이터를 어디서부터 몇 개 가져올건지를 클라이언트 개발자. 가 지정하게 할 것.
    // 1. 한 페이지의 사이즈 10개 <- 이건 서버에서 정합시다.
    // 2. 몇 페이지인데? 2 페이지 <- 이것만 클라이언트에서 지정하게.
    @GetMapping("/students")
    public RspTemplate<StudentListRspDto> handleGetAllStudents(
            @RequestParam(defaultValue = "1") int page
    ) {
        // 내가 반환하고 싶은 것: 학생Id, 이름 - StudentListRspDto

        // Pageable 객체의 구현체 PageRequest 가 필요하다
        final int DEFAULT_PAGE_SIZE = 10;
        Pageable pageable = PageableUtil.of(page, DEFAULT_PAGE_SIZE);

        // Student List를 Service에서 가져온다.
        Page<Student> studentPage = studentService.findAll(pageable);
        // StudentListRspDto.from(students)를 통해 Dto의 리스트로 변환해서 반환한다.
        StudentListRspDto studentListRspDto = StudentListRspDto.from(studentPage);

        return new RspTemplate<>(HttpStatus.OK
                , page + "번 페이지 조회 완료"
                , studentListRspDto
        );
    }

//    @GetMapping("/students-slice")
//    public RspTemplate<StudentListRspDto> handleGetAllStudentsS(
//            @RequestParam(defaultValue = "1") int page
//    ) {
//        // 내가 반환하고 싶은 것: 학생Id, 이름 - StudentListRspDto
//
//        // Pageable 객체의 구현체 PageRequest 가 필요하다
//        final int DEFAULT_PAGE_SIZE = 10;
//        Pageable pageable = PageableUtil.of(page, DEFAULT_PAGE_SIZE);
//
//        // Student List를 Service에서 가져온다.
//        Slice<Student> studentPage = studentService.findAllSlice(pageable);
//        // StudentListRspDto.from(students)를 통해 Dto의 리스트로 변환해서 반환한다.
//        StudentListRspDto studentListRspDto = StudentListRspDto.from(studentPage);
//
//        return new RspTemplate<>(HttpStatus.OK
//                , page + "번 페이지 조회 완료"
//                , studentListRspDto
//        );
//    }
}
