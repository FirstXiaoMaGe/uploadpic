package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;

public class FileModel implements Serializable {
	private Integer fid;
	private String fname;
	private File fcontent;
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public File getFcontent() {
		return fcontent;
	}
	public void setFcontent(File fcontent) {
		this.fcontent = fcontent;
	}
	@Override
	public String toString() {
		return "FileModel [fid=" + fid + ", fname=" + fname + ", fcontent="
				+ "]";
	}
	public FileModel(Integer fid, String fname, File fcontent) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fcontent = fcontent;
	}
}
