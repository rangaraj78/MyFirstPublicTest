package com.rangaraj.sample.jpa;

import com.rangaraj.sample.dbmodel.User;

/**
 * This is the UserRepository class using Spring data to access the db table
 * @author rangarajthangadurai
 *
 */
public interface UserRepository extends BaseRepository<User, Long> {

}