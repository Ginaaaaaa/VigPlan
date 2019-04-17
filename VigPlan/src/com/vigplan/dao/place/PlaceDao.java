package com.vigplan.dao.place;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vigplan.dao.BaseDao;
import com.vigplan.vo.PlaceVo;

public class PlaceDao extends BaseDao {

	public PlaceDao(String dbuser, String dbpass) {
		super(dbuser, dbpass);
	}

	public List<PlaceVo> getAllLogs() {
		
		List<PlaceVo> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT pk, title, link, description, telephone, address, roadAddress, mapx, mapy FROM place ORDER BY pk DESC";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				PlaceVo vo = new PlaceVo();
				
				vo.setPk(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setLink(rs.getString(3));
				vo.setDescription(rs.getString(4));
				vo.setTelephone(rs.getString(5));
				vo.setAddress(rs.getString(6));
				vo.setRoadAddress(rs.getString(7));
				vo.setMapx(rs.getInt(8));
				vo.setMapy(rs.getInt(9));
				list.add(vo);

			}

		} catch (Exception e) {

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {

			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {

			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}

		return list;
	}

	public int insertPlace(PlaceVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;

		try {
			conn = getConnection();
			String sql = "INSERT INTO place (pk, title, link, description, telephone, address, roadAddress, mapx, mapy) VALUES(seq_place.nextval, ?, ?, ?, ? ,? ,? ,? ,? )";
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getLink());
			pstmt.setString(3, vo.getDescription());
			pstmt.setString(4, vo.getTelephone());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getRoadAddress());
			pstmt.setInt(7, vo.getMapx());
			pstmt.setInt(8, vo.getMapy());

			pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {

			}
			try {

			} catch (Exception e) {

			}

		}

		return insertedCount;

	}

	public PlaceVo getPlaceItem(Long pk) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PlaceVo line = null;

		try {
			conn = getConnection();
			String sql = "SELECT title, link, description, telephone, address, roadAddress, mapx, mapy FROM place where pk = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, pk);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				line = new PlaceVo();
				line.setPk(pk);
				line.setTitle(rs.getString(1));
				line.setLink(rs.getString(2));
				line.setDescription(rs.getString(3));
				line.setTelephone(rs.getString(4));
				line.setAddress(rs.getString(5));
				line.setRoadAddress(rs.getString(6));
				line.setMapx(rs.getInt(7));
				line.setMapy(rs.getInt(8));
				

			}

		} catch (Exception e) {

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}

		}
		return line;

	}

	public int updatePlace(PlaceVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = getConnection();
			String sql = "UPDATE place SET title = ?, link = ?, description = ?, telephone = ?, address = ?, roadAddress = ?, mapx = ?, mapy = ? WHERE pk = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getLink());
			pstmt.setString(3, vo.getDescription());
			pstmt.setString(4, vo.getTelephone());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getRoadAddress());
			pstmt.setInt(7, vo.getMapx());
			pstmt.setInt(8, vo.getMapy());
			pstmt.setLong(9, vo.getPk());

			result = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {

			} catch (Exception e) {

			}
			try {

			} catch (Exception e) {

			}
		}

		return result;
	}

	public int deletePlace(Long pk) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String sql = "DELETE FROM place WHERE pk = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, pk);
			rs = pstmt.executeQuery();

		} catch (Exception e) {

		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (Exception e) {

			}
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}

		return 0;
	}

}
