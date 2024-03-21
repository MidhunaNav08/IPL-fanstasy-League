package com.Match.IPL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Match.IPL.entity.BidEntity;
@Repository
public interface BidDetailsRepository extends JpaRepository<BidEntity, Integer>{

}
