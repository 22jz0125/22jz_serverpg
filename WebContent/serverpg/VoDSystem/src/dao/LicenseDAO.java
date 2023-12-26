package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.License;

public class LicenseDAO {
    /**
     * ライセンステーブルのデータをすべて取得するメソッド
     * @return List<License> ライセンスデータ
     */
    public List<License> get() {
        List<License> list = new ArrayList<>();

        DBManager manager = DBManager.getInstance();
        try (Connection cn = manager.getConnection()) {
            String sql = "SELECT * FROM Licenses";
            PreparedStatement stmt = cn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            int count = 0;

            // データをリストに格納
            while (rs.next()) {
                License video = rs2model(rs);
                list.add(video);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    /**
     * ライセンステーブルの中から、主キーが id であるレコードを返すメソッド
     * @param id 主キーの値
     * @return License 発見したライセンスデータ。なければnull
     */
    public License find(int id) {
        License License = null;
        DBManager manager = DBManager.getInstance();
        try (Connection cn = manager.getConnection()) {
            // プレースホルダで変数部分を定義
            String sql = "SELECT * FROM Licenses WHERE id = ?";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            // データをリストに格納
            if (rs.next()) {
                License = rs2model(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return License;
    }
    
    /**
     * ライセンステーブルのデータから、引数に与えられたビデオIDを持つレコードを返すメソッド
     * @param videoId 検索するビデオID
     * @return List<License> ライセンスデータ
     */
    public List<License> getLicenseByVideoId(int videoId) {
        List<License> list = new ArrayList<>();
        
        DBManager manager = DBManager.getInstance();
        try(Connection cn = manager.getConnection()) {
        String sql = "SELECT * FROM Licenses WHERE id = ?";
        PreparedStatement stmt = cn.prepareStatement(sql);
        stmt.setInt(1, videoId);                            
        ResultSet rs = stmt.executeQuery();

            // データをリストに格納
            while(rs.next()) {
                License license = rs2model(rs);
                list.add(license);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    /**
     * ResultSetの行データをモデルの形に変換するメソッド
     * @param rs 変換前のデータ
     * @return 変換後のデータ
     */
    private License rs2model(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        LocalDateTime purchaseStartDate =
                 rs.getTimestamp("purchase_start_date").toLocalDateTime();                          
        LocalDateTime purchaseEndDate = 
                 rs.getTimestamp("purchase_end_date").toLocalDateTime();                             
        int price = rs.getInt("price");

        return new License(id, purchaseStartDate, purchaseEndDate, price);
    }
}
