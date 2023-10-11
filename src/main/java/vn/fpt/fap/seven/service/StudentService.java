package vn.fpt.fap.seven.service;

import vn.fpt.fap.seven.entity.Student;

public interface StudentService {
    Iterable<Student> findAllStudents();
}
