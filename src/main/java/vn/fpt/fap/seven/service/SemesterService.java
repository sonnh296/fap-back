package vn.fpt.fap.seven.service;

import vn.fpt.fap.seven.dto.semester.SemesterResponseView;

import java.util.List;

public interface SemesterService {

    List<SemesterResponseView> findAllSemester();
}
