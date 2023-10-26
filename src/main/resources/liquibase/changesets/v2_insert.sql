
insert into address(username, country, city, street, contact_number, working_hours) VALUES ('unknown', 'belarus', 'minsk', 'Pushkina avenue','90234123', '12-23');
insert into landmarks(title, description, address_id, total_stars, review_counter) VALUES ('landmark1', 'description', 1, 10, 3);
insert into events(title, description, date_of_publishment, date_of_event, address_id, total_stars, review_counter) VALUES ('event', 'event desc', current_timestamp, current_timestamp, 1, 32, 12)