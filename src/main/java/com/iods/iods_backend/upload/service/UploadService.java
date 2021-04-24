package com.iods.iods_backend.upload.service;

import com.iods.iods_backend.upload.mapper.UploadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class  UploadService {

    @Autowired
    private UploadMapper uploadMapper;

    @Transactional(rollbackFor = Exception.class)
    public void savePic(Map saveMap) {
        uploadMapper.savePic(saveMap);
        String[] types = (saveMap.get("types")+"").split(",");
        String picZj = saveMap.get("zj")+"";
        String userid = saveMap.get("userid")+"";
        saveMap.put("piczj",picZj);
        saveMap.put("bz"," ");
        uploadMapper.savePicShzt(saveMap);
        for (int i = 0;i<types.length;i++){
            Map map = new HashMap();
            map.put("piczj",picZj);
            map.put("type",types[i]);
            uploadMapper.savePicType(map);
        }
    }

    public void picSc(Map map) {
        uploadMapper.picSc(map);
    }

    public void picSh(Map map) {
        uploadMapper.picSh(map);
    }

    public List<Map> picScList(Map param) {
        List<Map> data = uploadMapper.picScList(param);
        return data;
    }

    public List<Map> picShList(Map param) {
        List<Map> data = uploadMapper.picShList(param);
        return data;
    }

    public void deletePicSc(String zj) {
        uploadMapper.deletePicSc(zj);
    }

    public List<Map> picSsjlUser(Map map) {
        List<Map> data = uploadMapper.picSsjlUser(map);
        return data;
    }

    public void deletePicSsjl(String userid) {
        uploadMapper.deletePicSsjl(userid);
    }

    public void picXzjl(Map map) {
        uploadMapper.picXzjl(map);
    }

    public List<Map> picSsList(Map param) {
        String gjc = param.get("picmc")+"";
        if(!"".equals(gjc)&&!"null".equals(gjc)){
            uploadMapper.picSsjl(param);
        }
        List<Map> data = uploadMapper.picSsList(param);
        return data;
    }

    public int picSsjlCount(Map param) {
        int i = uploadMapper.picSsjlCount(param);
        return  i;
    }

    public List<Map> zdcx(Map param) {
        List<Map> data = uploadMapper.zdcx(param);
        return data;
    }

    public List<Map> picSsrc() {
        List<Map> data = uploadMapper.picSsrc();
        return data;
    }
}
