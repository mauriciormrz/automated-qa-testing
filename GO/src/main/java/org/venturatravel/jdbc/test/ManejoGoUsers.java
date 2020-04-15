package org.venturatravel.jdbc.test;

import org.venturatravel.jdbc.data.GoUserJDBC;
import org.venturatravel.jdbc.domain.GoUser;

import java.util.List;

public class ManejoGoUsers {

    public static void main(String[] args) {

        GoUserJDBC goUserJDBC = new GoUserJDBC();
        String sql;

        List<GoUser> activeGoUsersWithBoss;
        List<GoUser> inactiveGoUsers;
        List<GoUser> allGoUsers;

        sql = "SELECT u.id, u.first_name, u.last_name, u.vi_email, u.end_date, u.incoming_office_id, u.sf_guard_user_id, u.go_user_boss_id, u.job_title, s.is_active  \n" +
                "FROM ventura_staging.go_user u\n" +
                "INNER JOIN ventura_staging.sf_guard_user_2 s \n" +
                "ON u.sf_guard_user_id = s.id \n" +
                "WHERE is_active =1 AND u.end_date >= NOW() AND u.go_user_boss_id IS NOT null\n" +
                "ORDER BY u.go_user_boss_id, u.id;";
        activeGoUsersWithBoss = goUserJDBC.select(sql);

        sql = "SELECT u.id, u.first_name, u.last_name, u.vi_email, u.end_date, u.incoming_office_id, u.sf_guard_user_id, u.go_user_boss_id, u.job_title, s.is_active  \n" +
                "FROM ventura_staging.go_user u\n" +
                "INNER JOIN ventura_staging.sf_guard_user_2 s \n" +
                "ON u.sf_guard_user_id = s.id \n" +
                "WHERE is_active =0 OR u.end_date < NOW() \n" +
                "ORDER BY u.id;";
        inactiveGoUsers = goUserJDBC.select(sql);

        sql = "SELECT u.id, u.first_name, u.last_name, u.vi_email, u.end_date, u.incoming_office_id, u.sf_guard_user_id, u.go_user_boss_id, u.job_title, s.is_active  \n" +
                "FROM ventura_staging.go_user u\n" +
                "INNER JOIN ventura_staging.sf_guard_user_2 s \n" +
                "ON u.sf_guard_user_id = s.id \n" +
                "ORDER BY u.id;";
        allGoUsers = goUserJDBC.select(sql);

        System.out.println("activeGoUsers: " + activeGoUsersWithBoss.size());
        System.out.println("inactiveGoUsers: " + inactiveGoUsers.size());
        System.out.println("allGoUsers: " + allGoUsers.size());

        int i = 0;
        int j = 0;
        boolean found = false;

        for (GoUser activeGoUserWithBoss : activeGoUsersWithBoss) {

            for (GoUser inactiveGoUser : inactiveGoUsers) {

                if (activeGoUserWithBoss.getGo_user_boss_id() == inactiveGoUser.getId()) {
                    found = true;
                    break;
                }
            }

            if (found) i++;
            else j++;
            found = false;
        }

        System.out.println("activeGoUsers con inactiveGoBosses: " + i);
        System.out.println("activeGoUsers con activeGoBosses: " + j);
    }
}
