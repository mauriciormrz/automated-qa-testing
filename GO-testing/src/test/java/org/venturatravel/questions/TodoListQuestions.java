package org.venturatravel.questions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;
import java.util.stream.Collectors;


public class TodoListQuestions extends PageObject {

    public List<String> contents() {

        return findAll("#exploreTemplates > div")
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
