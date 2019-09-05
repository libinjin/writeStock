/**  
* @Title: BOLLPoint.java
* @Package com.youguu.quote.market
* @Description: BOLL pojo
* @author TangYanhong
* @date 2014年5月20日 上午10:11:06
* @version V1.0  
*/
 
package com.youguu.intelligent.second;

/**
 * @ClassName: BOLLPoint
 * @Description: BOLL pojo
 * @author TangYanhong
 * @date 2014年5月20日 上午10:11:06
 * 
 */
public class BOLLPoint {
	
	private Double mid;
	
	private Double upper;
	
	private Double lower;
	
	private long date;


	public BOLLPoint(Double mid, Double upper, Double lower, long date) {
		this.mid = mid;
		this.upper = upper;
		this.lower = lower;
		this.date = date;
	}

	public Double getMid() {
		return mid;
	}

	public void setMid(Double mid) {
		this.mid = mid;
	}

	public Double getUpper() {
		return upper;
	}

	public void setUpper(Double upper) {
		this.upper = upper;
	}

	public Double getLower() {
		return lower;
	}

	public void setLower(Double lower) {
		this.lower = lower;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "BOLLPoint{" +
				"mid=" + mid +
				", upper=" + upper +
				", lower=" + lower +
				", date=" + date +
				'}';
	}
}
