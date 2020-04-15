package org.venturatravel.jdbc.data;


import org.venturatravel.jdbc.domain.GoUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoUserJDBC {

    private static  String SQL_SELECT;
    private static  String SQL_UPDATE;

    public GoUserJDBC(){
         SQL_SELECT = "SELECT id, first_name, last_name, vi_email, end_date, sf_guard_user_id, incoming_office_id, go_user_boss_id, job_title  FROM ventura_staging.go_user";
         SQL_UPDATE = "UPDATE ventura_staging.go_user SET vi_email=? WHERE id=?";
    }

    public List<GoUser> select(String sql) {

        SQL_SELECT = sql;
        return select();
    }

    public List<GoUser> select() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        GoUser goUser = null;
        List<GoUser> goUsers = new ArrayList<>();

        try {
            conn = VConnection.getStagingConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String vi_email = rs.getString("vi_email");
                Date end_date = rs.getDate("end_date");
                int incoming_office_id = rs.getInt("incoming_office_id");
                int sf_guard_user_id = rs.getInt("sf_guard_user_id");
                int go_user_boss_id = rs.getInt("go_user_boss_id");
                String job_title = rs.getString("job_title");
                int is_active = rs.getInt("is_active");

                goUser = new GoUser();
                goUser.setId(id);
                goUser.setFirst_name(first_name);
                goUser.setLast_name(last_name);
                goUser.setVi_email(vi_email);
                goUser.setEnd_date(end_date);
                goUser.setIncoming_office_id(incoming_office_id);
                goUser.setSf_guard_user_id(sf_guard_user_id);
                goUser.setGo_user_boss_id(go_user_boss_id);
                goUser.setJob_title(job_title);
                goUser.setIs_active(is_active);

                goUsers.add(goUser);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            VConnection.close(rs);
            VConnection.close(stmt);
            VConnection.close(conn);
        }

        return goUsers;
    }

}
