package org.venturatravel.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.venturatravel.ui.TodoList;

import java.util.List;

public class TheItems {

    public static <T> Question<List<String>> displayed() {

        return actor -> Text.of(TodoList.ITEMS).viewedBy(actor).asList();
    }
}
