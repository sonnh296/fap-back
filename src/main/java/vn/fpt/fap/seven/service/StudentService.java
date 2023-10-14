package vn.fpt.fap.seven.service;

import vn.fpt.fap.seven.dto.group.GroupResponse;

public interface StudentService {
    GroupResponse findGroupByStudentIdAndSemIdAndSId(int studentId, int semId, int sId);
}
