package com.why.project.intentactionutildemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.why.project.intentactionutildemo.utils.IntentActionUtil;

public class MainActivity extends AppCompatActivity {

	private TextView tv_openAudio;
	private TextView tv_openEmail;
	private TextView tv_openVideo;
	private TextView tv_openWeb;
	private TextView tv_openImg;
	private TextView tv_openMap;
	private TextView tv_openApk;
	private TextView tv_openTel;
	private TextView tv_openPpt;
	private TextView tv_openSMS;
	private TextView tv_openXls;
	private TextView tv_openDoc;
	private TextView tv_openPdf;
	private TextView tv_openChm;
	private TextView tv_openTxt;
	private TextView tv_openZip;
	private TextView tv_openRar;
	private TextView tv_openHtml;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initEvents();
	}

	private void initViews(){
		tv_openAudio = (TextView) findViewById(R.id.tv_openAudio);
		tv_openEmail = (TextView) findViewById(R.id.tv_openEmail);
		tv_openVideo = (TextView) findViewById(R.id.tv_openVideo);
		tv_openWeb = (TextView) findViewById(R.id.tv_openWeb);
		tv_openMap = (TextView) findViewById(R.id.tv_openMap);
		tv_openImg = (TextView) findViewById(R.id.tv_openImg);
		tv_openApk = (TextView) findViewById(R.id.tv_openApk);
		tv_openTel = (TextView) findViewById(R.id.tv_openTel);
		tv_openPpt = (TextView) findViewById(R.id.tv_openPpt);
		tv_openSMS = (TextView) findViewById(R.id.tv_openSMS);
		tv_openXls = (TextView) findViewById(R.id.tv_openXls);
		tv_openDoc = (TextView) findViewById(R.id.tv_openDoc);
		tv_openPdf = (TextView) findViewById(R.id.tv_openPdf);
		tv_openChm = (TextView) findViewById(R.id.tv_openChm);
		tv_openTxt = (TextView) findViewById(R.id.tv_openTxt);
		tv_openZip = (TextView) findViewById(R.id.tv_openZip);
		tv_openRar = (TextView) findViewById(R.id.tv_openRar);
		tv_openHtml = (TextView) findViewById(R.id.tv_openHtml);
	}

	private void initEvents(){

		tv_openEmail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent = IntentActionUtil.getEmailIntent("wangxxxxxx@126.com");
				if(IntentActionUtil.isIntentAvailable(MainActivity.this,intent)){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this, "无法打开，请安装手机邮箱软件", Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openWeb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent = IntentActionUtil.getWebViewIntent("http://www.baidu.com");
				if(IntentActionUtil.isIntentAvailable(MainActivity.this,intent)){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this, "无法打开，请安装手机浏览器软件", Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openMap.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent = IntentActionUtil.getMapViewIntent(116.398064,39.913703);
				if(IntentActionUtil.isIntentAvailable(MainActivity.this,intent)){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this, "无法打开，请安装手机地图软件", Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openTel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent = IntentActionUtil.getPhoneIntent("10010");
				if(IntentActionUtil.isIntentAvailable(MainActivity.this,intent)){
					MainActivity.this.startActivity(intent);
				}
			}
		});

		tv_openSMS.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent = IntentActionUtil.getSMSIntent("10010","");
				if(IntentActionUtil.isIntentAvailable(MainActivity.this,intent)){
					MainActivity.this.startActivity(intent);
				}
			}
		});

		tv_openAudio.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory() + "/intentFile/" + "videodemo.m4a";
				Intent intent = new Intent();
				intent = IntentActionUtil.openFileIntent(filePath);
				if(intent != null){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openVideo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory() + "/intentFile/" + "audiodemo.mp4";
				Intent intent = new Intent();
				intent = IntentActionUtil.openFileIntent(filePath);
				if(intent != null){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory() + "/intentFile/" + "imgdemo.jpg";
				Intent intent = new Intent();
				intent = IntentActionUtil.openFileIntent(filePath);
				if(intent != null){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openApk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory() + "/intentFile/" + "apkdemo.apk";
				Intent intent = new Intent();
				intent = IntentActionUtil.openFileIntent(filePath);
				if(intent != null){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openPpt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory() + "/intentFile/" + "pptdemo.pptx";
				Intent intent = new Intent();
				intent = IntentActionUtil.openFileIntent(filePath);
				if(intent != null){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openXls.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory() + "/intentFile/" + "exceldemo.xlsx";
				Intent intent = new Intent();
				intent = IntentActionUtil.openFileIntent(filePath);
				if(intent != null){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openDoc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory() + "/intentFile/" + "docdemo.docx";
				Intent intent = new Intent();
				intent = IntentActionUtil.openFileIntent(filePath);
				if(intent != null){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openPdf.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory() + "/intentFile/" + "pdfdemo.pdf";
				Intent intent = new Intent();
				intent = IntentActionUtil.openFileIntent(filePath);
				if(intent != null){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openChm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory() + "/intentFile/" + "chmdemo.chm";
				Intent intent = new Intent();
				intent = IntentActionUtil.openFileIntent(filePath);
				if(intent != null){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openTxt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory() + "/intentFile/" + "txtdemo.txt";
				Intent intent = new Intent();
				intent = IntentActionUtil.openFileIntent(filePath);
				if(intent != null){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openZip.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory() + "/intentFile/" + "zipdemo.zip";
				Intent intent = new Intent();
				intent = IntentActionUtil.openFileIntent(filePath);
				if(intent != null){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openRar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory() + "/intentFile/" + "rardemo.rar";
				Intent intent = new Intent();
				intent = IntentActionUtil.openFileIntent(filePath);
				if(intent != null){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});

		tv_openHtml.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filePath = Environment.getExternalStorageDirectory() + "/intentFile/" + "htmldemo.html";
				Intent intent = new Intent();
				intent = IntentActionUtil.openFileIntent(filePath);
				if(intent != null){
					MainActivity.this.startActivity(intent);
				}else{
					Toast.makeText(MainActivity.this,"文件不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
