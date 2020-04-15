package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.venturatravel.jdbc.domain.GoUser;

import java.util.ArrayList;
import java.util.List;

public class VerifyThe implements Task {

    private static List<GoUser> activeGoUsersWithBoss;
    private static List<GoUser> inactiveGoUsers;
    private static List<GoUser> resultGoUsers = new ArrayList<>();

    public static Performable queryResults(List<GoUser> activeGoUsersWithBoss, List<GoUser> inactiveGoUsers) {

        return Instrumented.instanceOf(VerifyThe.class)
                .withProperties(activeGoUsersWithBoss, inactiveGoUsers);
    }

    public VerifyThe(List<GoUser> activeGoUsersWithBoss, List<GoUser> inactiveGoUsers) {

        this.activeGoUsersWithBoss = activeGoUsersWithBoss;
        this.inactiveGoUsers = inactiveGoUsers;
    }

    public static List<GoUser> getResultGoUsers() {
        return resultGoUsers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        int i = 0;
        int j = 0;
        boolean found = false;

        for (GoUser activeGoUserWithBoss : activeGoUsersWithBoss) {

            for (GoUser inactiveGoUser : inactiveGoUsers) {

                if (activeGoUserWithBoss.getGo_user_boss_id() == inactiveGoUser.getId()) {
                    resultGoUsers.add(activeGoUserWithBoss);
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
