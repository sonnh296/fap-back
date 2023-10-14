package vn.fpt.fap.seven.service;

import vn.fpt.fap.seven.dto.group.GroupResponse;

import java.util.List;

public interface GroupService {

    List<GroupResponse> findListGroupByStudentId(int studentId);

    /*GroupResponse findGroupByStudentIdAndSemIdAndSId(int studentId, int subId, int semId);*/
}
