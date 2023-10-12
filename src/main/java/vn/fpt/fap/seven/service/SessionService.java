package vn.fpt.fap.seven.service;

import vn.fpt.fap.seven.dto.session.SessionResponse;
import vn.fpt.fap.seven.entity.Session;

import java.util.List;

public interface SessionService {
    List<Session> findListSessionByTeacherIdAndTimeSlotId(int teacherId, int timeId);

    List<SessionResponse> findSessionsByTeacherId(int teacherId);
}
