package com.iods.iods_backend.upload.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UploadMapper {
    void savePic(Map saveMap);

    void savePicShzt(Map map);

    void picSc(Map map);

    void picSh(Map map);

    List<Map> picScList(Map param);

    List<Map> picShList(Map param);

    void deletePicSc(String zj);

    void picSsjl(Map map);

    void deletePicSsjl(String userid);

    void picXzjl(Map map);

    List<Map> picSsList(Map param);

    int picSsjlCount(Map param);

    List<Map> zdcx(Map param);

    void savePicType(Map map);

    List<Map> picSsjlUser(Map map);

    List<Map> picSsrc();

    List<Map> wdsc(Map map);
}
