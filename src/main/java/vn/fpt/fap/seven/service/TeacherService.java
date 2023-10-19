package vn.fpt.fap.seven.service;

import vn.fpt.fap.seven.entity.Teacher;

import java.util.Optional;

public interface TeacherService {
    Optional<Teacher> findById(int id);
    Optional<Teacher> findByCode(String code);
}
