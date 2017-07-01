package com.why.project.intentactionutildemo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.io.File;
import java.util.List;

/**
 * Create By HaiyuKing
 * Used Intent的常见作用的工具类(以前叫AndroidFileUtil)
 * 参考资料 http://blog.csdn.net/chaoyu168/article/details/50778016
 * http://www.2cto.com/kf/201210/162045.html
 * http://blog.csdn.net/shlpyy/article/details/8706751
 * http://www.cnblogs.com/simov/p/3761243.html
 * http://blog.csdn.net/wangyang2698341/article/details/20847469
 */
@SuppressLint("DefaultLocale")
public class IntentActionUtil {
	
	/**
	 * 打开指定类型的文件的Intent
	 * param - filePath : 文件路径：例如，*/
    public static Intent openFileIntent(String filePath) {
        if(isFileExit(filePath)){
            String endName = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length()).toLowerCase();//后缀名
		/* 依扩展名的类型决定MimeType */
            if (endName.equals("m4a") || endName.equals("mp3") || endName.equals("mid") ||
                    endName.equals("xmf") || endName.equals("ogg") || endName.equals("wav") || endName.equals("amr")) {
                return getAudioFileIntent(filePath);//播放音频
            } else if (endName.equals("3gp") || endName.equals("mp4")) {
                return getVideoFileIntent(filePath);//播放视频
            } else if (endName.equals("jpg") || endName.equals("gif") || endName.equals("png") ||
                    endName.equals("jpeg") || endName.equals("bmp")) {
                return getImageFileIntent(filePath);//打开图片
            } else if (endName.equals("apk")) {
                return getApkFileIntent(filePath);//安装软件
            } else if (endName.equals("ppt") || endName.equals("pptx")) {
                return getPptFileIntent(filePath);//打开PPT文档
            } else if (endName.equals("xls") || endName.equals("xlsx")) {
                return getExcelFileIntent(filePath);//打开excel文档
            } else if (endName.equals("doc") || endName.equals("docx")) {
                return getWordFileIntent(filePath);//打开doc文档
            } else if (endName.equals("pdf")) {
                return getPdfFileIntent(filePath);//打开PDF文档
            } else if (endName.equals("chm")) {
                return getChmFileIntent(filePath);//打开CHM文档
            } else if (endName.equals("txt")) {
                return getTextFileIntent(filePath);//打开txt文档
            } else if (endName.equals("zip")) {
                return getZipFileIntent(filePath);//打开zip压缩包
            } else if (endName.equals("rar")) {
                return getRarFileIntent(filePath);//打开rar压缩包
            } else if (endName.equals("html") || endName.equals("htm")) {
                return getHtmlFileIntent(filePath);//打开html文件
            }else {
                return getAllIntent(filePath);//打开其他的文件
            }
        }else{
            return null;
        }
    }
    
    /**
     * 调用发邮件的Intent
     * param sendToEmail - 邮件主送人的地址
     * return
     */
    public static Intent getEmailIntent(String sendToEmail) {
        Uri emailUri = Uri.parse(sendToEmail);
        Intent intent = new Intent(Intent.ACTION_SENDTO, emailUri);
        return intent;
    }
    /**
     * 调用浏览器打开网页的Intent
     * 
     * param url - 网址：例如，http://www.baidu.com
     * return
     */
    public static Intent getWebViewIntent(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        return intent;
    }
    
    /**
     * 调用地图软件显示地图定位的Intent
     * param x - 定位X坐标：116.398064
     * param y - 定位Y坐标：39.913703
     * return
     */
    public static Intent getMapViewIntent(double x,double y) {
    	Uri uri = Uri.parse("geo:"+x+","+y);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        return intent;
    }
    
    /**
     * 打开拨号程序，拨打电话的Intent
     * 
     * param telphoneNum - 电话号码
     * return
     */
    public static Intent getPhoneIntent(String telphoneNum) {
    	Uri uri = Uri.parse("tel:" + telphoneNum);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        return intent;
    }
    
    /**
     * 打开短信程序，发送短信的Intent
     * 
     * param telphoneNum - 电话号码
     * param smsBody - 短信内容文本
     * return
     */
    public static Intent getSMSIntent(String telphoneNum,String smsBody) {
    	Uri uri = Uri.parse("smsto:" + telphoneNum);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body",smsBody);
        return intent;
    }
    
    /**
     * Android获取一个用于打开VIDEO（视频）文件的intent
     */
    private static Intent getVideoFileIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "video/*");
        return intent;
    }
    
    /**
     * Android获取一个用于打开AUDIO（音频）文件的intent
     */
    private static Intent getAudioFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        Uri uri = Uri.fromFile(new File(param));
        intent.setDataAndType(uri, "audio/*");
        return intent;
    }
    
    /**
     * Android获取一个用于打开图片文件的intent
     */
    private static Intent getImageFileIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "image/*");
        return intent;
    }
    
    /**
     * Android获取一个用于安装APK文件的intent
     */
    private static Intent getApkFileIntent(String filePath) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        return intent;
    }
    
    /**
     * Android获取一个用于打开PPT文件的intent
     */
    private static Intent getPptFileIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
        return intent;
    }
    /**
     * Android获取一个用于打开Excel文件的intent
     */
    private static Intent getExcelFileIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "application/vnd.ms-excel");
        return intent;
    }
    /**
     * Android获取一个用于打开Word文件的intent
     */
    private static Intent getWordFileIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "application/msword");
        return intent;
    }
    
    /**
     * Android获取一个用于打开PDF文件的intent
     */
    private static Intent getPdfFileIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "application/pdf");
        return intent;
    }
    
    /**
     * Android获取一个用于打开CHM文件的intent
     */
    private static Intent getChmFileIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "application/x-chm");
        return intent;
    }
    
    /**
     * Android获取一个用于打开文本文件的intent
     */
    private static Intent getTextFileIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "text/plain");
        return intent;
    }
    
    /**
     * Android获取一个用于打开ZIP文件的intent
     */
    private static Intent getZipFileIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "application/zip");
        return intent;
    }
    /**
     * Android获取一个用于打开Rar文件的intent
     */
    private static Intent getRarFileIntent(String filePath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "application/rar");
        return intent;
    }
    
    /**
     * Android获取一个用于打开Html文件的intent【有点儿问题，无法实现选择浏览器查看预览效果，且在Android6.0上无法通过“HTML查看程序”进行查看】
     */
    private static Intent getHtmlFileIntent(String filePath) {
        Uri uri = Uri.parse(filePath).buildUpon().encodedAuthority("com.android.htmlfileprovider")
                .scheme("content").encodedPath(filePath).build();//content://com.android.htmlfileprovider/storage/emulated/0/intentFile/htmldemo.html
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setDataAndType(uri, "text/html");
        return intent;
    }
    
    /**
     * Android获取一个用于打开任意文件的intent
     */
    private static Intent getAllIntent(String filePath) {

        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setDataAndType(uri, "*/*");
        return intent;
    }
    
    
    /**
     * 判断intent是否可用
     */
    public static boolean isIntentAvailable(Context mContext, Intent intent) {
        final PackageManager packageManager = mContext.getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);//PackageManager.GET_ACTIVITIES
        return list.size() > 0;
    }

    /**
     * 判断intent是否可用
     * 些时候你想要知道某个AP是否有注册了一个明确的intent
     * 比如说你想要检查某个receiver是否存在，然后根据是否存在来这个receiver来在你的AP里面enable某些功能
     */
    public static boolean isIntentAvailable(Context context, String action) {
        final PackageManager packageManager = context.getPackageManager();
        final Intent intent = new Intent(action);
        List<ResolveInfo> resolveInfo = packageManager.queryIntentActivities(intent,
                        PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfo.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断文件是否存在
     * param - filePath:文件路径
     */
    private static boolean isFileExit(String filePath) {
        if (filePath == null) {
            return false;
        }
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return true;
    }
}