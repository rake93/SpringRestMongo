package com.infosys.rakesh.springmongo.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.infosys.rakesh.springmongo.model.AECntstdDpstLost;
import com.infosys.rakesh.springmongo.model.AEMaps;
import com.infosys.rakesh.springmongo.model.AEPartiesCntests;
import com.infosys.rakesh.springmongo.model.AESeatShares;
import com.infosys.rakesh.springmongo.model.AEVoteShares;
import com.infosys.rakesh.springmongo.model.AEVotrTurnOuts;
import com.infosys.rakesh.springmongo.model.AEWomens;
import com.mongodb.BasicDBObject;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class AEMapsRepository {

	private static final Logger logger = LoggerFactory.getLogger(AEMapsRepository.class);

	private static final String AE_MAPS = "ae_maps";
	private static final String AE_CONTESTED_DEPOSIT_LOSTS = "ae_contested_deposit_losts";
	private static final String AE_PARTIES_CONTESTS = "ae_parties_contests";
	private static final String AE_SEATSHARES = "ae_seatshares";
	private static final String AE_VOTESHARES = "ae_voteshares";
	private static final String AE_VOTER_TURNOUTS = "ae_voter_turnouts";
	private static final String AE_WOMENS = "ae_womens";

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<AEMaps> findAllMaps() {
		logger.info("Inside findAllMaps methode of AEMapsRepository calss.....");
		return mongoTemplate.findAll(AEMaps.class, AE_MAPS);
	}

	public List<AEMaps> findUniqStatesFromAEMaps() {

		logger.info("Inside findUniqStatesFromAEMaps methode of AEMapsRepository calss.....");
		return mongoTemplate.getCollection(AE_MAPS).distinct("state");

	}

	public List<AEMaps> findUniqYearFromAEMaps(String state) {

		logger.info("Inside findUniqYearFromAEMaps methode of AEMapsRepository calss.....");
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.append("state", state);
		return mongoTemplate.getCollection(AE_MAPS).distinct("year", basicDBObject);
	}

	public List<AEMaps> findAEMapsBasedonStatYrs(String state, int year) {

		logger.info("Inside findAEMapsBasedonStatYrs methode of AEMapsRepository calss....." + state + " === "
				+ Integer.valueOf(year));

		return mongoTemplate.find(query(where("state").is(state).and("year").is(Integer.valueOf(year))), AEMaps.class,
				AE_MAPS);
	}

	public List<AEMaps> findUnqPariesBasedOnStateYr(String state, int year) {

		logger.info("Inside findUnqPariesBasedOnStateYr methode of AEMapsRepository calss.....");

		Query query = new Query();
		query.addCriteria(Criteria.where("state").is(state).and("year").is(Integer.valueOf(year)));

		return mongoTemplate.getCollection(AE_MAPS).distinct("party1", query.getQueryObject());
	}

	public List<AEMaps> findAEMapsBasedonStatYrsPostn(String state, int year, int position) {

		logger.info("Inside findUniqYearFromAEMaps methode of AEMapsRepository calss.....");
		return mongoTemplate.find(query(where("state").is(state).and("year").is(Integer.valueOf(year)).and("position").is(position)), AEMaps.class,
				AE_MAPS);
	}
	
	public List<AECntstdDpstLost> findAECntstddDpstLost() {
		logger.info("Inside AECntstddDpstLost methode of AEMapsRepository calss.....");
		return mongoTemplate.findAll(AECntstdDpstLost.class, AE_CONTESTED_DEPOSIT_LOSTS);
	}
	
	public List<AEPartiesCntests> findAEPartiesCntests() {
		logger.info("Inside findAEPartiesCntsts methode of AEMapsRepository calss.....");
		return mongoTemplate.findAll(AEPartiesCntests.class, AE_PARTIES_CONTESTS);
	}
	
	public List<AESeatShares> findAESeatShares() {
		logger.info("Inside findAESeatShares methode of AEMapsRepository calss.....");
		return mongoTemplate.findAll(AESeatShares.class, AE_SEATSHARES);
	}
	
	public List<AEVoteShares> findAEVoteShares() {
		logger.info("Inside findAEVoteShares methode of AEMapsRepository calss.....");
		return mongoTemplate.findAll(AEVoteShares.class, AE_VOTESHARES);
	}
	
	public List<AEVotrTurnOuts> findAEVotrTurnOuts() {
		logger.info("Inside findAEVotrTurnOuts methode of AEMapsRepository calss.....");
		return mongoTemplate.findAll(AEVotrTurnOuts.class, AE_VOTER_TURNOUTS);
	}
	
	public List<AEWomens> findAEWomens() {
		logger.info("Inside findAEWomens methode of AEMapsRepository calss.....");
		return mongoTemplate.findAll(AEWomens.class, AE_WOMENS);
	}
	
}
