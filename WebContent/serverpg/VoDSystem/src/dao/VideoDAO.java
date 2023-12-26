package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.License;
import model.Video;

public class VideoDAO {
	public List<Video> get() {
		List<Video> list = new ArrayList<>();
		
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM videos";
			PreparedStatement stmt = cn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			
			// データをリストに格納
			while(rs.next()) {
				Video video = rs2model(rs);
				setLicenses(video);
				list.add(video);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public Video find(int id) {
		Video video = null;
		DBManager manager = DBManager.getInstance();
		try(Connection cn = manager.getConnection()) {
			// プレースホルダで変数部分を定義
			String sql = "SELECT * FROM videos WHERE id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			// データをリストに格納
			if (rs.next()) {
				video = rs2model(rs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return  video;
	}
	
	/**
	 * ビデオデータに紐づくライセンス情報を検索して追加
	 * @param video 追加対象のビデオデータ
	 */
	private void setLicenses(Video video) {
		/* ライセンスDAOのインスタンスを作成し、video に紐づくライセンス情報を取得 */
		LicenseDAO dao = new LicenseDAO();
		List<License> licenses = dao.getLicenseByVideoId(video.getId());
		
																			
		/* 取得したライセンス情報を video にセット */
		video.setLicenses(licenses);
	}

	
	
	
	/**
	 * ResultSetの行データをモデルの形に変換するメソッド
	 * @param rs 変換前のデータ
	 * @return 変換後のデータ
	 */
	private Video rs2model(ResultSet rs) throws SQLException {
		/* 中略。rsの値を取得し、それぞれの変数に代入 */
		int id = rs.getInt("id");
		String title = rs.getString("title");
		String synopsisShort = rs.getString("synopsis_short");
		String synopsisLong = rs.getString("synopsis_long");
		boolean pcNg = rs.getBoolean("pc_ng");

		return new Video(id, title, synopsisShort, synopsisLong, pcNg);
	}


}
