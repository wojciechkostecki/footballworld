package com.example.footballworld.controller;

import com.example.footballworld.model.League;
import com.example.footballworld.service.LeagueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view")
public class LeaguesViewController {
    private final LeagueService leagueService;

    public LeaguesViewController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping
    public String getAllLeagues(Model model) {
        model.addAttribute("listLeagues", leagueService.getAll());
        return "leagues";
    }

    @GetMapping("/showNewLeagueForm")
    public String showNewLeagueForm(Model model) {
        League league = new League();
        model.addAttribute("league", league);
        return "new_league";
    }

    @PostMapping("/saveLeague")
    public String saveLeague(@ModelAttribute("league") League league) {
        leagueService.save(league);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        League league = leagueService.findById(id).get();
        model.addAttribute("league", league);
        return "update_league";
    }

    @GetMapping("/deleteLeague/{id}")
    public String deleteLeague(@PathVariable Long id) {
        this.leagueService.delete(id);
        return "redirect:/";
    }
}
