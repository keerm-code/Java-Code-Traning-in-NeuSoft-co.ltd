module test {
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.controls;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    exports
            com.neu.test.pojo.impl to
            com.fasterxml.jackson.databind;
    opens com.neu.test.view;
    opens com.neu.test.pojo.impl;
    opens com.neu.test.controller;
}