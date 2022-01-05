/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cemilan.cemilan;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author annis
 */
@Controller
public class DatabaseController {
    
    @CrossOrigin
    @RequestMapping(value = "/cemilanjson", produces = { MediaType.APPLICATION_JSON_VALUE,//MediaType.Text_XML_VALUE
    })
    @ResponseBody
    public List<Datacemilan> getDataCemilan(){
        
        List<Datacemilan> datacemilan = new ArrayList<>();
        
        DatacemilanJpaController controller = new DatacemilanJpaController();
        
        try{
            datacemilan = controller.findDatacemilanEntities();
        } catch(Exception e){}
        return datacemilan;
    }
    
    @RequestMapping("/cemilanxml")
    @ResponseBody
    public List<Datacemilan> getDataCemilanxml(){
        
        List<Datacemilan> datacemilan = new ArrayList<>();
        
        DatacemilanJpaController controller = new DatacemilanJpaController();
        
        try{
            datacemilan = controller.findDatacemilanEntities();
        } catch(Exception e){}
        return datacemilan;
    }
}

