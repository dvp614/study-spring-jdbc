package org.zerock.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.Message;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@NoArgsConstructor

@RequestMapping("/messages/")
@RestController
public class MessageController {
	@Autowired(required = true)
	private JdbcTemplate jdbctemplate;
	
//		this.jdbctemplate.query(sql, rowMapper);
//		this.jdbctemplate.update(sql);
	
	@GetMapping("/findAllMessages")
	List<Message> findAllMessages(){
		log.trace("findAllMessages() invoked.");
		
		final String sql = "SELECT * FROM message ORDER BY id DESC";
		
		List<Message> list = this.jdbctemplate.<Message>query(sql, (rs, i) -> {
			log.info("\t+ RowMapper::mapRow({}, {}) invoked.", rs, i);
			
			Integer id = rs.getInt("id");
			String text = rs.getString("text");
			
//			return new Message(id, text);
			Message m = new Message();
			
			m.setId(id);
			m.setText(text);
			
			return m;
		}); // query
		
		return list;
	} // findAllMessages
	
	
	@PostMapping("/insertMessage")
	Boolean insertMessage(@RequestBody Message message) {
		log.trace("insertMessgae({}) invoked.", message);
		
		String sql = "INSERT INTO message (text) VALUES(?)";
		int affectedRows = this.jdbctemplate.update(sql, message.getText());
		
		return (affectedRows == 1);
	} // insertMessage 
	
} // end class
