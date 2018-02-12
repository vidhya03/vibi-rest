package com.labkit.vidhya.cucumber.stepdefs;

import com.labkit.vidhya.VibirestApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = VibirestApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
