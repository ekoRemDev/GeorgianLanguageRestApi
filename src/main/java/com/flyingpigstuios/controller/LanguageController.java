package com.flyingpigstuios.controller;

import com.flyingpigstuios.model.Language;
import com.flyingpigstuios.repository.LanguageRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/language")
@Api(value="/Languages API", description="Languages in App" , tags = {"LanguagesApi"})
public class LanguageController {

    @Autowired
    LanguageRepository languageRepository;


    @ApiOperation(
            tags = {"LanguagesApi"},
            value = "All Languages",
            notes = "Returns languages list"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Languages are listed successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Language> languagesList(){
        return languageRepository.findAll();
    }

}
