package com.white.service;

import com.white.entry.Speaker;
import org.springframework.ui.Model;

import java.util.List;

public interface SpeakerService {

    List<Speaker> selectAllSpeaker();
    List<Speaker> selectAllSpeaker(int page, int pageSize);

    int saveSpeaker(Speaker speaker);

    int speakerDel(int id);

    Speaker selectById(int id);

    int updateSpeaker(Speaker speaker);
}
