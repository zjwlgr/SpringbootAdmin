package com.brander.common.utils;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 文件上传类
 */
public class UploadUtil {

    //上传的文件大小限制 (0-不做限制) ，单位：字节
    private long maxSize = 0;

    //允许上传的文件后缀，如：".jpg|.png|.git|.jpeg"，为空不做限制
    private String exts;

    //保存根路径，会在tomcat的webapps自动创建该文件夹
    private String rootPath = "uploadFile/";

    //保存路径，如 "userimage"
    private String savePath = "";

    //子目录创建方式，默认：年-月
    private  String subName = "yyyy-MM";

    //是否启动时间格式的子目录
    private boolean isSubName = true;

    //上传的文件名称
    private List<String> fileNames;

    //上传错误信息
    private String error;

    public UploadUtil() {
        this.fileNames = new ArrayList<String>();
    }

    public long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }

    public String getExts() {
        return exts;
    }

    public void setExts(String exts) {
        this.exts = exts;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public boolean getIsSubName() {
        return isSubName;
    }

    public void setIsSubName(boolean isSubName) {
        this.isSubName = isSubName;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    /**
     * 上传文件
     * @param request 当前请求的request
     */
    public boolean upload(HttpServletRequest request)  throws IllegalStateException, IOException {

        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());

        //判断 request 是否有文件上传,即多部分请求,其实判断是否为（enctype="multipart/form-data" method="POST"）
        if(multipartResolver.isMultipart(request)){

            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;

            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();

            //记数器
            int num = 0;

            //web服务器文件根路径
            String webFilePath;

            //为批量上传，所以如果有下一个信息，能循环输出
            while(iter.hasNext()){

                webFilePath = "";

                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());

                //如果type=file中有文件上传
                if(!file.isEmpty()){

                    //取得当前上传文件的文件名称
                    String fileName = file.getOriginalFilename();

                    //获取文件大小，单位：字节
                    long fileSize = file.getSize();

                    /* 检查文件大小 */
                    if (!this.checkSize(fileSize)) {
                        this.setError("上传文件大小不符！");
                        return false;
                    }

                    //获取文件的后缀名
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));

                    /* 判断文件后缀名是否合法 */
                    if(!this.checkExt(suffixName)){
                        this.setError("上传文件后缀不允许！");
                        return false;
                    }

                    //使用GUID重命名图片名称
                    fileName = UUID.randomUUID() + suffixName;

                    /* 获取Tomcat的webapps根目录 */
                    String projectPath = this.tomcatPath();

                    /* 是否生成子目录 */
                    String dateDir = this.dateDir();

                    //web服务器根目录文件路径
                    webFilePath = this.getRootPath() + this.getSavePath() + dateDir + fileName;

                    //文件最终保存全路径
                    String fileNamePath = projectPath + webFilePath;

                    //创建File对象
                    File localFile = new File(fileNamePath);

                    //检测是否存在目录，不存在则创建
                    if (!localFile.getParentFile().exists()) {
                        localFile.getParentFile().mkdirs();
                    }

                    //执行上传文件
                    file.transferTo(localFile);

                }

                //累加保存生成文件名
                this.fileNames.add(num,webFilePath);

                num++;
            }

        }
        //没有上传任何文件，返回true，去判断返回文件List中的值
        return true;
    }

    /**
     * 检查文件大小是否合法
     * @param size 文件大小，单位/字节
     * @return boolean
     */
    private boolean checkSize(long size) {
        return !(size > this.getMaxSize()) || (0 == this.getMaxSize());
    }

    /**
     * 检查上传的文件后缀是否合法
     * @param ext 后缀
     * @return boolean
     */
    private boolean checkExt(String ext){
        if(this.getExts().isEmpty()){
            return true;
        }else{
            if(this.getExts().indexOf(ext) != -1){
                return true;
            }
        }
        return false;
    }

    /**
    * 返回Tomcat的webapps根目录
    * @return String 路径
    */
    private String tomcatPath(){
        //获取当前项目的运行环境根目录,如：/C:/myJavaEEWorkSpace/SpringGirl/target/classes/
        String projectPath = ClassUtils
                .getDefaultClassLoader()
                .getResource("")
                .getPath();
        //返回Tomcat的webapps根目录 (考虑到每次发布会覆盖war，文件最好存在war外面)
        projectPath = projectPath + "../../../";
        return projectPath;
    }

    /**
     * 是否生成子目录，返回子目录名称
     * @return String 目录名称
     */
    private String dateDir(){
        //是否生成子目录
        String dateDir;
        if(this.getIsSubName()) {
            //设置文件存放子目录
            SimpleDateFormat df = new SimpleDateFormat(this.getSubName());// 设置日期格式
            dateDir = df.format(new Date());// new Date()为获取当前系统时间
            dateDir = dateDir + "/";
        }else{
            dateDir = "";
        }
        return dateDir;
    }

}

