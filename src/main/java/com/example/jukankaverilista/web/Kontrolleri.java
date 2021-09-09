package com.example.jukankaverilista.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jukankaverilista.domain.Kaveri;

@Controller
public class Kontrolleri {
	// ATTRIBUUTISSA PIDETÄÄN KAVERILISTAA
	private List<Kaveri> friends = new ArrayList<Kaveri>(); 
	
	// TEHDÄÄN ENSIN ENDPOINT LANDING PAGELLE KUN SIVUSTOLLE
	// TULLAAN EKAN KERRAN
	@RequestMapping(value = "/aloitus", method = RequestMethod.GET)
	public String naytaAloitus(@RequestParam(name="friend", required=false) String nimi, Model model) {
		System.out.println("TULTIIN KONTROLLERIIIN");
		friends = new ArrayList<Kaveri>();
		Kaveri kaveri = new Kaveri();
		model.addAttribute("friend", kaveri);
		return "index";
	}
	
	@RequestMapping(value="/kaverinlahetys", method = RequestMethod.GET)
	public String kasittelePostaus(@ModelAttribute(name="friend") Kaveri kaveri, Model model ) {
		System.out.println("OLLAAN KASITTELE POSTAUKSESSA!!!!1111");
		friends.add(kaveri);
		model.addAttribute("friends", friends);
		System.out.println(kaveri);
		System.out.println(friends);
		// HALUTAAN TYHJÄTÄ LOMAKE SEURAAVAA VARTEN
		kaveri = new Kaveri();
		model.addAttribute("friend", kaveri);
		return "index";
	}

}
