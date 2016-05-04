package com.infosys.rakesh.springmongo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infosys.rakesh.springmongo.dao.AEMapsRepository;
import com.infosys.rakesh.springmongo.model.AEMaps;

@Controller
public class ElectionsRestController {

	private static final Logger logger = LoggerFactory.getLogger(ElectionsRestController.class);
	public static final String APPLICATION_JSON = "application/json";
	public static final String APPLICATION_XML = "application/xml";
	public static final String APPLICATION_HTML = "text/html";

	@Autowired
	AEMapsRepository aeMapsRepository;

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = APPLICATION_HTML)
	public @ResponseBody String status() {
		return "Default Status Message from Elections REST controller....";
	}

	@RequestMapping(value = "/eletions/ae_maps", method = RequestMethod.GET)
	public @ResponseBody List<AEMaps> getAllAEMaps() {
		logger.info("Inside getAllAEMaps() method...");

		List<AEMaps> allAEMaps = aeMapsRepository.findAllMaps();

		return allAEMaps;
	}

	@RequestMapping(value = "/ae/states", method = RequestMethod.GET)
	public @ResponseBody List<AEMaps> getAllUniqStatesFromAEMaps() {
		logger.info("Inside getAllUniqStatesFromAEMaps() method...");

		List<AEMaps> aeUnqStats = aeMapsRepository.findUniqStatesFromAEMaps();

		return aeUnqStats;
	}

	@RequestMapping(value = "/ae/year", method = RequestMethod.GET)
	public @ResponseBody List<AEMaps> getUniqYearFromAEMaps(@RequestParam(value = "state") String state) {
		logger.info("Inside getAllUniqStatesFromAEMaps() method...");

		List<AEMaps> aeUnqYrs = aeMapsRepository.findUniqYearFromAEMaps(state);

		return aeUnqYrs;
	}

	@RequestMapping(value = "/ae/elections/", method = RequestMethod.GET)
	public @ResponseBody List<AEMaps> getAEMapsBasedOnStateYr(@RequestParam(value = "state") String state,
			@RequestParam(value = "year") int year) {
		logger.info("Inside getAllUniqStatesFromAEMaps() method...");

		List<AEMaps> aeMapsStateYrs = aeMapsRepository.findAEMapsBasedonStatYrs(state, year);

		return aeMapsStateYrs;
	}
	
	@RequestMapping(value = "/ae/partieslist/", method = RequestMethod.GET)
	public @ResponseBody List<AEMaps> getUnqPariesBasedOnStateYr(@RequestParam(value = "state") String state,
			@RequestParam(value = "year") int year) {
		logger.info("Inside getAllUniqStatesFromAEMaps() method...");

		List<AEMaps> aeUnqParts = aeMapsRepository.findUnqPariesBasedOnStateYr(state, year);

		return aeUnqParts;
	}
	
	@RequestMapping(value = "/ae/elections/position/", method = RequestMethod.GET)
	public @ResponseBody List<AEMaps> getAEMapsBasedOnStateYrPostn(@RequestParam(value = "state") String state,
			@RequestParam(value = "year") int year, @RequestParam(value = "position") int position) {
		logger.info("Inside getAllUniqStatesFromAEMaps() method...");

		List<AEMaps> aeMapsStateYrPstn = aeMapsRepository.findAEMapsBasedonStatYrsPostn(state, year, position);

		return aeMapsStateYrPstn;
	}
}
