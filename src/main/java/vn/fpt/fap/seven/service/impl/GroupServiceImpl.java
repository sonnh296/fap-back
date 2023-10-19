package vn.fpt.fap.seven.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.fpt.fap.seven.dto.group.GroupResponse;
import vn.fpt.fap.seven.entity.Group;
import vn.fpt.fap.seven.repository.GroupRepository;
import vn.fpt.fap.seven.service.GroupService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<GroupResponse> findListGroupByStudentId(int studentId) {
        List<Group> group = groupRepository.findListGroupByStudentId(studentId);
        return group.stream()
                .map(groupMap -> modelMapper.map(groupMap, GroupResponse.class))
                .toList();
    }

//    @Override
//    public GroupResponse findGroupByStudentIdAndSemIdAndSId(int studentId, int semId, int sId) {
//        Group group = groupRepository.findGroupByStudentIdAndSemIdAndSId(studentId, semId, sId);
//        return modelMapper.map(group, GroupResponse.class);
//    }
}
