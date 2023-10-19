package vn.fpt.fap.seven.service;

import vn.fpt.fap.seven.entity.Session;

import java.util.List;

public interface SessionService {
    List<Session> findSessionsByGroup(int id);
}
