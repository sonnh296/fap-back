package vn.fpt.fap.seven.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.fpt.fap.seven.dto.session.SessionResponse;
import vn.fpt.fap.seven.entity.Session;
import vn.fpt.fap.seven.repository.SessionRepository;
import vn.fpt.fap.seven.service.SessionService;


import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Session> findListSessionByTeacherIdAndTimeSlotId(int teacherId, int timeId) {

        return sessionRepository.findListSessionByTeacherIdAndTimeSlotId(timeId, teacherId);
    }

    @Override
    public List<SessionResponse> findSessionsByTeacherId(int teacherId) {
        List<Session> sessions = sessionRepository.findSessionsByTeacherId(teacherId);
        return sessions.stream()
                .map(session -> modelMapper.map(sessions, SessionResponse.class))
                .toList();
    }
}
