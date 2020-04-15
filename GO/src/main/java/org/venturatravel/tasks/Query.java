package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.venturatravel.jdbc.data.GoUserJDBC;
import org.venturatravel.jdbc.domain.GoUser;

import java.util.List;

public class Query implements Task {

    private static String db;
    private static List<GoUser> activeGoUsersWithBoss;
    private static List<GoUser> inactiveGoUsers;
    private static List<GoUser> allGoUsers;

    public Query(String db) {
        this.db = db;
    }

    public static Performable theDatabase(String db) {
        return Instrumented.instanceOf(Query.class)
                .withProperties(db);
    }

    public static List<GoUser> getActiveGoUsersWithBoss() {
        return activeGoUsersWithBoss;
    }

    public static List<GoUser> getInactiveGoUsers() {
        return inactiveGoUsers;
    }

    public static List<GoUser> getAllGoUsers() {
        return allGoUsers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        GoUserJDBC goUserJDBC = new GoUserJDBC();
        String sql;


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

    }
}
