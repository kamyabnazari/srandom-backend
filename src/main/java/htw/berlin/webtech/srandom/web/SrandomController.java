package htw.berlin.webtech.srandom.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Main Application Controller
*/

@Controller
public class SrandomController {
    
    @GetMapping(path = "/")
    public ModelAndView showHomepagePage() {
        return new ModelAndView("homepage");
    }
}
