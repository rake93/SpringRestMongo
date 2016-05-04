package com.infosys.rakesh.springmongo.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.infosys.rakesh.springmongo.model.AEMaps;
import com.mongodb.BasicDBObject;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class AEMapsRepository {

	private static final Logger logger = LoggerFactory.getLogger(AEMapsRepository.class);

	private static final String COLLECTION_NAME = "ae_maps";

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<AEMaps> findAllMaps() {
		logger.info("Inside findAllMaps methode of AEMapsRepository calss.....");
		return mongoTemplate.findAll(AEMaps.class, COLLECTION_NAME);
	}

	public List<AEMaps> findUniqStatesFromAEMaps() {

		logger.info("Inside findUniqStatesFromAEMaps methode of AEMapsRepository calss.....");
		return mongoTemplate.getCollection(COLLECTION_NAME).distinct("state");

	}

	public List<AEMaps> findUniqYearFromAEMaps(String state) {

		logger.info("Inside findUniqYearFromAEMaps methode of AEMapsRepository calss.....");
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.append("state", state);
		return mongoTemplate.getCollection(COLLECTION_NAME).distinct("year", basicDBObject);
	}

	public List<AEMaps> findAEMapsBasedonStatYrs(String state, int year) {

		logger.info("Inside findAEMapsBasedonStatYrs methode of AEMapsRepository calss....." + state + " === "
				+ Integer.valueOf(year));

		return mongoTemplate.find(query(where("state").is(state).and("year").is(Integer.valueOf(year))), AEMaps.class,
				COLLECTION_NAME);
	}

	public List<AEMaps> findUnqPariesBasedOnStateYr(String state, int year) {

		logger.info("Inside findUnqPariesBasedOnStateYr methode of AEMapsRepository calss.....");

		Query query = new Query();
		query.addCriteria(Criteria.where("state").is(state).and("year").is(Integer.valueOf(year)));

		return mongoTemplate.getCollection(COLLECTION_NAME).distinct("party1", query.getQueryObject());
	}

	public List<AEMaps> findAEMapsBasedonStatYrsPostn(String state, int year, int position) {

		logger.info("Inside findUniqYearFromAEMaps methode of AEMapsRepository calss.....");
		return mongoTemplate.find(query(where("state").is(state).and("year").is(Integer.valueOf(year)).and("position").is(position)), AEMaps.class,
				COLLECTION_NAME);
	}
}
