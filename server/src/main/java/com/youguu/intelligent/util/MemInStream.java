package com.youguu.intelligent.util;

import java.io.ByteArrayInputStream;

public class MemInStream extends ByteArrayInputStream {

	public MemInStream(byte[] buf) {
		super(buf);
	}
	
	public MemInStream(byte[] buf, int offset, int length) {
		super(buf, offset, length);
	}
	
	public byte[] getBuf(){
		return this.buf;
	}
	
	public void setBuf(byte[] data){
		this.buf = data;
		this.count= data.length;
		this.pos = 0;
		this.mark =0;
	}
	
	public void setBuf(byte[] data,int offset ,int length){
		this.buf = data;
		this.pos = offset;
		this.count= Math.min(pos + length, buf.length);
		this.mark = pos;
	}
	
	public int getPosition(){
		return super.pos;
	}

}
