package com.iods.iods_backend.upload.controller;

import com.iods.iods_backend.upload.entity.ReturnMessage;
import com.iods.iods_backend.upload.service.UploadService;
import com.iods.iods_backend.validate.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/bussiness")
public class UploadController {

    @Autowired
    private UploadService uploadService;


    /**
     * 图片上传
     * @param files     文件
     * @param userid    用户id
     * @param types     图片所属类型
     * @param sfgx      是否共享
     * @return
     */
    @PostMapping(value="/upload")
    public ReturnMessage handleFileupload(
            @RequestParam("attachments") MultipartFile[] files,
            @RequestParam("userid") String userid,
            @RequestParam("types") String types,
            @RequestParam("sfgx") String sfgx,
            @RequestParam("gjc") String gjc){
        try {
            String fileRootPath = "D:/iodsPic/";
            String filePath = "";
            // 多文件上传
            for (MultipartFile file : files){

                String uuid = UUID.randomUUID().toString();
                uuid = uuid.replace("-", "");
                // 上传简单文件名
                String originalFilename = file.getOriginalFilename();
                String filename = originalFilename.substring(0,originalFilename.lastIndexOf("."));
                String filetype = originalFilename.substring(originalFilename.lastIndexOf("."),originalFilename.length());
                // 存储路径
                filePath = new StringBuilder(fileRootPath)
                        .append(uuid)
                        .append(filetype)
                        .toString();
                // 保存文件
                file.transferTo(new File(filePath));
                File bfile = new File(filePath);
                FileInputStream inputFile = new FileInputStream(bfile);
                byte[] buffer = new byte[(int)bfile.length()];
                inputFile.read(buffer);
                inputFile.close();
                String ba64 = new BASE64Encoder().encode(buffer);
                Map saveMap = new HashMap<>();
                saveMap.put("zj",uuid);
                saveMap.put("picmc",filename);
                saveMap.put("userid",userid);
                saveMap.put("types",types);
                saveMap.put("sfgx",sfgx);
                saveMap.put("filetype",filetype);
                saveMap.put("file",ba64);
                saveMap.put("gjc",gjc);
                uploadService.savePic(saveMap);
            }
            return new ReturnMessage().success();
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
    /**
     * @param path     想要下载的文件的路径
     * @param response
     * @功能描述 下载文件:
     */
    @RequestMapping("/download")
    public void download(@RequestParam("path") String path,
                         @RequestParam("piczj") String piczj,
                         @RequestParam("userid") String userid,
                         HttpServletResponse response) {
        try {
            Map map = new HashMap();
            map.put("piczj",piczj);
            map.put("userid",userid);
            uploadService.picXzjl(map);
            // path是指想要下载的文件的路径
            File file = new File(path);
            // 获取文件名
            String filename = file.getName();
            // 获取文件后缀名
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();

            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载   inline表示在线打开   "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 图片收藏
     * @param map
     *      piczj图片主键
     *      userid 用户id
     * @return
     */
    @PostMapping(value="/picSc")
    public ReturnMessage picSc(@RequestBody Map map){
        try {
            uploadService.picSc(map);
            return new ReturnMessage().success();
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
    /**
     * 取消收藏
     * @param zj 主键
     * @return
     */
    @DeleteMapping(value="/deletePicSc/{zj}")
    public ReturnMessage deletePicSc(@PathVariable("zj") String zj){
        try {
            uploadService.deletePicSc(zj);
            return new ReturnMessage().success();
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }

    /**
     * 图片收藏列表
     *      userid  用户id
     *      page    页码
     *      rows    行数
     * @return
     */
    @GetMapping("/picScList")
    public ReturnMessage picScList(@RequestParam Map param){
        try {
            List<Map> data = uploadService.picScList(param);
            return new ReturnMessage().success(data);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
    /**
     * 图片审核
     * @param map
     *      shzt    审核状态
     *      bz      备注
     *      zj      主键
     * @return
     */
    @PostMapping(value="/picSh")
    public ReturnMessage picSh(@RequestBody Map map){
        try {
            uploadService.picSh(map);
            return new ReturnMessage().success();
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
    /**
     * 图片审核列表
     *      shzt    审核状态
     *      page    页码
     *      rows    行数
     * @return
     */
    @GetMapping("/picShList")
    public ReturnMessage picShList(@RequestParam Map param){
        try {
            List<Map> data = uploadService.picShList(param);
            return new ReturnMessage().success(data);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
    /**
     * 图片搜索
     *      type    类型
     *      picmc   图片名称
     *      userid  用户id
     *      page    页码
     *      rows    行数
     * @return
     */
    @GetMapping("/picSsList")
    public ReturnMessage picSsList(@RequestParam Map param){
        try {
            List<Map> data = uploadService.picSsList(param);
            return new ReturnMessage().success(data);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
    /**
     * 图片搜索记录
     *      userid  用户id
     * @return
     */
    @GetMapping("/picSsjl")
    public ReturnMessage picSsjlUser(@RequestParam Map param){
        try {
            List<Map> data = uploadService.picSsjlUser(param);
            return new ReturnMessage().success(data);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
    /**
     * 图片搜索热词
     * @return
     */
    @GetMapping("/picSsrc")
    public ReturnMessage picSsrc(){
        try {
            List<Map> data = uploadService.picSsrc();
            return new ReturnMessage().success(data);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
    /**
     * 删除图片搜索记录
     * @param userid
     * @return
     */
    @DeleteMapping("/deletePicSsjl/{userid}")
    public ReturnMessage deletePicSsjl(@PathVariable("userid") String userid){
        try {
            uploadService.deletePicSsjl(userid);
            return new ReturnMessage().success();
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }

    /**
     * 图片下载记录数量
     *      piczj 图片主键
     * @return
     */
    @GetMapping("/picSsjlCount")
    public ReturnMessage picSsjlCount(@RequestParam Map param){
        try {
            int count = uploadService.picSsjlCount(param);
            return new ReturnMessage().success(count);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
    /**
     * 字典查询
     *  lx  类型
     */
    @GetMapping("/zdcx")
    public ReturnMessage zdcx(@RequestParam Map param){
        try {
            List<Map> data = uploadService.zdcx(param);
            return new ReturnMessage().success(data);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
    /**
     * 我的上传
     *  userid  用户id
     */
    @GetMapping("/wdsc")
    public ReturnMessage wdsc(@RequestParam Map param){
        try {
            List<Map> data = uploadService.wdsc(param);
            return new ReturnMessage().success(data);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnMessage().faild(e.getMessage());
        }
    }
}
