package vn.fpt.fap.seven.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.fpt.fap.seven.entity.Group;
import vn.fpt.fap.seven.repository.GroupRepository;
import vn.fpt.fap.seven.service.GroupService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public List<Group> findByTeacherId(int id) {
        return groupRepository.findGroupsByTeacher_Id(id);
    }
}
