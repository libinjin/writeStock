package com.youguu.intelligent.util;

import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class DBUtil {
	private static final Log LOG = LogFactory.getLog(DBUtil.class);
	
	public static void exeProc(Connection conn, String proc) {
		CallableStatement cs = null;
		try {
			cs = conn.prepareCall(proc);
			cs.execute();
		} catch (Exception e) {
			LOG.error("error when invoke procedure " + proc,e);
		} finally {
			if (cs != null)
				try {
					cs.close();
				} catch (SQLException e) {
					LOG.error("error when invoke procedure " + proc);
				}
		}
	}
	
	public static int exeUpdate(Connection conn, String sql) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			return ps.executeUpdate();
		} catch (Exception e) {
			LOG.error("error when execute " + sql , e);
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					LOG.error("error when execute " + sql , e);
				}
		}
		return 0;
	}
}
