package com.white.mapper;

import com.white.entry.Speaker;
import com.white.entry.VideoQueryVo;
import org.apache.ibatis.annotations.*;
import org.springframework.ui.Model;

import java.util.List;

public interface SpeakerMapper {
    List<Speaker> selectAllSpeaker();

    int saveSpeaker(Speaker speaker);

    @Delete("delete from speaker where id = #{id}")
    int speakerDel(int id);

    @Select("select * from speaker where id = #{id}")
    @Results(id="SpeakerMap",
            value= {
                    @Result(id=true,column="id",property="id"),
                    @Result(column="speaker_name",property="speakerName"),
                    @Result(column="speaker_desc",property="speakerDesc"),
                    @Result(column="speaker_job",property="speakerJob"),
                    @Result(column="head_img_url",property="headImgUrl")
            })
    Speaker selectById(int id);

    @Update("update speaker set speaker_name = #{speakerName}, speaker_desc = #{speakerDesc}, speaker_job = #{speakerJob}, head_img_url = #{headImgUrl} where id = #{id}")
    int updateSpeaker(Speaker speaker);
}
