package vn.fpt.fap.seven.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.fpt.fap.seven.dto.semester.SemesterResponseView;
import vn.fpt.fap.seven.entity.Semester;
import vn.fpt.fap.seven.repository.SemesterRespository;
import vn.fpt.fap.seven.service.SemesterService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SemesterServiceImpl implements SemesterService {
    private final SemesterRespository semesterRespository;
    private final ModelMapper modelMapper;
    @Override
    public List<SemesterResponseView> findAllSemester() {
        List<Semester> semesters = semesterRespository.findAll();
        return semesters.stream()
                .map(semesterMap -> modelMapper.map(semesterMap, SemesterResponseView.class) )
                .toList();
    }
}