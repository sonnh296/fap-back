package vn.fpt.fap.seven.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.fpt.fap.seven.entity.Session;
import vn.fpt.fap.seven.repository.SessionRepository;
import vn.fpt.fap.seven.service.SessionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    @Override
    public List<Session> findSessionsByGroup(int id) {
        return sessionRepository.getSessionsByGroup_Gid(id);
    }
}
