package ksaito.test.api.controller;

import ksaito.test.Utilities.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    protected PropertiesUtil prop;
}
