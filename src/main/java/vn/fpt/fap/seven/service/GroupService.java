package vn.fpt.fap.seven.service;

import vn.fpt.fap.seven.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> findByTeacherId(int id);
}
